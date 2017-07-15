package outerhaven.sfti

/**
 * grammar examples for collections
 */
class GrammarCollection extends GrammarExample {
  def entrance() {
    println("### grammar examples for collections")
    println("List")
    var digits = List(4, 2)
    println(digits)    // List(4, 2)
    digits = 9 :: List(4,2)
    println(digits)    // List(9, 4, 2)
    digits = 9 :: 4 :: 2 :: Nil
    println(digits) // List(9, 4, 2)
    def sum(lst: List[Int]): Int = lst match {
      case Nil => 0
      case h :: t => h + sum(t) // h is lst.head, t is lst.tail
    }
    println(sum(digits)) // 15

    // For example, this loop changes all negative values to zero
    val lst = scala.collection.mutable.LinkedList(1, -2, 7, -9)
    var cur = lst
    while (cur != Nil) {
      if (cur.elem < 0) cur.elem = 0
      cur = cur.next
    }

    // This loop removes every second element from the list
    cur = lst
    while (cur != Nil && cur.next != Nil) {
      cur.next = cur.next.next
      cur = cur.next
    }
    
    var numberVector = Vector(1, 2, 3)
    numberVector :+= 5 // += does not work since vectors don't have a + operator
    
    println("flatMap")
    val names = List("Peter", "Paul", "Mary")
    def ulcase( s: String ) = Vector( s.toUpperCase(), s.toLowerCase() )
    println(names.map(ulcase))      // List(Vector(PETER, peter), Vector(PAUL, paul), Vector(MARY, mary))
    println(names.flatMap(ulcase))  // List(PETER, peter, PAUL, paul, MARY, mary)
    
    "-3+4".collect { case '+' => 1 ; case '-' => -1 } // Vector(-1, 1)

    println("Folding is sometimes attractive as a replacement for a loop.")
    /**
     * Folding is sometimes attractive as a replacement for a loop. 
     * Suppose, for example, we want to count the frequencies of the
     * letters in a string. One way is to visit each letter and update a mutable map.
     */
    val freq = scala.collection.mutable.Map[Char, Int]()
    for (c <- "Mississippi") freq(c) = freq.getOrElse(c, 0) + 1
    // Now freq is Map('i' -> 4, 'M' -> 1, 's' -> 4, 'p' -> 2)
    
    /**
     * Here is another way of thinking about this process. At each step, 
     * combine the frequency map and the newly encountered letter, yielding a new frequency map.
     * What is op? The left operand is the partially filled map, 
     * and the right operand is the new letter. The result is the augmented map.
     * It becomes the input to the next call to op, and at the end, the result is a map with all counts.
     */
    //  with folding, it turns to
    val foldingRes1 = ( Map[Char, Int]() /: "Mississippi" ) {  
      ( map, newchar ) => map + ( newchar -> (map.getOrElse(newchar, 0) + 1) ) 
    }    // Map(M -> 1, i -> 4, s -> 4, p -> 2)
    
    (1 to 10).scanLeft(0)(_ + _)  // Vector(0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55)
    
    println("zipping")
    val prices = List(5.0, 20.0, 9.95)
    val quantities = List(10, 2, 1)
    prices zip quantities    // List((5.0,10), (20.0,2), (9.95,1))
    (prices zip quantities) map { p => p._1 * p._2 }  // List(50.0, 40.0, 9.95)
    List(5.0, 20.0, 9.95) zip List(10, 2)    // List((5.0, 10), (20.0, 2))
    List(5.0, 20.0, 9.95).zipAll(List(10, 2), 0.0, 1)  // List((5.0, 10), (20.0, 2), (9.95, 1))
    "Scala".zipWithIndex          // Vector(('S', 0), ('c', 1), ('a', 2), ('l', 3), ('a', 4))
    "Scala".zipWithIndex.max      // ('l', 3)
    "Scala".zipWithIndex.max._2   // 3
    
    println("streams")
    def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)
    val tenOrMore = numsFrom(10)        // Stream(10, ?)
    println(tenOrMore)                  // Stream(10, ?)
    // The tail is unevaluated.
    tenOrMore.tail.tail.tail            // Stream(13, ?)    
    println(tenOrMore)                  // Stream(10, 11, 12, 13, ?)
    tenOrMore.tail.tail                 // Stream(12, 13, ?)
    tenOrMore.tail                      // Stream(11, 12, 13, ?)
    println(tenOrMore)                  // Stream(10, 11, 12, 13, ?)
    tenOrMore.take(3).force             // Stream(10, 11, 12)
    println(tenOrMore)                  // Stream(10, 11, 12, 13, ?)
    tenOrMore.take(5).force             // Stream(10, 11, 12, 13, 14)
    println(tenOrMore)                  // Stream(10, 11, 12, 13, 14, ?)
    tenOrMore.tail.tail                 // Stream(12, 13, 14, ?)
    // Stream methods are executed lazily.
    val squares = numsFrom(2).map { x => x * x }    // Stream(4, ?)
    // You have to call squares.tail to force evaluation of the next entry.
    squares.tail                        // Stream(9, ?)
    println(squares)                    // Stream(4, 9, ?)
    // If you want to get more than one answer, you can invoke take followed by force, 
    // which forces evaluation of all values.
    squares.take(5).force               // Stream(4, 9, 16, 25, 36)   
    
    val words = scala.io.Source.fromFile("src/main/scala/outerhaven/sfti/definition/testfile1.txt")
                  .getLines().toStream
    println(words)          // Stream(Alpha, ?)
    println(words(5))       // Nari
    println(words)          // Stream(Alpha, Boy, Cat, Dio, Edin, Nari, ?)
    // revisit lines
    println(words(2))       // Cat
    
    println("view")
    val powers = (0 until 1000).view.map(2 * _)
    
    println("parallel collections")
    println("disordered")
    for (i <- (0 until 100).par) print(i + " ")
    
    println()
    println("yield makes result in order")
    
    println(for (i <- (0 until 100).par) yield i + " ")
    
    var count = 0
    for (c <- (0 to 100).par) { if (c % 2 == 0) count += 1 }
    println(count)
    
  }
}