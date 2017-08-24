package outerhaven.algorithm.basic.structure

trait Node extends Ordered[Node]{
  def data: Int
  def compare(that: Node) = {
    data - that.data
  }
}