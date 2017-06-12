package outerhaven.sfti

import java.text.MessageFormat

/**
 * Contain uncategorized grammar examples
 */
class GrammarUncategorizedSnippets extends GrammarExample {
  def entrance(): Unit = {
    println("## Contain uncategorized grammar examples")
    
    println("explicitly specify the type of a variable")
    val content : Any = "Hello"
    println(content)
    
    println("use usual mathematical operators on BigInt or BigDecimal")
    // That¡¯s much better than Java, where you would have had to call x.multiply(x).multiply(x).
    val x: BigInt = 1234567890
    x * x * x // Yields 1881676371789154860897069000
    
    
    val typeConversion = new GrammarTypeCast
    typeConversion.entrance()
    
    val applyMethod = new GrammarApplyMethod
    applyMethod.entrance()
    
    val others = new GrammerOthers
    others.entrance()
    
    val lazyInit = new GrammarLazyInitialization
    lazyInit.entrance()
    
    val range = new GrammarRange
    range.entrance()
  }  
}

/**
 *	(not limited to) 3 ways of type conversions
 */
class GrammarTypeCast extends GrammarExample {
  def entrance() {
    println("### (not limited to) 3 ways of type conversions")
    
    // dominant way, by any function
    println(99.44.toInt)
    
    // way 2
    println(MessageFormat.format("This is {0}", 20.asInstanceOf[AnyRef]))
    
    // way 3
    println("argument sequence")
    
    println(recursiveSum(1 to 10:_*))
    println(recursiveSum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
  }
  def recursiveSum(args : Int*) : Int = {
    if (args.length == 0){
      0
    }else{
      args(0) + recursiveSum(args.tail:_*)
    }
  }
}

/**
 * show examples of the "apply" method
 */
class GrammarApplyMethod extends GrammarExample {
  def entrance() {
    println("### show examples of the \"apply\" method")
    // def apply(n: Int): Char in StringOps
    // "Nari"(3) is a shortcut for "Nari".apply(3)
    println("Nari"(3))
    println("Nari".apply(3))
    println(BigInt("1234567890"))
    println(Array(1, 4, 9, 16))
    
  }
}
/**
 * other uncategorized grammar examples
 */
class GrammerOthers extends GrammarExample {
  def entrance() {
    println("### other uncategorized grammar examples")
    
    // def count(p: (Char) => Boolean) : Int in StringOps
    println("NarI".count { _.isUpper })
  }
}
/**
 * grammar for lazy initialization
 */
class GrammarLazyInitialization extends GrammarExample {
  def entrance() {
    println("### grammar for lazy initialization")
    lazy val content = scala.io.Source.fromFile("src/main/scala/outerhaven/sfti/GrammarExampleIndex.scala").mkString
    println(content)

    val words1 = scala.io.Source.fromFile("src/main/scala/outerhaven/sfti/GrammarExampleIndex.scala").mkString
    // Evaluated as soon as words is defined
    lazy val words2 = scala.io.Source.fromFile("src/main/scala/outerhaven/sfti/GrammarExampleIndex.scala").mkString
    // Evaluated the first time words is used
    def words3 = scala.io.Source.fromFile("src/main/scala/outerhaven/sfti/GrammarExampleIndex.scala").mkString
    // Evaluated every time words is used
  }
}

class GrammarRange extends GrammarExample{
  def entrance() {
    println("### Grammar examples for Range")
    println(1 to 10)            // Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(1 until 10)         // Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println((1 to 10).reverse)  // Range(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
    // every second element
    println( 1 to (10, 2) )     // Range(1, 3, 5, 7, 9)
  }
}

