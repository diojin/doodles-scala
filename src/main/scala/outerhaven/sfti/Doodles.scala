package outerhaven.sfti

import java.text.MessageFormat
import scala.collection.mutable.ArrayBuffer
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.util.Random
import scala.util.control.Breaks._
import scala.io.Source
import scala.math._
import java.net.URL
import java.net.MalformedURLException
import java.io.IOException
import java.io.FileNotFoundException
import java.io.InputStream
import scala.util.Sorting
//import scala.collection.mutable.Map

object Doodles {
  def main(args: Array[String]):Unit = {
    println("hello world!")
    
    def decorate(str: String, left: String = "[", right: String = "]") =
       left + str + right
    println(decorate("haha"))
    
    
    def sum(args: Int*) = {
      var result = 0
      for ( arg <- args ){
        result += arg
      }
      result
    }
    println(sum(1,2,3,4,5))
    println(sum(1 to 5:_*))

    def recursiveSum(args: Int*): Int = {
      if (args.length == 0) 0
      else args.head + recursiveSum(args.tail: _*)
    }
    
    val str = MessageFormat.format("The answer to {0} is {1}", "everything", 42.asInstanceOf[AnyRef])

    println("start processing Array")
    
    println(Array(1, 7, 2, 9).sum)
    
    println(ArrayBuffer("Mary", "had", "a", "little", "lamb").max)
    
    val b = ArrayBuffer(1, 7, 2, 9)
//    val bSorted = b.sorted(_ < _)
      // b is unchanged; bSorted is ArrayBuffer(1, 2, 7, 9)
    
    println("start processing Map")
    var scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    val bobsScore = scores.getOrElse("Bob", 0)
    scores += ("Bob" -> 10, "Fred" -> 7)
    scores = scores - "Alice"
    for (v <- scores.values) println(v)
    
    val scores1: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
    
    val props: scala.collection.Map[String, String] = System.getProperties()
    
    println("start using class, how to quote class in different package?")
    
//    val counter = new Counter()
    
    trial1()
  }

  def trial1() {
    println("start testing trial1")
    println(math.sqrt(2))
    println(math sqrt 2)
    println(BigInt.probablePrime(10, Random))
    println("hello"(4))
    println("HellO".count(_.isUpper))
    println("for loop section")
    for ( i <- 1 to 20 ){
      print(i)
    }
    println("")
    
    val s = "hello"
    var sum = 0
    for ( i <- 0 until s.length()){
      sum += s(i)
    }
    println(sum)
    
    sum = 0
    for ( i <- s){
      sum += i
    }
    println(sum)
    println("a way to break")
    sum = 0
    breakable {
      for ( i <- 0 until s.length() ){
        if ( i == 2 )
          break;
        sum += s(i)
      }
    }
    println(sum)
    
    println(for ( i <- 1 to 10 ) yield i%3)
    
    println("nested loop")
    
    println(for ( i <- 1 to 2; s <- "Hello" ) yield (i+s).toChar)
  
    println(for ( s <- "Hello"; i <- 1 to 2) yield (i+s).toChar )
    
    println( recursiveSum(1, 2, 3, 4, 5) )
    
    println( recursiveSum(1 to 5:_*))
    
    println("convert primary type when calling Java method asking for Object")
    
    val res = MessageFormat.format("the answer is {0} to {1}", "everything", 42.asInstanceOf[AnyRef])
    
    println(res)
    
    println("lazy value test")
    
    lazy val content = Source.fromFile("/Users/diojin/outerhaven/workspace/mockingjay/docs/messenger.md").mkString
    println(content)

    val x = 12

    if (x >= 0) {
      sqrt(x)
    } else throw new IllegalArgumentException("x should not be negative")
   
    exceptionGrammar
    
    println("other stuffs")
    
    arrayOperation
    
    mapAndTuplesOp   
   
  }
  
  // _* parameter usage
  def recursiveSum(args: Int*) : Int = {
    if ( args.length== 0 ) 
      0
    else
      args.head + recursiveSum(args.tail:_*)
  }
  
  def exceptionGrammar() {
    println("start exception grammar")
    var in : InputStream = null
    try{
      in = new URL("http://horstmann.com/fred.gif").openStream()
      println("doing something on url"+in.hashCode())
    }catch {
      case _: MalformedURLException => {
         println("bad url") 
      }
      case ex: IOException => ex.printStackTrace()
      case ex: FileNotFoundException => ex.printStackTrace()
    }finally{
//      in.close()
        println("do some stuffs here")
    }
  }
  
  def arrayOperation: Unit = {
    println("start array operations")
    val a = new Array[String](10)
    val s = Array("Hello", "World")
    s(0) = "Farewell"
    for ( msg <- s ){
      println(msg)
    }
    try{
      s(2) = "violation"
    }catch{
      case ex: IndexOutOfBoundsException => ex.printStackTrace()
    }
    
    println("start processing ArrayBuffer")
    
    val b = new ArrayBuffer[Int]
    b += 1
    b += (2, 3)
//    b += 4 to 10        // failed due to type mismatch
    b ++= 4 to 10
//    b += Array(11, 12)  // failed due to type mismatch
    b ++= Array(11, 12)
    println(b)
//    b.trimEnd(10)
//    println(b)
    println(for (elem <- b if elem % 2 == 0) yield 2*elem)
    println(b.filter(_ % 2 ==0).map(2*_))
    println(b.filter { _ % 2 == 0 }.map { 2 * _ })
    println(b filter { _ % 2 == 0 } map { 2 * _ })
    println(b)
    
    println("ignore the 1st element")
    val input = Array(1, 2, 3, 4, 5, 6)
    var first = true
    var res = for ( i <- 0 until input.length if !first || i % 2 == 1 ) yield {
      if ( first ) {
        first = false
      }
      input(i)
    }
    println(res)  // Vector(2, 3, 4, 5, 6)
    
    first = true
    res = for ( i <- 0 until input.length if !first ) yield {
      if ( first ) {
        first = false
      }
      input(i)
    }
    println(res)  // Vector()
    
    first = false
    val indexes = for (i <- 0 until b.length if first || b(i) >= 0) yield {
      if (b(i) < 0) first = false; i
    }
    println(indexes)
    
    var a1 = ArrayBuffer(1, 3,  1, 2, 8, 5)
    val aRes = a1.sortBy(x => -x)
    val aRes2 = a1.sortWith(_ > _)
    println(aRes)        // ArrayBuffer(8, 5, 3, 2, 1, 1)
    println(aRes2)       // ArrayBuffer(8, 5, 3, 2, 1, 1)
    
    val a2 = Array(1, 3,  1, 2, 8, 5)
    Sorting.quickSort(a2)
    println(a2.toBuffer)
    
    println("multidimentional array")
    val matrix = Array.ofDim[Int](3,4)
    val raggerArray = new Array[Array[Int]](5)
    for (i <- 0 until raggerArray.length ){
      raggerArray(i) = new Array[Int](i+2)      
    }
    
  }
  
  def mapAndTuplesOp {
    println("start map and tuples operation")
    val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    val scores1 = new scala.collection.mutable.HashMap[String, Int]
    var scores2 = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    val scores3 = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8))
    
    println(scores3.getOrElse("dio", 42))
    
    val newScores = scores + ("Bob" -> 10, "Fred" -> 7)
    
    scores2 += ("Bob" -> 10, "Fred" -> 7)
    println(scores2)
    
    scores2 = scores2 + ("Bob" -> 10, "Fred" -> 7)
    println(scores2)
    
    scores2 = scores2 - "Bob"
    println(scores2)
    
    for ( (k, v) <- scores2 ){
      printf("%s -> %s\n", k, v)
    }
    
    for ( s <- scores2.keys ) {
      println(s)
    }
    
    for ( s <- scores2.values ) {
      println(s)
    }

    val scores4 = for ( (k, v) <- scores2 ) yield (v, k)
    println(scores4)
    
    val tup1 = (1, 3.14, "Fred")
    println(tup1)
    println(tup1._2)
    println(tup1 _3)
    
    var (first, _, third) = tup1 
    println(first)
    
    println("New York".partition { x => x.isUpper })
    val res = "New York".partition(_.isUpper)
    println(res)
    
    val symbols = Array("<", "-", ">") 
    val counts = Array(2, 10, 3)
    val pairs = symbols.zip(counts)
    // yields an array of pairs Array(("<", 2), ("-", 10), (">", 3))
    for ( pair  <- pairs ){
      println(pair)
    }
    
    println(pairs.toMap)    // Map(< -> 2, - -> 10, > -> 3)

    
  }
  
}