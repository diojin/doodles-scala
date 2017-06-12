package outerhaven.sfti

import java.io.PrintWriter
import java.util.Date

/**
 * grammar examples for Trait
 */
class GrammarTrait extends GrammarExample {
  def entrance() {
    println("### grammar examples for Trait")
    println("Objects with Traits")
    println("Now, nothing gets logged, which might seem pointless. ")
    println("But you can ¡°mix in¡± a better logger when constructing an object.")
    val account1 = new SavingAccount with ConsoleLogger
    val account2 = new SavingAccount with FileLogger
    
    // print message like, "Sun Feb 06 17:45:45 ICT 2011 Insufficient...", ShortLogger is invoked at first
    val acct1 = new SavingAccount with ConsoleLogger with TimestampLogger with ShortLogger
    // print message like, "Sun Feb 06 1..."
    val acct2 = new SavingAccount with ConsoleLogger with ShortLogger with TimestampLogger
  }
}

trait Logger {
  def log(msg : String)
}

trait ConsoleLogger extends Logger {
  def log (msg : String ){
    println(msg)
  }
}

trait FileLogger extends Logger {
  val out = new PrintWriter("app.log") // Part of the trait's constructor
  out.println("# " + new Date().toString) // Also part of the constructor
  def log(msg: String) { out.println(msg); out.flush() }
}

trait TimestampLogger extends Logger{
  abstract override def log(msg: String) {
    super.log(new java.util.Date() + " " + msg)
  }
}

trait ShortLogger extends Logger {
  val maxLength = 15 // See Section 10.8 on fields in traits
  abstract override def log(msg: String) {
    super.log(
      if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "...")
  }
}

class MyLogger extends Logger with Cloneable with Serializable{
  def log (msg : String) {println(msg)}
}

/**
 * Now, nothing gets logged, which might seem pointless. 
 * But you can ¡°mix in¡± a better logger when constructing an object.
 */
abstract class SavingAccount extends Account with Logger {
  def withdraw(amount: Double) {
     if (amount > balance) {
       log("Insufficient funds") 
     }else {
       balance -= amount
     }
  }
}

/** 
 *  self type
 *  Note that the trait does not extend the Exception class. Instead, it has a self type of Exception.
 *  That means, it can only be mixed into subclasses of Exception.
 */
trait LoggedException extends Logger {
  this: Exception =>
  def log() { log(getMessage()) }
}

trait LoggedException1 extends Logger {
  this: { def getMessage() : String } =>
  def log() { log(getMessage()) }
}
