package outerhaven.sfti

/**
 * grammar examples for pattern matching and case classes
 */
class GrammarPatternMatchAndCaseClass extends GrammarExample {
  def entrance(){
    println("### grammar examples for pattern matching and case classes")
    println("c-style switch equivalent")
    var sign = 0
    val ch: Char = '+'
    var digit: Int = 0 
    ch match {
      case '+' => sign = 1
      case '-' => sign = -1
      case _ if Character.isDigit(ch) => digit = Character.digit(ch, 10)
      case _ => sign = 0
    }
    
    val obj: Any = 1
    obj match {
      case x: Int => x
      case s: String => Integer.parseInt(s)
      case _: BigInt => Int.MaxValue
      case _ => 0
    }

    val arr = Array(0, 1, 3, 6)
    arr match {
      case Array(0) => "0"
      case Array(x, y) => x + " " + y
      case Array(0, _*) => "0 ..."
      case _ => "something else"
    }
    
    val (q, r) = BigInt(10) /% 3
    
    val amt = Currency(29.95, "EUR")
    var price = amt.copy()          // Currency(29.95, "EUR")
    price = amt.copy(value = 19.95) // Currency(19.95, "EUR")
    price = amt.copy(unit = "CHF") // Currency(29.95, "CHF")
    
    val item = 
    Bundle("Father's day special", 20.0,
      Article("Scala for the Impatient", 39.95),
      Bundle(  "Anchor Distillery Sampler", 10.0,
               Article("Old Potrero Straight Rye Whiskey", 79.95),
               Article("Jun¨ªpero Gin", 32.95)))
    
    item match {
      case Bundle(_, _, Article(descr, _), _*) => println(descr)
      // You can bind a nested value to a variable with the @ notation
      case Bundle(_, _, art @ Article(_, _), rest @ _*) => println(art.description)
      case _ => println("no match")
    }
    
    def priceCalc(it: Item): Double = it match {
      case Article(_, p) => p
      case Bundle(_, disc, its @ _*) => its.map(priceCalc _).sum - disc
    }
    val f: PartialFunction[Char, Int] = { case '+' => 1 ; case '-' => -1 }
    f('-') // Calls f.apply('-'), returns -1
    f.isDefinedAt('0') // false
    // f('0') // Throws MatchError
    
  }
}

sealed abstract class Amount
case class Currency(value: Double, unit: String) extends Amount

abstract class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, items: Item*) extends Item