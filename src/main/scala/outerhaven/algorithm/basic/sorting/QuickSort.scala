package outerhaven.algorithm.basic.sorting

object QuickSort extends App with SortAlgorithm {
  val algorithmName = "quick sort"  
  launch(dataset)

  def sort[T](source: Array[T])(implicit ev: T <:< Ordered[T]) {
    quickSort(source, 0, source.length-1)
  }
  
  def quickSort[T](source: Array[T], start: Int, end: Int)(implicit ev: T <:< Ordered[T]) {
    if ( start < end ){
      var target = start
      var left = start
      var right = end + 1
      while( left < right ){
        left += 1
        while( source(left) < source(target) ){      // if use <= instead of <, index "left" may be outbound
          left += 1
        }
        right -= 1
        while( source(right) > source(target) ){    // if use >= instead of >, index "right" may be outbound   
          right -= 1
        }
        if ( left < right ){
          var tmp = source(left)
          source(left) = source(right)
          source(right) = tmp
        }
      }
      var tmp = source(target)
      source(target) = source(right)
      source(right) = tmp
      quickSort(source, start, right-1)
      quickSort(source, right+1, end)
    }
  }
  
}