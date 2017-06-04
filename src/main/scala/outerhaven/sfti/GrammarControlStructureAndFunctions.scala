package outerhaven.sfti

import math._
import scala.util.control.Breaks._
import java.net.URL
import java.net.MalformedURLException
import java.io.IOException
import scala.collection.mutable.ArrayBuffer
import java.io.FileNotFoundException
import java.io.InputStream

/**
 * grammar examples for Control Structures and Functions
 */
class GrammarControlStructureAndFunctions {
  def entrance(): Unit = {
    println("## grammar examples for Control Structures and Functions")
    
    println("### if statement")
    // if statement without else returns a class Unit that has one value, written as ()
    var a1 = -1
    var a1_res = if ( a1 > 0 ) 0
    println(a1_res)
    
    // use block to initialize an variable
    val distance = { val dx = 10; val dy = 20; sqrt(dx * dx + dy * dy) }
    
    println (distance)
    
    val loop = new GrammarLoop
    loop.entrance()
    
    val funcAndProcedure = new GrammarFunctionAndProcedure
    funcAndProcedure.entrance()
    
    val grammarException = new GrammarException
    grammarException.entrance()
    
  }
}

/**
 * grammar example for Loop structure
 */
class GrammarLoop {
  def entrance() {
    println("### grammar example for Loop structure")
    
    println("while loop")
    var x = 0
    while ( x < 10 ){
      println(x)
      x += 1
    }
    
    do{
      println(x)
      x -= 1
    }while( x > 0 )
    
    
    // scala.collection.immutable.Range.Inclusive
    println(1 to 10)
    
    println("inclusive loop")
    var sum = 0
    for ( i <- 1 to 10 ){
      sum += i
    }
    println (sum)
    
    println("exclusive loop")
    val name = "Nari"
    for ( i <- 0 until name.length() ){
      println(name(i))
    }    
    
    println("other type of loop")
    for ( ch <- name ){
      println(ch)
    }
    
    println("break from loop, inefficient")
    breakable{
      for ( i<- 1 to 10 ){
        if ( i == 5 ){
          break
        }
        println (i)
      }
    }
    println("loop comprehansion")
    
    println("You can have multiple generators of the form variable <- expression")
    
    for (i <- 1 to 3; j <- 1 to 3) print((10 * i + j) + " ")
    // Prints 11 12 13 21 22 23 31 32 33
    
    println()
    
    println("Each generator can have a guard, a Boolean condition preceded by if")
    for (i <- 1 to 3; j <- 1 to 3 if i != j) print((10 * i + j) + " ")
    // Prints 12 13 21 23 31 32
    
    println()
    
    for (i <- 1 to 3; from = 4 - i; j <- from to 3) print((10 * i + j) + " ")
    // Prints 13 22 23 31 32 33
        
    println( for ( i <- 1 to 10) yield i % 3 )
    // Yields Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)
    
    println("The generated collection is compatible with the first generator")
    
    println( for(c <- "Hello"; i <- 0 to 1 ) yield (c+i).toChar )
    
    println( for(i <- 0 to 1 ; c <- "Hello")  yield (c+i).toChar )    
    
    val a3 = ArrayBuffer(1, 2, 3, 4, 5)    
    println( for ( i <- a3 if i %2 == 1 ) yield i * 2 )
    
  }  
}

class GrammarFunctionAndProcedure{
  def entrance() {
    println("### grammar examples for function and procedure")

    def fac(n: Int): Int = if (n <= 0) 1 else n * fac(n - 1)
    println(fac(5))

    println("default value for arguments")
    def decorate(str: String, left: String = "[", right: String = "]") =
      left + str + right
      
    println(decorate("Nari"))
    println(decorate(left = "<<<", str = "Nari", right = ">>>"))
    
    println("variable arguments")
    def sum(args: Int*) = {
      var result = 0
      for (arg <- args) result += arg
      result
    }
    
    println(sum(1, 2, 3, 4, 5))
  }

}

class GrammarException{
  def entrance(){
    println("### grammar examples for exception handling")
    var io:InputStream = null
    try{    
      io = new URL("http://horstmann.com/fred-tiny.gif").openStream()
    }catch{
      case _: MalformedURLException => println("Bad URL: " + io.toString())
      case ex: FileNotFoundException => ex.printStackTrace()
      case ex: IOException => ex.printStackTrace()
    }finally{
      if ( io != null ){
        io.close
      }
    }    
  }
}