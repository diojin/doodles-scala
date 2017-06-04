package outerhaven.sfti.definition

/**
 * an Enum example
 */
object TrafficLightColor extends Enumeration {
  val RED, GREEN, YELLOW = Value
  val BLUE = Value(5, "BLUE")
  val ORANGE = Value("Orange")
  val BLACK = Value(11)
}