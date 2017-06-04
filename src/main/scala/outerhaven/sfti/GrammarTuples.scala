package outerhaven.sfti

/**
 * grammar examples for Tuples
 */
class GrammarTuples {
  def entrance() {
    println("grammar examples for Tuples")  
    val tuples = (1, 3.14, "Li")
    println(tuples._1)
    println(tuples _2)
    println(tuples _3)
    
    // if second element of tuples isn't cared
    val ( first, _ , third  ) = tuples    
    println( first + "," + third )
    
    println( "New York".partition { k => k.isUpper } )
    println( "New York".partition(_.isUpper) )          // Yields the pair ("NY", "ew ork")
    
    println("zipping operation")
    
    val symbols = Array( "<", "-", ">" )
    val counts = Array(2, 10, 2)
    val pairs = symbols.zip(counts)
    println(pairs)  // yields an array of pairs Array(("<", 2), ("-", 10), (">", 3))
    for ( (s, n) <- pairs ) Console.print(s * n)    // print <<---------->>
    println()
    println(pairs.toMap)    
  }
}