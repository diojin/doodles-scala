package outerhaven.algorithm.basic.sorting

import scala.collection.mutable.Queue

object RadixSort extends App {
  val algorithmName = "radix sort"
  val input = Array("207", "095", "646", "198", "809", "376", "917", "534", "310", "209",
    "181", "595", "799", "694", "334", "522", "139")

  printf("before start sort algorithm: %s\n", algorithmName)
  println(input.mkString(","))
  radixSort(input, 10)
  printf("after sort algorithm: %s\n", algorithmName)
  println(input.mkString(","))
  
  def radixSort(source: Array[String], radix: Int) {
    val allData = new Queue[String]
    source.foreach { allData += _}
    
    val radixQueues = new Array[Queue[String]](radix)
    for ( i <- 0 to radixQueues.length - 1 ){
      radixQueues(i) = new Queue[String]
    }
    
    val length = source(0).length()
    var curElement: String = null
    for ( i <- length -1 to (0, -1)  ){
      radixQueues.foreach { _.clear() }
      while ( ! allData.isEmpty ){
        curElement = allData.dequeue()
        radixQueues(curElement(i).toString().toInt) += curElement
      }
      radixQueues.foreach { allData ++= _ }
    }   
    for ( i <- 0 to source.length - 1 ){
      source(i) = allData.dequeue()
    }
  }

}