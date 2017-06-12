package outerhaven.sfti

/**
 * grammar examples for class/object
 */
class GrammarClass extends GrammarExample {
  def entrance(){
    println("### grammar examples for class/object")
    val counter = new Counter() // or new Counter()
    counter.increment()
    println(counter.current)    // or counter.current() 
    println(counter.enforcedCurrent)  // can't use counter.enforcedCurrent()
    counter.newprop = 10
    println(counter.current())
    println(counter.newprop)
    println("example for object") 
    println(LonelyAccount.newUniqueNumber())
  }
}

class Counter {
  private var value = 0            // You must initialize the field
  def increment() { value += 1}  // Methods are public by default
  def current() = value  
  def enforcedCurrent = value
  def newprop = value
  def newprop_=(newvalue : Int) {value = newvalue}
}

class Person {
  var name = ""
  var age = 0
  def this( name: String ){ // An auxiliary constructor
    this()        // Calls primary constructor
    this.name = name
  }
  
  def this( name: String, age : Int ){ // An auxiliary constructor
    this(name)    // Calls previous auxiliary constructor
    this.age = age
  }
}

// class with primary constructor
class NewPerson(val name: String = "", private var age: Int = 0 ) {
  println("initiating the object")
}

/**
 * an object without its companion class
 */
object LonelyAccount{
  private var lastNumber = 0
  def newUniqueNumber () = { lastNumber += 1; lastNumber }
}

class Account {
  var id = Account.newUniqueNumber()
  protected var balance = 0.0
  def deposit(amount : Double) {
    balance += amount
  }
}
// companion object
object Account{
  private var lastNumber = 0
  def newUniqueNumber () = { lastNumber += 1; lastNumber }
}

abstract class UndoableAction(val description: String) {
  def undo(): Unit
  def redo(): Unit
}

object DoNothingAction extends UndoableAction("Do nothing") {
  override def undo() {}
  override def redo() {}
}
