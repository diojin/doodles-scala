package outerhaven.algorithm.basic.structure

object TreeTestCases extends App{
  testPreorder
  testLevelOrder
  
  def testPreorder {
    println("### test preorder")
    tree.preorder(tree.root)
    println("### test preorder by using stack")
    tree.preorderStack(tree.root)
    
    println("### test forest preorder")
    forest.preorder(forest.root)
    println("### test forest preorder by using stack")
    forest.preorderStack(forest.root)    
  }
  
  def testLevelOrder {
    println("### test level order")
    tree.levelOrder(tree.root)
    
    println("### test forest level order")
    forest.levelOrder(forest.root)
  }
}