package outerhaven.algorithm.misc

import scala.collection.mutable.ArrayBuffer

object RemoveArrayElement extends App{
  
  removeAllButFirstNegativeEfficient
  
  removeAllButFirstNegativeInefficient
  
  /**
   * Given an array buffer of integers, 
   * we want to remove all but the first negative number
   */
  def removeAllButFirstNegativeEfficient () {
    println("### removeAllButFirstNegativeEfficient")
    
    val dataset = ArrayBuffer(1, 2, -3, 4, -5, 6, 7, -9 )
    println("input array:\t" + dataset)
    var first = true
    val indexSet = for ( i <- 0 until dataset.length if first || dataset(i) >= 0) yield {
      if ( dataset(i) < 0 ) first = false ; i     
    }
    for ( i <- 0 until indexSet.length ) {
      dataset(i) = dataset(indexSet(i))
    }
    dataset.trimEnd(dataset.length - indexSet.length)
    println("result:\t"+dataset)
  }
  
  /**
   * Given an array buffer of integers, 
   * we want to remove all but the first negative number
   */
  def removeAllButFirstNegativeInefficient (){
    println("removeAllButFirstNegativeInefficient")
    val dataset = ArrayBuffer(1, 2, -3, 4, -5, 6, 7, -9 )
    println("input array:" + dataset)
    var first = true
    var i = 0
    while (i < dataset.length){
      if ( dataset(i) < 0 ){
        if ( first ){
          first = false; i += 1
        }else{
          dataset.remove(i);
        }
      }else {
        i += 1
      }
    }
    println("result:\t" + dataset)
  }
  
}