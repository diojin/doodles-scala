package outerhaven.codesample.ipoint

object MiscCodes extends App {
  
  stringOperations
  optionOperatedAsMap
 
  def stringOperations {
    val currentTime = 1000
    val queryDuration = 100
    val query = 
      s"""
         |{
         |   "from": 0,
         |   "size": 1000000,
         |   "query": {
         |       "filtered": {
         |           "query": {
         |               "bool": {
         |                   "must": [{
         |                       "range": {
         |                           "timestamp": {
         |                               "from": ${currentTime - queryDuration},
         |                               "to": $currentTime,
         |                               "include_lower": true,
         |                               "include_upper": true
         |                           }
         |                       }
         |                   }, {
         |                       "range": { "level": { "lte": 3 }}
         |                   }]
         |               }
         |           },
         |           "filter": {
         |               "exists": { "field": "loggerName" }
         |           }
         |       }
         |   }
         |}
        """.stripMargin
     println(query)
     println(s"$currentTime/$queryDuration")
     
     case class Test(name: String)
     val test1 = Test("me")
     println(s"${test1.name}")

  }
  
  def optionOperatedAsMap() {
    val source :Option[String] = Option("k1=v1,k2=v2")
    // Option[scala.collection.immutable.Set[String]]
    val inter = source.map(_.split(",").toSet)
    println(inter.getOrElse(Set.empty))
  }
  
}

