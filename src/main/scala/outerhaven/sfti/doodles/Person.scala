package outerhaven.sfti.doodles

class Person {
  private var privateAge = 0;
  def age = privateAge
  def age_=(value : Int) {
    if ( value > privateAge ) {
      privateAge = value
    }
  }
}