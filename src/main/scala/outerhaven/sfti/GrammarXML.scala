package outerhaven.sfti

import scala.xml.Null
import scala.xml.Attribute
import scala.xml.transform.RewriteRule
import scala.xml.Node
import scala.xml.Elem
import scala.xml.transform.RuleTransformer

/**
 * grammar examples for XML parsing
 */
class GrammarXML extends GrammarExample {
  def entrance() {
    println("### grammar examples for XML parsing")
    val doc = <html><head><title>Fred's Memoirs</title></head><body>...</body></html>
    val items = <li>Fred</li><li>Wilma</li>
    val elem = <a href="http://scala-lang.org">The <em>Scala</em> language</a>
    // xpath expressions
    val list = <dl><dt>Java</dt><dd>Gosling</dd><dt>Scala</dt><dd>Odersky</dd></dl>
    val languages = list \ "dt"
    doc \ "body" \ "_" \ "li"
    doc \\ "img"
    println("modify xml")
    val list1 = <ul><li>Fred</li><li>Wilma</li></ul>
    val list2 = list1.copy(label = "ol")
    // To add a child, make a call to copy like this:
    list1.copy(child = list1.child ++ <li>Another item</li>)
    // To add or change an attribute, use the % operator:
    val image = <img src="hamster.jpg"/>
    val image2 = image % Attribute(null, "alt", "An image of a hamster", Null)
    val image3 = image % Attribute(null, "alt", "An image of a frog",
      Attribute(null, "src", "frog.jpg", Null))

    // suppose you want to change all ul nodes in a document to ol.
    val rule1 = new RewriteRule {
      override def transform(n: Node) = n match {
        case e @ <ul>{ _* }</ul> => e.asInstanceOf[Elem].copy(label = "ol")
        case _ => n
      }
    }
    // val transformed = new RuleTransformer(rule1).transform(root)
  }
}