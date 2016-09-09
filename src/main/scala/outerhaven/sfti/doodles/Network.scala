package outerhaven.sfti.doodles

import scala.collection.mutable.ArrayBuffer

class Network {
  class Member(val name: String){
    val contacts = new ArrayBuffer[Member]
  }
  private val members = new ArrayBuffer[Network#Member]
  def join(name: String) = {
    val member = new Member(name)
    members += member
    member
  }
}