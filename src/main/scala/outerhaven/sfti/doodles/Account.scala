package outerhaven.sfti.doodles

class Account {
  var id = Account.uniqueId()
  private var balance = 0.0
  def deposit(amount : Double) {
    balance += amount;
  }
}

object Account {
  private var last = 0
  def uniqueId() = {
    last +=1
    last
  }
  def main(args: Array[String]): Unit = {
    var acc = new Account
    println(acc.id)
    acc = new Account
    println(acc.id)
  }
}