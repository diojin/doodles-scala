package outerhaven.sfti

/**
 * grammar example for regex
 */
class GrammarRegExpression extends GrammarExample {
  def entrance() {
    println("### grammar example for regex")
    var format1 = "[0-9]+".r
    var format2 = """\s+[0-9]+\s+""".r    // A bit easier to read than "\\s+[0-9]+\\s+".r
    var format3 = """([0-9]+)\s*([a-z]+)""".r
    val content1 = "99 bottles, 98 bottles"
    for ( c <- format1.findAllIn(content1) ) println( "[" + c + "]" )
    val res1 = format1.findAllIn(content1).toArray
    
    println("processing group")
    val format3(num, str) = "99 bottles"
    println( "[" + num + "]" )
    println( "[" + str + "]" )
    for (format3(num, str) <- format3.findAllIn("99 bottles, 98 bottles")) {
      println("[" + num + "]")
      println("[" + str + "]")
    }    
  }
}