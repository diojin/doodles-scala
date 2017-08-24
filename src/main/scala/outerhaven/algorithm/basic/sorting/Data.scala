package outerhaven.algorithm.basic.sorting

class Data ( var value: Int, var index: Int ) extends Ordered[Data] {
  override def compare(other: Data) = {
    value - other.value
  }
  override def toString = "[%d -> %d]".format(value, index)
}

object Data {
  def apply( value: Int, index: Int ) = new Data(value, index)
}
