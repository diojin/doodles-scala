package outerhaven.sfti

import outerhaven.sfti.definition.TrafficLightColor
import outerhaven.sfti.definition.TrafficLightColor._
import outerhaven.sfti.definition.TrafficLightColorEnhanced
import outerhaven.sfti.definition.TrafficLightColorEnhanced._

/**
 * grammar example for scala enum
 * if outerhaven.sfti.definition.TrafficLightColor._ is imported, you can 
 * directly use expression BLUE as well as TrafficLightColor.BLUE
 */
class GrammarEnum {
  def entrance() {
    println("### grammar example for scala enum")    
    for ( c <- TrafficLightColor.values ) println(c.id + ":" + c)    
    println(TrafficLightColor(5))                    // BLUE
    println(TrafficLightColor.withName("BLUE"))      // BLUE
    testEnum(BLUE)
    testEnum(RED)
    testEnumEnhanced(AZURE)
    
  }    
  def testEnum( color : TrafficLightColor.Value ){
    if ( color == BLUE ) {
      println(color)
    }else if ( color == TrafficLightColor.RED){
      println(color)
    }else {
      println("unmatch")
    }
  }
  def testEnumEnhanced ( color : TrafficLightColorEnhanced){
    if ( color == AZURE ) {
      println(color)
    }else{
      println("unmatch")
    }
  }
}
