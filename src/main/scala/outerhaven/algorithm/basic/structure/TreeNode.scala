package outerhaven.algorithm.basic.structure

class TreeNode(var data: Int = -1, var firstChild: TreeNode = null, var nextBrother: TreeNode = null) 
extends Node{
  override def toString() = {
    data.toString()
  }
}

object TreeNode {
  def apply(data: Int = -1, firstChild: TreeNode = null, rightBrother: TreeNode = null) 
    = new TreeNode(data, firstChild, rightBrother)
}