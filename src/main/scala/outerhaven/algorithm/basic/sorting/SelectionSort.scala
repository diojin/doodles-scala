package outerhaven.algorithm.basic.sorting

object SelectionSort extends App with SortAlgorithm{
  val algorithmName = "selection sort"  
  launch(dataset)
  
  def sort[T](source: Array[T])(implicit ev: T <:< Ordered[T]){ 
    for ( i <- source.length -1 to (1, -1) ){
      var max = 0
      for ( j <- 1 to i ){
        if ( source(j) >= source(max) ){        // use >= instead of > to improve stability
           max = j
        }
      }
      var tmp = source(i)
      source(i) = source(max)
      source(max) = tmp
    }
  }
}