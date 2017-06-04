package outerhaven.sfti

import scala.collection.mutable.ArrayBuffer
import scala.collection.JavaConversions.bufferAsJavaList
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer

import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.JavaConversions.mapAsJavaMap
import java.awt.font.TextAttribute._


/**
 * grammar for interoperating with Java
 */
class GrammarJavaInteroperation {
  def entrance() {
    println("### grammar for interoperating with Java")
    println("interoperating with Array")
    val command = ArrayBuffer[String]("ls", "-l", "/")
    val pb = new ProcessBuilder(command)
    val cmdResult: Buffer[String] = pb.command()
    println(cmdResult)    
    
    println("interoperating with Map")
    val scores1: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int];
    val scores2: scala.collection.mutable.Map[String, String] = System.getProperties
    val attr = Map(FAMILY -> "Serif", SIZE -> 12)
    val font = new java.awt.Font(attr)
  }
}