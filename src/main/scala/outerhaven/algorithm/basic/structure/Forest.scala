package outerhaven.algorithm.basic.structure

import scala.collection.mutable.Stack

class Forest(myroot: TreeNode ) extends Tree(myroot) {
  
  override def preorder(begin: TreeNode){
    var k = begin
    while ( null != k ){
      preorderInternal(k)
      k = k.nextBrother
    }
  }
  
  def preorderInternal(begin: TreeNode){
    if ( null != begin ){
      println(begin)
      var k = begin.firstChild
      while ( k != null ){
        preorderInternal(k)
        k = k.nextBrother      
      }
    }
  }
  
  
  override def preorderStack(begin: TreeNode) {
    val stack = new Stack[TreeNode]
    var k = begin
    do {
      while (null != k) {
        println(k)
        stack.push(k)
        k = k.firstChild
      }
      if (stack.nonEmpty) {
        k = stack.pop()
      }
      if (k != null) {
        k = k.nextBrother
      }
    } while (stack.nonEmpty || k != null)
  } 
}

object Forest {
  def apply(root: TreeNode) = new Forest(root)
}