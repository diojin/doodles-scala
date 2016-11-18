package outerhaven.sfti

import scala.math._
import scala.util.control.Breaks._

object GoThrough extends App {
  if (args.length > 0){
    printf("hello %s\n", args(0))
  }else{
    printf("hello world\n")
  }
  
  helloWorldCodes
  
  loopCodes
  
  println(functionCode)
  
  def helloWorldCodes() {
    printf("#######fundamantal gramma codes start\n")
    printf("Hello"(4).toString())
    println()
    printf("Hello".count(_.isLower).toString() )
    println()
    printf("Hello".count { _.isUpper }.toString())
    println()
    printf("Hello".count { _ => true }.toString())
    println()
    
    printf("Hello".count ( _ => true ).toString())
    println()
    
    val x = 10  
    val y = 20
    val x0=5 
    val y0=5
    val distance = { val dx=x-x0; val dy=y-y0; sqrt(dx * dx + dy * dy) }
    
    printf(distance.toString())
    println()
  }
  
  def loopCodes() {
    printf("#########loop gramma codes\n")
    var sum=0;
    for ( i <- 1 to 10 ){
      sum+=i
    }
    printf(sum.toString())
    println()
    
    sum=0;
    for ( i<- 1 until 10 ){
      sum+=i
    }
    printf("%d\n", sum)
    
    sum=0
    for (i <- "Hello"){
      sum+=i
    }
    printf("%d\n", sum)
    
    printf("test breakable loop\n")
    breakable{
      sum=0
      for (i<- 1 to 10){
        if ( i == 6 ){
          break
        }
        sum+=i
      }
      printf("inside breakable statement, %d\n", sum)
    }
    printf("right out of breakable statement, %d\n", sum)
    
    printf("loop comprehansion codes start here.\n")
    
    val res1 = for ( i<- 1 to 10 ) yield i%3
    println(res1)
    
    // the 1st parameter polymorphically decides the type of result of loop statement    
    val res2 = for (c <- "Hello"; i <-0 to 1) yield (c+i).toChar
    println(res2)
    
    val res3 = for( i<- 0 to 1; c<- "Hello") yield (c+i).toChar
    println(res3)
    
  } 
  
  def functionCode(): Int = {
    println("######function codes start")
    
    println(recursiveSum(1 to 10:_*))
    
    println(recursiveSum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    
    def recursiveSum(args: Int*):Int = {
      if ( args.length == 0 ){
        0
      }else{
        args(0) + recursiveSum(args.tail:_*)
      }
    }
    1
  }
  

}