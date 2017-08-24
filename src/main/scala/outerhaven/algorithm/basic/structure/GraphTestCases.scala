package outerhaven.algorithm.basic.structure

object GraphTestCases extends App {
  depthFirstSearchTest
  minDistEachVertex
  
  def depthFirstSearchTest {
    println("### depth first search test")
    aoeGraph.depthFirstSearch
    
    println("### depth first search by stack test")
    aoeGraph.depthFirstSearchStack()
    
    println("### depth first search by stack impl 2 test")
    aoeGraph.depthFirstSearchStackImp2()
    
    println("### depth first search by stack impl 3 test")
    aoeGraph.depthFirstSearchStackImp3()
    
    println("### level order traversal")
    aoeGraph.widthFirstSearch()
    
    println("### topo order")
    aoeGraph.topoOrder().foreach(println _)   
    
  }
  
  def minDistEachVertex(){
    println("### test min dist of each vertex ")
    val path: Array[Array[Int]] = Array.ofDim(aoeMatrixGraph.edges.length, aoeMatrixGraph.edges.length)
    val dist = aoeMatrixGraph.eachVertexesMinDist(path)
    for (i <- 0 to dist.length-1){
      println(dist(i).map(x =>  if ( x == Int.MaxValue ) -1 else x ).mkString(","))
    }
    for (i <- 0 to path.length - 1){
      println(path(i).mkString(","))
    }
  }
  
}