package outerhaven.sfti

object Test extends App {

  def removeNode( p : Node ) {
    if ( null == p ){
      var next:Node = null
      var cur = p
      while ( null != cur  ){
        next = cur.next
        if ( null != next ){
          cur = next.copy()
        }
        cur.next = next
        cur = next       
      }
    }
  }
  
}

case class Node( var next: Node = null ){
  
}