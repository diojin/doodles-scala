package outerhaven.sfti

/**
 * grammar examples for inheritance
 */
class GrammarInheritance extends GrammarExample{
  def entrance() {
    println("### grammar examples for inheritance")
    val p = null
    println( p.isInstanceOf[Parent] )  // false
    println( p.asInstanceOf[Parent])   // null
    
    val child = new Child
    if ( child.getClass == classOf[Child] ){
      println("child.getClass == classOf[Child] returns true")
    }
    
    if ( child.getClass != classOf[Parent] ){
      println("child.getClass != classOf[Parent] returns true")
    }
        
    println( child.isInstanceOf[Parent])    // true
    child match {
      case p: Parent => println("enter parent branch"); p.doSomething    // Process p as an Parent
      case c: Child => println("enter child branch"); c.doSomething
      case _ => println("child is not either Parent or Child")           // p wasn't an Employee
    }
   
    val someone = new MrUnknown {
      val age = 10
      var name = "so"
    }
    println(someone.name)

    def printAny(x: Any) { println(x) }
    def printUnit(x: Unit) { println(x) }
    printAny("Hello")       // Prints "Hello"
    printUnit("Hello")      // prints "()"
  }
}

class Parent( name : String, val age : Int ) {
  def doSomething {
    println("i am a parent")
  }
  
}


/**
 * This defines a subclass and a primary constructor that calls the superclass constructor
 */
class Child(name: String = "Nari", age: Int = 20, val salary: Double = 0.0 )extends Parent(name, age) {
  override def doSomething {
    println("i am a child")
  }
}

class MyShape(x: Int, y: Int) extends java.awt.Rectangle(x,y){
  
}

abstract class MrUnknown
{
  val age: Int          // No initializer¡ªthis is an abstract field with an abstract getter method
  var name : String    // Another abstract field, with abstract getter and setter methods
}

class NormalMan(val age: Int) extends MrUnknown{ // Subclass has concrete age property
  var name : String = "Nari"    // and concrete name property
}

