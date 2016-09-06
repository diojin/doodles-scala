package outerhaven.sfti

import java.text.MessageFormat
import scala.collection.mutable.ArrayBuffer
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap

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
    
  }
}