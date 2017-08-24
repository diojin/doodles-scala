package outerhaven.algorithm.basic.structure
import collection.mutable.Stack
import collection.mutable.Queue
import collection.mutable.HashMap

class Tree {
  var root: TreeNode = null
  var current: TreeNode = null
  def this(root: TreeNode) {
    this()
    this.root = root
  }
  
  def preorder(begin: TreeNode){
    if ( null != begin ){
      println(begin)
      var k = begin.firstChild
      while ( k != null ){
        preorder(k)
        k = k.nextBrother      
      }
    }
  }

  def preorderStack(begin: TreeNode) {
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
    } while (stack.nonEmpty)
  }
  
  def levelOrder(begin: TreeNode){
    val queue = new Queue[TreeNode]
    var k = begin
    while ( k != null ){
      queue.enqueue(k)
      k = k.nextBrother
    }
    
    while ( queue.nonEmpty ){
      k = queue.dequeue()
      println(k)
      if ( k != null ){
        k = k.firstChild
        while( k != null ){
          queue.enqueue(k)
          k = k.nextBrother
        }
      }
    }
  }
}
object Tree {
  def apply( root: TreeNode) = new Tree(root)
}