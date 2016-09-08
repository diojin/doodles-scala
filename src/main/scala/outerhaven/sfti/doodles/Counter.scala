package outerhaven.sfti.doodles

class Counter {
  private var count = 0
  def increment() {
    count += 1
  }
  def current = {
    count
  }
}