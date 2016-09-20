package outerhaven.sfti.doodles


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
    
    val pcTester = new PrimaryConstructorTester("me", 38)
    println(pcTester.describe)
    
    println("start testing Object")
    printf("%d => %d\n", Account.uniqueNumber(), Account.uniqueNumber())
    val acc = new Account
    println(acc.id)
    
    DoNothingAction.undo()
    
    val newAcct = Account(233.34)
    println(newAcct.id)
    
    println("start enumeration")
    
    println(TrafficLightColor.ORANGE)
    
    testEnum(TrafficLightColor.BLUE)
    testEnum(TrafficLightColor.ORANGE)
  }
  def testEnum( color : TrafficLightColor.Value ){
    if ( color == TrafficLightColor.BLUE ) {
      println(color)
    }else{
      println("unmatch")
    }
    
  }
}