package outerhaven.algorithm.basic.sorting

trait SortAlgorithm {
  def sort[T] (input : Array[T])(implicit ev: T <:< Ordered[T])
  val algorithmName: String
  def launch[T](source: Array[T])(implicit ev: T <:< Ordered[T]){
    printf("before start sort algorithm: %s\n", algorithmName)
    val input = source.clone()
    println(input.mkString(","))
    sort(input)
    printf("after sort algorithm: %s\n", algorithmName)
    println(input.mkString(","))
  }
}