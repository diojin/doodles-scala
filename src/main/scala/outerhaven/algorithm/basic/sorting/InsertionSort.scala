package outerhaven.algorithm.basic.sorting

object InsertionSort extends App with SortAlgorithm {
  val algorithmName = "insertion sort"  
  launch(dataset)

  def sort[T](source: Array[T])(implicit ev: T <:< Ordered[T]) {
    var i = 1
    var j = 0
    while ( i < source.length ){
      j = i
      var tmp = source(j)
      while ( j > 0 && source(j-1) > tmp) {
        source(j) = source(j - 1)
        j -= 1
      }
      source(j) = tmp      
      i += 1
    }
  }    
}