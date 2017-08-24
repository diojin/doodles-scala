package outerhaven.algorithm.basic.sorting

object BubbleSort extends App with SortAlgorithm {
  val algorithmName = "bubble sort"  
  launch(dataset1)
    
  var input = dataset1.clone()
  println("before improved sort 1")
  println(input.mkString(","))
  improvedSort1(input)
  println("after sort")
  println(input.mkString(","))
  
  input = dataset1.clone()
  println("before improved sort 2")
  println(input.mkString(","))
  improvedSort2(input)
  println("after sort")
  println(input.mkString(","))

  /**
   * basic bubble sort
   */
  def sort[T](source: Array[T])(implicit ev: T <:< Ordered[T]) {
    var swapCount = 0
    for ( i <- source.length -1 to (1, -1) ){
      for ( j <- 0 to i - 1 ){
        if ( source(j) > source(j+1) ){
          var tmp = source(j)
          source(j) = source(j+1)
          source(j+1) = tmp
          swapCount += 1
        }
      }
    }
    printf("swapCount: %d\n", swapCount)
  }
  
  /**
   * improved algorithm 1
   * for certain round, if there is no more swap after certain index k, which indicates 
   * data between k and the end of this round is already sorted, hence in next round, 
   * the range of sort should be from 0 to k-1
   * use a bound variable to hold the value k
   */
  def improvedSort1[T](source: Array[T])(implicit ev: T <:< Ordered[T]) {
    var swapCount = 0
    var bound = source.length -1
    while (bound > 1){
      var upper = bound - 1
      bound = 0
      for ( i <- 0 to upper ){
        if ( source(i) > source(i+1) ){
          var tmp = source(i)
          source(i)=source(i+1)
          source(i+1) = tmp
          swapCount += 1
          bound=i
        }
      }
    }
    printf("swapCount: %d\n", swapCount)
  }
  
    /**
   * improved algorithm 2
   * take turns to use bubble up and bubble down
   */
  def improvedSort2[T](source: Array[T])(implicit ev: T <:< Ordered[T]) {
    var swapCount = 0
    var left = 0
    var right = source.length -1
    while ( left < right ){
      // at fisrt, bubble up
      var marker = 0
      for ( i <- left to right - 1 ){
        if ( source(i) > source(i+1) ){
          var tmp = source(i)
          source(i) = source(i+1)
          source(i+1) = tmp
          swapCount += 1
          marker = i
        }
      }
      right = marker
      // then, bubble down
      for ( i <- right to (left + 1, -1) ){
        if ( source(i) < source(i-1) ){
          var tmp = source(i)
          source(i) = source(i-1)
          source(i-1) = tmp
          swapCount += 1
          marker = i          
        }
      }
      left = marker
    }
    printf("swapCount: %d\n", swapCount)
  }
}