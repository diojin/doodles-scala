package outerhaven.algorithm.basic.structure

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Stack
import scala.collection.mutable.Queue

trait Graph {
  
}

/**
 * edges:  n * n matrix of edges
 * vertexList: a array contains all vertex values
 */
class AdjacentMatrixGraph(val edges: Array[Array[Int]], val vertexList: Array[Int] = null) extends Graph {
  def eachVertexesMinDist( path: Array[Array[Int]] ) : Array[Array[Int]] = {
    val dist: Array[Array[Int]] = Array.ofDim(edges.length, edges.length)
    // the last vertex to vertex j in path Vi -> Vj
    for ( i <- 0 to edges.length-1 ){
      for ( j <- 0 to edges(i).length-1 ){
        dist(i)(j) = edges(i)(j)
        path(i)(j) = -1
        if ( edges(i)(j) == Int.MinValue ){
          dist(i)(j) = Int.MaxValue
        }else{
          path(i)(j) = i
        }
        
      }
    }

    for (k <- 0 to dist.length - 1) {
      for (i <- 0 to dist.length - 1) {
        if (i != k) {
          for (j <- 0 to dist.length - 1) {
            if (j != k && i != j && 
                dist(i)(k) < Int.MaxValue && dist(k)(j) < Int.MaxValue && 
                ( dist(i)(k) + dist(k)(j) < dist(i)(j) ) ) {
              dist(i)(j) = dist(i)(k) + dist(k)(j)
              path(i)(j) = path(k)(j)
            }
          }
        }

      }
    }
    dist
  }
}
object AdjacentMatrixGraph {
  def apply(edges: Array[Array[Int]], vertexList: Array[Int] = null) = 
    new AdjacentMatrixGraph(edges, vertexList)
}

class AdjacentArrayGraph( val vertexes : ArrayBuffer[AdjacentArrayGraph.VertexNode] = null) extends Graph {
  def depthFirstSearch {
    val visited = new Array[Int](vertexes.size)
    for (i <- 0 to visited.length -1 ){
      visited(i) = 0
    }
    depthFirstSearchInner(0, visited)
  }
  def depthFirstSearchInner( index: Int, visited: Array[Int] ){
    if ( visited(index) == 0 ){
      println(vertexes(index))
      visited(index) = 1
      var adjVer = vertexes(index).next
      while( null != adjVer ){
        if ( visited(adjVer.verAdj) == 0 ){
          depthFirstSearchInner(adjVer.verAdj, visited)
        }        
        adjVer = adjVer.next
      }
    }
  }
  
  /**
   * a variant of preorder traversal algorithm of binary tree by stack 
   */
  def depthFirstSearchStack() {
    val visited = new Array[Int](vertexes.size)
    for (i <- 0 to visited.length -1 ){
      visited(i) = 0
    }
    val stack = Stack[Int]()
    var cur = 0
    var nextNotVisited:AdjacentArrayGraph.EdgeNode = null
    do{
      while ( cur >= 0 && cur < vertexes.size && visited(cur) == 0){
        println(vertexes(cur))
        visited(cur) = 1
        stack.push(cur)
        if (vertexes(cur).next == null){
          cur = -1
        }else{
          cur = vertexes(cur).next.verAdj
        }        
      }
      cur = stack.pop()
      
      // if children of current node aren't all visited, push current
      // node back to stack so that not visited children can be visited later
      var allChildVisited = true
      nextNotVisited = vertexes(cur).next
      while ( allChildVisited && nextNotVisited != null ){
        if ( visited(nextNotVisited.verAdj) == 0 ){
          allChildVisited = false
        }else{
          nextNotVisited = nextNotVisited.next
        }        
      }
      if ( allChildVisited ){
        cur = -1
      }else{
        stack.push(cur)
        cur = nextNotVisited.verAdj        
      }
      
    }while ( stack.nonEmpty )    
  }
  
  /**
   * simpler than 1st implementation
   */
  def depthFirstSearchStackImp2() {
    val visited = new Array[Int](vertexes.size)
    for (i <- 0 to visited.length -1 ){
      visited(i) = 0
    }
    val stack = Stack[Int]()
    var cur = 0
    stack.push(cur)
    while ( stack.nonEmpty ){
      cur = stack.pop()
      if ( visited(cur) == 0 ){
        println(cur)
        visited(cur) = 1        
      }
      var nextChild = vertexes(cur).next
      while ( nextChild != null && visited(nextChild.verAdj) == 1){
        nextChild = nextChild.next
      }
      if (null != nextChild){
        stack.push(cur)
        cur = nextChild.verAdj
        stack.push(cur)
      }           
    }    
  }

  /**
   * much simpler and elegant
   */
  def depthFirstSearchStackImp3() {
    val visited = new Array[Int](vertexes.size)
    for (i <- 0 to visited.length - 1) {
      visited(i) = 0
    }
    val stack = Stack[Int]()
    var cur = 0
    stack.push(cur)
    while (stack.nonEmpty) {
      cur = stack.pop()
      if (visited(cur) == 0) {
        println(cur)
        visited(cur) = 1
        
        // push into stack in reverse order
        var nextChild = vertexes(cur).next
        val reverseStack = new Stack[AdjacentArrayGraph.EdgeNode]()
        while (nextChild != null){
          reverseStack.push(nextChild)
          nextChild = nextChild.next
        }
  
        while (reverseStack.nonEmpty) {
          stack.push(reverseStack.pop().verAdj)
        }
      }
    }
  }
  
  def widthFirstSearch() {
    val visited = new Array[Int](vertexes.size)
    for (i <- 0 to visited.length -1 ){
      visited(i) = 0
    }
    val queue = new Queue[Int]()
    var cur = 0
    queue.enqueue(cur)
    while( queue.nonEmpty ){
      cur = queue.dequeue()
      if ( visited(cur) == 0 ){
        visited(cur) = 1
        println(cur)
      }
      var nextChild = vertexes(cur).next
      while ( nextChild != null){
        if ( visited(nextChild.verAdj) == 0 ){
          queue.enqueue(nextChild.verAdj)
        }
        nextChild = nextChild.next
      }
    }
  }
  
  def topoOrder(): ArrayBuffer[Int] = {
    // initiate an array of in-degree of all vertexes
    val indegree = new Array[Int](vertexes.size)
    val result = new ArrayBuffer[Int]
    
    for (i <- indegree){
      indegree(i) = 0
    }
    for ( i <- vertexes ){
      var child = i.next
      while ( child != null ){
        indegree(child.verAdj) += 1 
        child = child.next
      }
    }
    // use array to simulate a stack, top is the top of the stack
    var top = -1
    for ( i <- 0 to indegree.length - 1 ){
      if ( indegree(i) == 0 ){
        // a typical stack-in operation by array simulation
        indegree(i) = top
        top = i
      }
    }
    
    val maxRound = vertexes.length
    for ( i <- 1 to maxRound ){
      if ( top != -1 ){
        // a typical stack-out operation by array simulation
        var cur = top
        top = indegree(top)
        result += cur
        
        // "delete" cur vertex, update indegree of the rest vertexes 
        var child = vertexes(cur).next
        while(child != null){
          indegree(child.verAdj) -= 1
          if ( indegree(child.verAdj) == 0 ){
            indegree(child.verAdj) = top
            top = child.verAdj
          }          
          child = child.next
        }
      }else{
        throw new RuntimeException("there is a circurt")
      }
    }
    result
  }
}

object AdjacentArrayGraph {
  def apply(vertexes : ArrayBuffer[AdjacentArrayGraph.VertexNode] = null) = new AdjacentArrayGraph(vertexes)
  class EdgeNode(var verAdj: Int, var weight: Int = -1, var next: EdgeNode = null) extends Node {
    val data: Int = verAdj 
    override def compare(that: Node) = {
      weight - that.asInstanceOf[EdgeNode].weight
    }
    override def toString = String.format("(%d, %d)", verAdj.asInstanceOf[AnyRef], weight.asInstanceOf[AnyRef])    
  }
  object EdgeNode{
    def apply(verAdj: Int, weight: Int = -1, next: EdgeNode = null) = new EdgeNode(verAdj, weight, next)
  }
  
  class VertexNode(var verName: Int = -1, var next: EdgeNode = null) extends Node {
    val data: Int = verName 
    override def toString() = verName.toString()
    override def compare(that: Node) = {
      verName - that.asInstanceOf[VertexNode].verName
    }
  }
  object VertexNode{
    def apply(verName: Int, next: EdgeNode = null) = new VertexNode(verName, next)
  }  
}