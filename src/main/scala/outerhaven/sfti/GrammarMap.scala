package outerhaven.sfti

/**
 * grammar examples for map
 */
class GrammarMap extends GrammarExample {
  def entrance(){
    println("### grammar examples for map")
    println("immutable Map[String, Int] whose contents can¡¯t be changed.")
    val scoresImmutable = Map("Alice" -> 10, "Bob"->3, "Cindy"->8)
    val scoresImmutable1 = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8))
    val scores = scala.collection.mutable.Map("Alice"-> 10, "Bob"->3, "Cindy"->8)
    val emptyMap = new scala.collection.mutable.HashMap[String, Int]    
    
    println("pair")
    println("Alice"-> 10)
    println(("Alice", 10))
    
    println(scores("Bob"))
    println("If the map doesn¡¯t contain a value for the requested key, an exception is thrown.")
    println(scores.getOrElse("Pop", -1))
    println("operate with mutable map")
    scores("Bob") = 30         // Updates the existing value for the key "Bob"
    scores("NewGuy") = -1      // Adds a new key/value pair to scores, "NewGuy" -> -1
    println(scores)            // Map(Bob -> 30, NewGuy -> -1, Alice -> 10, Cindy -> 8)
    scores += ( "Bob" -> 15, "NewGuy2" -> 15 )
    println(scores)            // Map(Bob -> 15, NewGuy -> -1, Alice -> 10, NewGuy2 -> 15, Cindy -> 8)
    scores -= "NewGuy2"
    println(scores)            // Map(Bob -> 15, NewGuy -> -1, Alice -> 10, Cindy -> 8)
    
    println("operate with immutable map")
    println("create new Map from immutableMap, merging same keys")
    val newScores = scoresImmutable + ("Bob"-> 10, "Fred"->7)
    println(newScores)         // Map(Alice -> 10, Bob -> 10, Cindy -> 8, Fred -> 7)
    println("remove a key, return a new map")
    val secondNewScores = newScores - "Fred"
    println(secondNewScores)   // Map(Alice -> 10, Bob -> 10, Cindy -> 8)
    
    println("iterate over map")
    for ( (k,v) <- scores ){
      println(k + "->" + v)
    }
    
    println(scores.keySet)    // Set(Bob, NewGuy, Alice, Cindy)
    
    for( v <- scores.values ) {
      println(v)
    }   
    // To get an immutable tree map instead of a hash map
    val scoresSorted = scala.collection.immutable.SortedMap("Alice" -> 10, "Fred" -> 7, "Bob" -> 3, "Cindy" -> 8)
    
    val months = scala.collection.mutable.LinkedHashMap("January" -> 1, "February" -> 2, "March" -> 3, "April" -> 4,"May" -> 5)
    
    println("inverse key and value in map")
    val inversedScores = for( (k, v) <- scores ) yield (v,k)
    println(inversedScores)    // Map(8 -> Cindy, -1 -> NewGuy, 10 -> Alice, 15 -> Bob)    
  }
}