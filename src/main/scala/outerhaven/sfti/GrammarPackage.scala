package outerhaven.sfti
import definition.Colleague._
import java.awt.{Color, Font}
import java.util.{HashMap => _, _}
import scala.collection.mutable._
/**
 * grammar for package
 */

class GrammarPackage extends GrammarExample {
  def entrance() {
    println("### grammar for package")
    val employee = new _root_.outerhaven.sfti.outerhaven.sfti.definition.Employee
    employee.doSomething()
    val manager = new outerhaven.sfti.definition.Manager
    manager.doSomething
    definition.Colleague.doSomething
    println("use package object")
    println(definition.instruction)
    println("import all members of objects")
    println(mysecret)    
    println("import can be anywhere, and can have selector")
    import java.util.{HashMap => JavaHashMap}
    val maps = new JavaHashMap    
  }
}


package outerhaven {
  package sfti {
    package definition {
      class Manager {
        def doSomething {
          println("i am a manager")
          val employees = new collection.mutable.ArrayBuffer[Employee]

        }
      }
    }
  }
}

package outerhaven.sfti.definition {
  class Employee{
    val eachSecret = "each employees' secret"
    def doSomething(){
      println("i am an employee")  
    }
  }
}

package object definition {
  val instruction = "this is from the package object for outerhaven.sfti.definition"
}

package definition {
  object Colleague {
    val mysecret = "colleague's secret"    
    def doSomething{
      println("i am a colleague")
      println(instruction)
    }
  }
}
