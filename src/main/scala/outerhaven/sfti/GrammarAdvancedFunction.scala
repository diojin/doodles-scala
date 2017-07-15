package outerhaven.sfti
import scala.math._

/**
 * advanced grammar examples for function
 */
class GrammarAdvancedFunction extends GrammarExample{
  def entrance(){
    println("### advanced grammar examples for function")
    val func1 = scala.math.ceil _
    println(func1(3.14))
    println(Array(3.14, 1.42, 2.0).map(func1).mkString)
    
    println("anonymous function")
    //(x: Double) => 3 * x
    var triple = (x: Double) => 3*x
    Array(1.1, 2.2, 3.3).map( (x:Double) => 3*x ) // Array(3.3, 6.6, 9.9)
    Array(1.1, 2.2, 3.3).map{ (x:Double) => 3*x }  // Array(3.3, 6.6, 9.9)
    Array(1.1, 2.2, 3.3) map { (x:Double) => 3*x }  // Array(3.3, 6.6, 9.9)
    
    // its type is ((Double) => Double) => Double
    def valueAtOneQuarter( f : (Double) => Double ) = f(0.25)
    
    valueAtOneQuarter(ceil _) // 1.0
    valueAtOneQuarter(sqrt _) // 0.5
    
    // higher-order function that produces another function, whose type is
    // (Double) => ((Double) => Double)
    def mulBy( factor : Double ) = (x: Double) => factor * x
    mulBy(3)(1.0)    // 3.0
    
    println("parameter inferrence")
    valueAtOneQuarter( (x:Double) => 3*x )    // 0.75
    // Since the valueAtOneQuarter method knows that you will pass in a (Double) => Double function, omit :Double
    valueAtOneQuarter( (x) => 3*x )
    // As a special bonus, for a function that has just one parameter, you can omit the () around the parameter
    valueAtOneQuarter( x => 3*x )
    // It gets better. If a parameter occurs only once on the right-hand side of the =>, you can replace it with an underscore
    valueAtOneQuarter( 3*_ )
    
    println("*" * 3)       // ***
    (1 to 9).map(0.1 * _)  // Vector(0.1, 0.2, 0.30000000000000004, 0.4, 0.5, 0.6000000000000001, 0.7000000000000001, 0.8, 0.9)
    (1 to 9).map("*" * _).foreach(println _)
//    *
//    **
//    ***
//    ****
//    *****
//    ******
//    *******
//    ********
//    *********
    (1 to 9).filter(_ % 2 == 0)  // Vector(2, 4, 6. 8)
    // def reduceLeft[B >: A](op: (B, A) => B): B in scala.collection.Iterable
    (1 to 9).reduceLeft(_ * _)   // 362880 ( = (((((((1 * 2) * 3) * 4) * 5 ) * 6) * 7) * 8) * 9 )
    // def sortWith(lt: (T, T) => Boolean): Array[T] in scala.Array
    "Mary had a little lamb".split(" ").sortWith(_.length < _.length)  // a had Mary lamb little
    
    println("Closure")
    val triple1 = mulBy(3)
    val half = mulBy(0.5)
    println(triple1(14) + " " + half(14)) // Prints 42 7
    // it didn't print either "42 42" or "7 7", means each of triple1 and half 
    // has its own version of factor parameter
    
    var a = Array("Hello", "World")
    var b = Array("hello", "world")
    println(a.corresponds(b)(_.equalsIgnoreCase(_))) /// true

    println("anonymous function")
    def runInThread(block: () => Unit) {
      new Thread {
        override def run() { block() }
      }.start()
    }
    
    runInThread { () => println("Hi"); Thread.sleep(10000); println("Bye") }

    println("call by name")
    def runInThreadCallByName(block: => Unit) {
      new Thread {
        override def run() { block }
      }.start()
    }
    
    runInThreadCallByName { println("Hi"); Thread.sleep(10000); println("Bye") }

    println("control abstraction")
    def until(condition: => Boolean)(block: => Unit) {
      if (!condition) {
        block
        until(condition)(block)
      }
    }
    
    var x = 10
    until ( x == 0 ){
      x -= 1
      println(x)
    }
    
  }
}