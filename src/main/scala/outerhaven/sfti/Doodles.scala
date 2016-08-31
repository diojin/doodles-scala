package outerhaven.sfti

import java.text.MessageFormat

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


    
  }
}