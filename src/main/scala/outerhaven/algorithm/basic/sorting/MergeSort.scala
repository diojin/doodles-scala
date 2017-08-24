package outerhaven.algorithm.basic.sorting

object MergeSort extends App with SortAlgorithm{
  val algorithmName = "merge sort"  
  launch(dataset)

  def sort[T](source: Array[T])(implicit ev: T <:< Ordered[T]) {  
    // topDownMergeSort(source)
    buttomUpMergeSort(source)
  }
  
  def buttomUpMergeSort[T](source: Array[T])(implicit ev: T <:< Ordered[T]) {  
    var length = 1
    var buffer = source.clone()
    while ( length < source.length - 1 ){
      buttomUpOnePass(source, buffer, length)
      length *= 2
      buttomUpOnePass(buffer, source, length)
    }
  }
  
  def buttomUpOnePass[T](from: Array[T], to: Array[T], length: Int)(implicit ev: T <:< Ordered[T]){
    var i = 0
    while ( i + 2*length <= from.length ){
      merge(from, to, i, i + length, i + 2*length -1 )
      i += 2 * length
    }
    if ( i + length < from.length ){
      merge(from, to, i, i+length, from.length -1 )
    }else{
      for ( j <- i to from.length -1 ){
        to(j) = from(j)
      }
    }
  }
  
  
  def topDownMergeSort[T](source: Array[T])(implicit ev: T <:< Ordered[T]){
    // this copying source to buffer operation is necessary
    val buffer = source.clone()
    topDownSplitMerge(buffer, source, 0, source.length - 1)
    // topDownSplitMergeSimple(source, 0, source.length - 1)
  }

  /**
   * the order of the parameters are a little tricky
   */
  def topDownSplitMerge[T](from: Array[T], to: Array[T], start: Int, end: Int)(implicit ev: T <:< Ordered[T]) {  
    if ( end > start ){
      val mid = math.floor((start+end)/2).toInt
      topDownSplitMerge(to, from, start, mid)
      topDownSplitMerge(to, from, mid+1, end)
      merge(from, to, start, mid+1, end)           
    }
  }
  
  /**
   * logic is simpler but too much space waste
   */
  def topDownSplitMergeSimple[T](source: Array[T], start: Int, end: Int)(implicit ev: T <:< Ordered[T]) { 
    if ( end > start ){
      val buffer = source.clone()
      val mid = math.floor((start+end)/2).toInt
      topDownSplitMerge(source, buffer, start, mid)
      topDownSplitMerge(source, buffer, mid+1, end)
      merge(buffer, source, start, mid+1, end)           
    }
  }
  
  def merge[T](from: Array[T], to: Array[T], start: Int, mid: Int, end: Int)(implicit ev: T <:< Ordered[T]){
    var i = start
    var j = mid
    var k = start
    while ( i < mid || j <= end ) {
      if ( i < mid && ( j > end || from(i) <= from(j) ) ){
        to(k) = from(i)
        i += 1
      }else{
        to(k) = from(j)
        j += 1
      }
      k +=1
    }   
  }
}