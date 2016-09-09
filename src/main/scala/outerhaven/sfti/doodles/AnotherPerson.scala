package outerhaven.sfti.doodles

import scala.beans.BeanProperty

class AnotherPerson {
  var name : String = "test"
  var age : Int = 100
  def this(name: String) {
    this()
    this.name = name
  }
  def this(name: String, age: Int ){
    this(name)
    this.age = age;
  }
  def main(args: Array[String]): Unit = {
    val person = new AnotherPerson("dio", 12)
    printf("%s\t%d\n", person.name, person.age)
    
  }
}

class Cat ( var name: String, var age: Int){
  
}