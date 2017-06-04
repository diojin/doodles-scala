package outerhaven.sfti.doodles

import outerhaven.sfti.doodles.TrafficEnhanced._
import outerhaven.sfti.doodles.TrafficLightColor._


object Tester {
  def main(args: Array[String]): Unit = {
    val counter = new Counter
    counter.increment()
    println(counter.current)
    
    println("customized getter/setter")
    val person = new Person
    println(person)
    person.age = 20
    println(person.age)
    person.age=18
    println(person.age)
    
//    val pcTester = new PrimaryConstructorTester("me", 38)
//    println(pcTester.describe)
    
    println("start testing Object")
    printf("%d => %d\n", Account.uniqueNumber(), Account.uniqueNumber())
    val acc = new Account
    println(acc.id)
    
    DoNothingAction.undo()
    
    val newAcct = Account(233.34)
    println(newAcct.id)
    
    println("start enumeration")
    
    println(TrafficLightColor.ORANGE)
    
    testEnum(BLUE)
    testEnum(ORANGE)
    testEnumEnhanced(AZURE)
    
    for ( c <- TrafficLightColor.values ) println(c.id + "\t" + c.toString())
    
    println( for ( c <- TrafficEnhanced.values) yield c.id + "\t" + c )
    
    println(TrafficLightColor(5))
    println(TrafficEnhanced(2))
    
    println(TrafficEnhanced.withName("TAN"))
    println(TrafficLightColor.withName("BLUE"))
    
  }
  def testEnum( color : TrafficLightColor.Value ){
    if ( color == BLUE ) {
      println(color)
    }else{
      println("unmatch")
    }
  }
  def testEnumEnhanced ( color : TrafficEnhanced){
    if ( color == AZURE ) {
      println(color)
    }else{
      println("unmatch")
    }
  }
}