package outerhaven.algorithm.basic.structure

import scala.collection.mutable.HashMap
import scala.collection.mutable.Stack

class BinaryTree {
  var root: BinaryTreeNode = null
  var current: BinaryTreeNode = null
  def this(root: BinaryTreeNode) {
    this()
    this.root = root
  }
  
  def father(node: BinaryTreeNode) = fatherInternal(node, root)
  
  private def fatherInternal( node: BinaryTreeNode, candidate: BinaryTreeNode ): BinaryTreeNode = {
    if ( node == null || node == root || candidate == null ) {
      null
    }else if ( candidate.left == node || candidate.right == node ){
      candidate
    }else {
      val leftCandidate = fatherInternal(node, candidate.left)
      if ( null != leftCandidate ){
        leftCandidate
      }else{
        fatherInternal(node, candidate.right)
      }
    }
  }
  
  def inorder( begin: BinaryTreeNode ) {
    if ( null != begin ){
      inorder(begin.left)
      println(begin.data)
      inorder(begin.right)
    }
  }
  
  def inorderStack (begin: BinaryTreeNode ){
    val stack = new Stack[BinaryTreeNode]
    var cur = begin
    do {
      while ( cur != null ){
        stack.push(cur)
        cur = cur.left
      }
      
      cur = stack.pop()
      if ( cur != null ){
        println(cur)
        cur = cur.right
      }   
      
    }while (stack.nonEmpty || cur != null)
  }
  
  def preorder( begin: BinaryTreeNode ) {
    if ( null != begin ){
      println(begin.data)
      preorder(begin.left)      
      preorder(begin.right)
    }
  }
  
  def preorderStack( begin: BinaryTreeNode ){
    val stack = new Stack[BinaryTreeNode]
    var cur = begin
    stack.push(cur)
    while (stack.nonEmpty) {
      cur = stack.pop()
      if ( null != cur ){
        println(cur)
        stack.push(cur.right)
        stack.push(cur.left)
      }
    }
  }
  
  def postorder( begin: BinaryTreeNode ) {
    if ( null != begin ){      
      postorder(begin.left)      
      postorder(begin.right)
      println(begin.data)
    }
  }
  
  def postorderStack( begin: BinaryTreeNode ){
    val visitedCount = new HashMap[BinaryTreeNode, Int]
    var vCount = 0
    val stack = new Stack[BinaryTreeNode]
    visitedCount.put(begin, vCount)
    stack.push(begin)
    while ( stack.nonEmpty ){
      var cur = stack.pop()
      if ( visitedCount.getOrElse(cur, 0) == 0 ){
        // non visited node, push back, actually can merely peek the top value
        stack.push(cur)
        if ( null != cur.right ) {
          visitedCount.put(cur.right, 0)
          stack.push(cur.right)
        }
        if ( null != cur.left ){
          visitedCount.put(cur.left, 0)
          stack.push(cur.left)
        }
        visitedCount(cur) = 2
      }else{
        println(cur)
      }      
    }    
  }
  
  override def clone() = {
    BinaryTree(copySubTree(root))
  }
  
  private def copySubTree( cur: BinaryTreeNode ): BinaryTreeNode = {
    if ( null == cur ){
      null
    }else{
      BinaryTreeNode(cur.data, 
          copySubTree(cur.left),
          copySubTree(cur.right))
    }
  }
}

object BinaryTree {
  def apply( root: BinaryTreeNode) = new BinaryTree(root)
}