package outerhaven.sfti

import scala.collection.mutable.ArrayBuffer
import java.util.concurrent.atomic.AtomicInteger

/**
 * grammar examples for array
 */
class GrammarArray extends GrammarExample {
  def entrance() {
    println("### grammar examples for array")
    val a1 = new Array[String](10)
    val a2 = Array("Hello", "World")
    a2(1) = "Nari"
    println(a2(1))

    val b =ArrayBuffer[Int]()
    // Or new ArrayBuffer[Int]
    // Or new ArrayBuffer[Int]()
    // An empty array buffer, ready to hold integers
    b += 1
    // ArrayBuffer(1)
    // Add an element at the end with +=

    b += (1, 2, 3, 5)
    // ArrayBuffer(1, 1, 2, 3, 5)
    // Add multiple elements at the end by enclosing them in parentheses
    b ++= Array(8, 13, 21)
    // ArrayBuffer(1, 1, 2, 3, 5, 8, 13, 21)

    b ++= 22 to 23
    // ArrayBuffer(1, 1, 2, 3, 5, 8, 13, 21, 22, 23)
    // You can append any collection with the ++= operator

    //    b += 4 to 10        // failed due to type mismatch
    //    b += Array(11, 12)  // failed due to type mismatch

    b.trimEnd(5)
    // ArrayBuffer(1, 1, 2, 3, 5)
    // Removes the last five elements
    
    b.insert(2, 10, 11, 12)
    // ArrayBuffer(1, 1, 10, 11, 12, 2, 3, 5)
    
    b.remove(2)
    // ArrayBuffer(1, 1, 11, 12, 2, 3, 5)
    
    b.remove(2, 2)
    // ArrayBuffer(1, 1, 2, 3, 5)
    
    println(b)
    
    println("### array traversal")
    val a3 = ArrayBuffer(1, 2, 3, 4, 5)
        
    println( for ( i <- a3 if i %2 == 1 ) yield i * 2 )
    
    println( a3.filter { _ %2 == 1 }.map { 2 * _ } )
    println( a3.filter(_ % 2 == 1).map(2 * _ ) )
    println( a3 filter { _ %2 == 1 } map { 2 * _ } )
    println( a3 filter(_ % 2 == 1) map(2 * _ ) )
    
    println("there is no ++ operator in scala")
    val input = ArrayBuffer(1, 2, 3, 4, 5, 6) 
    var latch = new AtomicInteger(-1);
    val res4 = for ( i <- input if latch.incrementAndGet() > 0 ) yield i
    println(res4)  // ArrayBuffer(2, 3, 4, 5, 6)
    
    val a5 = Array(1, 7, 2, 9)
    println(a5.sum)                // 19
    println(a5.mkString(" | "))    // 1 | 7 | 2 | 9
    println(a5)                    // some value like [I@16f7412
    
    println("array sort")
    var a4 = ArrayBuffer(1, 3,  1, 2, 8, 5)
    val aRes = a4.sortBy(x => -x)
    val aRes2 = a4.sortWith(_ > _)
    println(aRes)        // ArrayBuffer(8, 5, 3, 2, 1, 1)
    println(aRes2)       // ArrayBuffer(8, 5, 3, 2, 1, 1)
    
    // You can sort an array, but not an array buffer, in place
    val a = Array(1, 7, 2, 9)
    scala.util.Sorting.quickSort(a)
    // a is now Array(1, 2, 7, 9)
    
    
    println("multi-dimemsional array")
    val matrix = Array.ofDim[Int](3, 4) // Three rows, four columns
    val raggedArray = new Array[Array[Int]](5)
    for ( i <- 0 until raggedArray.length ){
      raggedArray(i) = new Array[Int](i+2)
    }   
    
  }
}