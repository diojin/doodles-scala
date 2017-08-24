package outerhaven.algorithm.basic.structure

class BinaryTreeNode(var data: Int = -1, var left: BinaryTreeNode = null, var right: BinaryTreeNode = null) 
extends Node{
  override def toString() = {
    data.toString()
  }
}

object BinaryTreeNode {
  def apply(data: Int = -1, left: BinaryTreeNode = null, right: BinaryTreeNode = null) 
    = new BinaryTreeNode(data, left, right)
}