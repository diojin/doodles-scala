package outerhaven.sfti.doodles

class Account {
  var id = Account.uniqueNumber()
  private var balance = 0.0
  def deposit (amount : Double) {
    balance += amount
  }
}

object Account {
  private var lastNumber = 0;
  def uniqueNumber() = { lastNumber += 1; lastNumber }
  def apply( initialBalance : Double ) = {
    val res = new Account
    res.balance = initialBalance
    res
  }
}