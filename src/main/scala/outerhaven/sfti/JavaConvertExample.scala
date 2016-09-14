package outerhaven.sfti
import scala.collection.JavaConversions.bufferAsJavaList 
import scala.collection.mutable.ArrayBuffer
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer

import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.JavaConversions.mapAsJavaMap
import java.awt.font.TextAttribute._

object JavaConvertExample {
  def main(args: Array[String]): Unit = {
    println("try scala and java conversion")
    bufferAndJava
    mapAndJava
  }
  
  def bufferAndJava {
    val command = ArrayBuffer("ls", "-al", "/home/cay")
    val pb = new ProcessBuilder(command)
    val cmd: Buffer[String] = pb.command()
    println(cmd)      // ArrayBuffer(ls, -al, /home/cay)
  }
  
  def mapAndJava {
    val scores1: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int];
    val scores2: scala.collection.mutable.Map[String, String] = System.getProperties
    val attr = Map(FAMILY -> "Serif", SIZE -> 12)
    val font = new java.awt.Font(attr)
  }
  
}