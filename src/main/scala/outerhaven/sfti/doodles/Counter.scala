package outerhaven.sfti.doodles

class Counter {
  private var count = 0
  def increment() {
    count += 1
  }
  def current = {
    count
  }
  
  def isLess( other : Counter ) = {
    this.count < other.count           // Can access private field of other object
  }
  
}
class Counter1 {
  private[this] var count = 0
  def isLess( other : Counter ) = {
//    this.count < other.count           // Can't access private field of other object
  }  
}