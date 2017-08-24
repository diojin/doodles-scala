package outerhaven.algorithm.basic
import scala.collection.mutable.ArrayBuffer

package object structure {
  
  /**
   * The structure of binaryTree is:
   * 									83
   * 							/				\
   * 					9								20
   *			 /		 \ 
   * 		10				 25 
   * 
   */
  
  val binaryTree: BinaryTree = BinaryTree(
      BinaryTreeNode(83, 
        BinaryTreeNode(9, BinaryTreeNode(10), BinaryTreeNode(25)),
        BinaryTreeNode(20)))

  /**
   * The structure of tree is:
   * 									83															
   * 							/		|		\											
   * 					9				5				20						
   *			 /		 \ 												
   * 		10				 25 								
   * 
   */
  
  val tree: Tree = Tree(
        TreeNode( 83, 
            TreeNode(9, 
                TreeNode(10, null, TreeNode(25)), 
                TreeNode(5, null, TreeNode(20))), 
            null           
        )       
      )        
        
  /**
   * The structure of forest is:
   * 									83																86
   * 							/		|		\												/		  |		\
   * 					9				5				20							10				7			24
   *			 /		 \ 												 /		  \
   * 		10				 25 								 11						1
   * 
   */
  
  val forest: Forest = Forest(
        TreeNode( 83, 
            TreeNode(9, 
                TreeNode(10, null, TreeNode(25)), 
                TreeNode(5, null, TreeNode(20))), 
            TreeNode(86, 
                TreeNode(10,
                    TreeNode(11,null,TreeNode(1)),
                    TreeNode(7,null,TreeNode(24))),
                null)
        )       
  )
  
/**
 * 
 * 
 * 
 */
  val simpleDGraph: Graph = null
  
/**
 * AOE Graph Example:
 * 							T1														T6
 * 					 ^			\											^				\
 * 					/					a3=1							/						a10=2
 *			a0=6 							\				a7=9										\
 * 		/										 v		/														v
 * T0													T4															T8
 * \		\ 								 ^		\														^
 *	\   	a1=4						/				a8=8										/
 * 	 \			\				 a4=1								\						a11=4
 * 		\ 		 v 		 /											v				/
 * 		 \				T2														T7
 * 			\ 				 \												^
 *			a2=5  			 a5=1									/
 * 				\ 							\					a9=4
 * 				\    						 v			/	
 * 				\   								T5
 *				 \    						^
 * 					\							 /
 * 					 \ 				a6=2
 * 						v			/
 * 							T3
 * 
 */ 
  val aoeGraph: AdjacentArrayGraph = {
    val vertexes  = new ArrayBuffer[AdjacentArrayGraph.VertexNode]()
    var edge = AdjacentArrayGraph.EdgeNode(1, 6, 
                  AdjacentArrayGraph.EdgeNode(2, 4,
                      AdjacentArrayGraph.EdgeNode(3, 5, null)))
    vertexes += AdjacentArrayGraph.VertexNode(0, edge)  
    
    edge = AdjacentArrayGraph.EdgeNode(4, 1, null)
    vertexes += AdjacentArrayGraph.VertexNode(1, edge)
    
    edge = AdjacentArrayGraph.EdgeNode(4, 1, 
              AdjacentArrayGraph.EdgeNode(5, 1, null))
    vertexes += AdjacentArrayGraph.VertexNode(2, edge)
    
    edge = AdjacentArrayGraph.EdgeNode(5, 2, null)
    vertexes += AdjacentArrayGraph.VertexNode(3, edge)
    
    edge = AdjacentArrayGraph.EdgeNode(6, 9,
              AdjacentArrayGraph.EdgeNode(7, 8, null))              
    vertexes += AdjacentArrayGraph.VertexNode(4, edge)
    
    edge = AdjacentArrayGraph.EdgeNode(7, 4, null)
    vertexes += AdjacentArrayGraph.VertexNode(5, edge)
    
    edge = AdjacentArrayGraph.EdgeNode(8, 2, null)
    vertexes += AdjacentArrayGraph.VertexNode(6, edge)
    
    edge = AdjacentArrayGraph.EdgeNode(8, 4, null)
    vertexes += AdjacentArrayGraph.VertexNode(7, edge)
    
    vertexes += AdjacentArrayGraph.VertexNode(8, null)
    
    AdjacentArrayGraph(vertexes)    
  }
  
  val aoeMatrixGraph: AdjacentMatrixGraph = {
    val vers = Array(0, 1, 2, 3, 4, 5, 6, 7, 8)
    val matrix: Array[Array[Int]] = Array.ofDim(9, 9)
    for ( i <- 0 until matrix.length ){
      for( j <- 0 until matrix(i).length ){
        matrix(i)(j) = Int.MinValue
        if ( i == j ){
          matrix(i)(j) = 0
        }
      }
    }
    
    matrix(0)(1) = 6
    matrix(0)(2) = 4
    matrix(0)(3) = 5
    matrix(1)(4) = 1
    matrix(2)(4) = 1
    matrix(2)(5) = 1
    matrix(3)(5) = 2
    matrix(4)(6) = 9
    matrix(4)(7) = 8
    matrix(5)(7) = 4
    matrix(6)(8) = 2
    matrix(7)(8) = 4
    
    AdjacentMatrixGraph(matrix, vers)
  }
    
}