package outerhaven.algorithm.basic

package object sorting {
  val dataset = Array(Data(1,1), Data(8,2) , Data(3, 3), Data(3,4), Data(5,5), Data(2,6), Data(1,7))
  val dataset1 =  Array(Data(35, 1), Data(88,2), Data(16,3), Data(27, 4), Data(32,5), Data(4,6), 
      Data(90,7), Data(56,8), Data(79,9) )
  
  
  val simpleDataSet = Array(1, 8, 3, 3, 5, 2, 1)
  implicit def intToOrdered(x : Int) = new Ordered[Int] {
    override def compare(that: Int) = x - that 
  }
}