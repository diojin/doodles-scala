package outerhaven.sfti

object HelloWorld {
  def main(args: Array[String]):Unit = {
    println("Hello World")
    var sum = ""
    for (ch <- "Hello") sum += ch
    println(sum)
    
  }
}