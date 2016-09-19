package outerhaven.sfti.doodles

object Hello {
  def main(args: Array[String]) {
    println("hello world")
  }
}

object HelloNew extends App {  
  if (args.length > 0){
    println("hello " + args(0))
  }else{
    println("hello world")
  }
}