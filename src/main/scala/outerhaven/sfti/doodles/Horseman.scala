package com {
  package whatever {
    package impatient {
      class Horseman(val name: String, private val age: Int) {
        println("creating packaged horseman")
      }
    }
  }
}

package com.whatever.impatient {
  package person {
    class Person( var age: Int ){
      println("creating packaged person aging " + age)
    }
  }
}