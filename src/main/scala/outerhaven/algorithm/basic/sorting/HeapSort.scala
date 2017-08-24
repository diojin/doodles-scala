package outerhaven.algorithm.basic.sorting

object HeapSort extends App with SortAlgorithm {
  val algorithmName = "HeapSort"  
  launch(dataset)
  
  def restore[T](source: Array[T], start : Int, end: Int)(implicit ev: T <:< Ordered[T]){
    var i = start
    while( i <= (math.floor((end - 1)/2)).toInt ){
      var largerChild = 2 * i + 1
      if ( 2 * i + 2 <= end && source(2*i+2) > source(largerChild) ){
        largerChild = 2*i + 2
      }
      if (source(i) > source(largerChild) ){
        i = end  // create the effect of leaving loop
      }else{
        var tmp = source(i)
        source(i) = source(largerChild)
        source(largerChild) = tmp
        i = largerChild
      }
    }
  }
  
  def sort[T](source: Array[T])(implicit ev: T <:< Ordered[T]){
    // initiating the heap
    for ( i <- (math.floor((source.length -1)/2).toInt) to (0, -1) ){
      restore(source, i, source.length -1)
    }
    
    // sort
    for ( i<- source.length -1 to (1, -1) ){
      var tmp = source(i)
      source(i) = source(0)
      source(0) = tmp
      restore(source, 0, i-1)
    }
  }
 
}