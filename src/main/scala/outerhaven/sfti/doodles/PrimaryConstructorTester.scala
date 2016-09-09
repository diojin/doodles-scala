package outerhaven.sfti.doodles

import java.util.Properties
import java.io.FileReader

class PrimaryConstructorTester(var name: String, var age: Int) {
  println("about to start primary constuctor")
  def description = name + "is\t" + age + " years old"
  private val props = new Properties
  props.load(new FileReader("myproperties.properties"))
  
}