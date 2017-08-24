package outerhaven.algorithm.basic.structure

object BinaryTreeTestCases extends App {
  testFather
  testInorder
  testPreorder
  testPostorder
  testCopyTree
  
  def testFather {
    println("### find parent node")
    println(binaryTree.father(binaryTree.root.left.right))
  }
  
  def testInorder {
    println("### inorder traverse tree")
    binaryTree.inorder(binaryTree.root)
    println("### inorder traverse tree by stack")
    binaryTree.inorderStack(binaryTree.root)
  }
  
  def testPreorder {
    println("### preorder traverse tree")
    binaryTree.preorder(binaryTree.root)
    println("### preorder traverse tree by stack")
    binaryTree.preorderStack(binaryTree.root)
  }
    
  def testPostorder {
    println("### postorder traverse tree")
    binaryTree.postorder(binaryTree.root)
    println("### test postorder by using stack")
    binaryTree.postorderStack(binaryTree.root)
    
  }
  
  def testCopyTree {
    println("### test copy tree")
    val newTree = binaryTree.clone()
    newTree.root.data = 80
    newTree.postorder(newTree.root)
    println("original tree")
    binaryTree.postorder(binaryTree.root)
  }
}