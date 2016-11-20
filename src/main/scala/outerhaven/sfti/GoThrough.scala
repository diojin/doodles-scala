package outerhaven.sfti

import scala.math._
import scala.util.control.Breaks._
import java.net.URL
import java.net.MalformedURLException
import java.io.IOException
import java.io.FileNotFoundException
import scala.collection.mutable.ArrayBuffer
import java.util.concurrent.atomic.AtomicInteger
import scala.collection.JavaConversions.bufferAsJavaList
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer

object GoThrough extends App {
  if (args.length > 0){
    printf("hello %s\n", args(0))
  }else{
    printf("hello world\n")
  }
  
  typeConversionCode
  
  helloWorldCodes
  
  loopCodes
  
  println(functionCode)
  
  println("lazy initialization starts here.")
  
  println("#####################################")
  lazy val file=scala.io.Source.fromFile("src/main/scala/outerhaven/sfti/doodles/Person.scala").mkString;
  
  println(file)
  
  println("#####################################")
  
  exceptionHandlingCode
  
  arrayCodes
  
  def typeConversionCode() {
    println("#####type conversion code starts")   
    val command = ArrayBuffer("a", "b", "c")
    val pb = new ProcessBuilder(command) // Scala to Java
                                     // java.lang.ProcessBuilder, plain java class, 
                                     // one of constructor takes java.util.List as parameter
    val buffer:Buffer[String] = pb.command();    // Java to Scala, List -> Buffer
    println(buffer)
  }
  
  // function definitions are listed below.
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
  
  def exceptionHandlingCode(){
    println("####exception handling codes start.")
    try{
      var in = new URL("http://horstmann.com/fred-tiny.gif").openStream()
      
    }catch{
      case _: MalformedURLException => println("malformed url")
      case ex: FileNotFoundException => println("hahaha")
      case e: IOException => e.printStackTrace()
      
    }finally{
      println("can't refer to in anymore.")
    }
  }
  
  def arrayCodes() {
    println("##############array codes start here")
    val s = new Array[String](10)
    val r = Array("hello", "world")
    println(r.mkString(","))
    println(r(0))
    
    val b = new ArrayBuffer[Int]
    
    b += 1
    
    println(b.mkString(","))
    
    // b += 2 to 4          // type mismatch
    // b += Array(2, 3, 4)  // type mismatch
    
    b++=2 to 4
    println(b.mkString(","))
    b ++= Array(5,6,7)
    println(b.mkString(","))
    
    b+=(8,9,10)
    println(b.mkString(","))
    
    b.trimEnd(2)
    println(b.mkString(","))
    
    // conversion
    val toArray = b.toArray
    val toBuffer = toArray.toBuffer
    
    var res1 = for( elm <- b if elm % 2 == 0 ) yield 2*elm
    
    println(res1)
    
    res1 = b.filter { _%2 == 0 }.map { _ * 2 }
    println(res1)
    
    res1 = b.filter(_%2==0).map(_*2)
    println(res1)
    
    println("ignore 1st element")
    
    // failed version 1
    var first = true;
    
    val res2 = for ( i <- b if !first ) yield {
      if ( first ){
        first = false
      }
      i
    }
    println(res2)
    
    // improper version
    val res3 = for ( i <- 0 until b.length if !first || i%2 == 1) yield {
      if ( first ){
        first = false;
      }
      b(i)
    }
    println(res3)
    
    // one of proper way
    var latch = new AtomicInteger(-1);
    val res4 = for ( i <- b if latch.incrementAndGet() > 0 ) yield i
    println(res4)
    
    println("sort an array")
    var a1 = ArrayBuffer(1, 3, 7, 5, 2)
    val res5 = a1.sortBy(x => -x )
    val res6 = a1.sortWith(_ > _)
    println(a1)
    println(res5)
    println(res6)
    
    // in place sort
    var a2 = Array(1, 3, 7, 5, 2)
    val res7 = a2.sortBy(x => -x )
    val res8 = a2.sortWith(_ > _)
    println(a2.mkString(","))
    println(res7.mkString(","))
    println(res8.mkString(","))
    
    var a3 = Array(1, 3, 7, 5, 2)
    scala.util.Sorting.quickSort(a3)
    println(a3.mkString(","))
    
    // multi dimentioal array
    var matrix = Array.ofDim[Int](3, 4)  // Three rows, four columns
    
    var raggerArray = new Array[Array[Int]](5)
    for ( i <- 0 until raggerArray.length ){
      raggerArray(i) = new Array[Int](i+2);
    }
    println(raggerArray(2)(3))    
    
    
  }
 

}