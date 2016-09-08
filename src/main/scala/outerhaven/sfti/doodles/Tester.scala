package outerhaven.sfti.doodles

object Tester {
  def main(args: Array[String]): Unit = {
    val counter = new Counter
    counter.increment()
    println(counter.current)
    
    println("customized getter/setter")
    val person = new Person
    println(person)
    person.age = 20
    println(person.age)
    person.age=18
    println(person.age)
    
  }
}