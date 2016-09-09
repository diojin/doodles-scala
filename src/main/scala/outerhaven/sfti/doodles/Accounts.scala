package outerhaven.sfti.doodles

object Accounts {
  private var lastNumber = 0
  def uniqueNumber() = {
    lastNumber +=1
    lastNumber
  }
}