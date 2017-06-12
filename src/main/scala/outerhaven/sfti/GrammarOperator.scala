package outerhaven.sfti

/**
 * grammar examples for operator
 */
class GrammarOperator {
  def entrance() {
    println("### grammar examples for operator")
    println("unapply operator")
    var Fraction(a,b) = Fraction(3, 4) * Fraction(5, 5)
    println("a=" + a + "\tb="+b)    
    Fraction(10, 20) match {
      case Fraction(a, b) => println(a + "/" + b)
      case _ => println("no match") 
    }
    var author = "Nari Van De Wu"      // prints "ah Nari, Van, De, Wu"
    author = "Nari Wu"                 // prints "haha Nari, Wu"
    author = "Nari Jin"                // prints "wow Nari, Jin"
    author = "Nari De Wu"              // prints "oh Nari, De, Wu"
    author match {
      case Name( first, last @ IsCompound() ) => printf("haha %s, %s\n", first, last)
      case Name( first, last ) => printf("wow %s, %s\n", first, last)
      case Name( first, middle, last ) => printf("oh %s, %s, %s\n", first, middle, last)
      case Name( first, "De", last ) => printf("err %s, %s, %s\n", first, "De", last)
      case Name( first, "Van", "De", last ) => printf("ah %s, %s, %s, %s\n", first, "Van", "De", last)
    }
    
  }
}

class Fraction(var numerator: Int, var denominator: Int){
  def *(other: Fraction ) = Fraction( numerator * other.numerator, denominator * other.denominator )
}

object Fraction {
  def apply( num: Int, den: Int ) = new Fraction(num, den)
  def unapply( input : Fraction ) = {
    if ( input.denominator == 0 ) None else Some((input.numerator, input.denominator))
  }
}

object IsCompound {
  def unapply(input : String) = input.contains("Wu")
}

object Name {
  def unapplySeq( input: String ): Option[Seq[String]] = 
    if ( input.trim().equals("") ) None else Some(input.trim.split("\\s+"))
}