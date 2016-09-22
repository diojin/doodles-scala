package outerhaven.sfti.doodles

object TrafficLightColor extends Enumeration{
  val RED, GREEN, YELLOW = Value
  val BLUE = Value(5, "BLUE")
  val ORANGE = Value("Orange")
  val BLACK = Value(11)
}

object TrafficEnhanced extends Enumeration{
  type TrafficEnhanced = Value
  val TAN, PURPLE, AZURE = Value
  
}