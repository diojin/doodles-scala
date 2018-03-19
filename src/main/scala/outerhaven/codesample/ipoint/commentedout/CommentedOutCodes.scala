package outerhaven.codesample.ipoint.commentedout

class CommentedCode {
  def kafkaConsumer1() {
/*    val eventSteaming = {

        import setting._
        import postprocessor.ProcessorFuncs.eventDecoder

        val receivers   = mandatory[Int](RECEIVERS_SETTING_KEY)
        val topics      = mandatory[String](TOPICS_SETTING_KEY)
        val zk          = mandatory[String](ZK_SETTING_KEY)
        val group       = read[String](TP_GRP_SETTING_KEY).getOrElse(System.currentTimeMillis().toString) + appName.replaceAll("\\W+", ".").toLowerCase()
        val timeout     = "10000"


        println(s"zk=$zk, topic=$topics, group=$group, receivers=$receivers")


        val kafkaParams  = Map[String, String](
            "zookeeper.connect" -> zk,
            "group.id" -> group,
            "zookeeper.connection.timeout.ms" -> timeout
        )
        val topicMap: Map[String, Int] =  topics.split(",").map{t => t.trim -> 1 }.toMap

        (1 to receivers)
            //config # of receivers
            .map { _ => KafkaUtils.createStream[String, String, StringDecoder, StringDecoder](
            ssc,
            kafkaParams,
            topicMap,
            StorageLevel.MEMORY_AND_DISK_SER_2
        )}
        .reduce((sa: DStream[(String, String)], sb: DStream[(String, String)]) => sa.union(sb))
        .repartition(partitions)
        .map(kv => eventDecoder.fromString(kv._2))
        .filter(_.nonEmpty)
        .map(_.get)
        .repartition(partitions)
    }*/
  }
  
  def elasticSearchIndex1() {
/*    eventSteaming
        .flatMap(e => {
            e.props.map(
                kv => {
                    ((e.name, e.severity), (e.props.keySet, e.time, 1))
                }
            )
        })
        .repartition(partitions)
        .reduceByKey((a, b) => {
            (a._1 ++ b._1, if(a._2 > b._2) a._2 else b._2, a._3 + b._3)
        })
        .repartition(partitions)
        .map(e => (e._1._1, e._1._2, e._2._1, e._2._2, e._2._3))
        .foreachRDD(rdd => rdd.index())
    */
    
/*    val maxBulkSize = 1024 * 1024 * 5

    def index(docs: Iterator[(String, Int, Set[String], Long, Int)])= {

        val docsSeq = docs.toSeq
        val propsSetByName = postQueryByNames(docsSeq.map(x => x._1))

        val tail = docsSeq
        .map(l => {
            val name = l._1
            val props = propsSetByName.get(name) match {
                case None => l._3.mkString(",")
                case Some(p) => (l._3 ++ p).mkString(",")
            }
            debug(s"props-> $props, name->$name")

            val id      = s"$name^${l._2}"
            val index   = s"""{"index":{"_index":"viewpoint","_type":"index","_id":"$id"}}"""
            val fields  = s""""name":"${l._1}","props":"$props","severity":${l._2},"time":${l._4},"last_count":${l._5} """
            val tree    = l._1.split('.').zipWithIndex.map(kv => s""""${kv._2 + 1}":"${kv._1}"""").mkString(",")

            s"""$index
               |{$fields, "tree":{$tree}}
               |""".stripMargin.replace(" ","")
        })
        .reduce((a, b)=>{
            val body = a + "\n" + b
            if(body.length >= maxBulkSize){
                postBulkUpdate(body)
                ""
            }else{
                body
            }
        })

        postBulkUpdate(tail)
    }*/
    
/*  
    import com.fasterxml.jackson.databind.JsonNode
    import com.twitter.finagle.http.Version.Http11
    import com.twitter.finagle.http.{Method, Request}
    import com.twitter.finatra.json.FinatraObjectMapper
    import com.twitter.inject.Logging
    import com.twitter.io.Buf.ByteArray
    import com.twitter.io.Reader
    import com.twitter.util.Await
    private def postBulkUpdate(body: String): Unit = {
        debug("index: " + body)
        val httpRequest = Request(Http11, Method.Post, s"/_bulk",  Reader.fromBuf(ByteArray(body.getBytes: _*)))
        val rs = httpService(httpRequest)
                .onSuccess(r => {
                    debug(r.contentString)
                })
               .onFailure(e=>warn("Index failed", e))

        Await.ready(rs)
    }*/
    
/*    private def postQueryByNames(names: Seq[String]): Map[String, Set[String]] = {
        names.size match {
            case 0 => Map.empty
            case s =>
                val namesStr = names.map(name => s""" "$name" """).mkString(",")
                val data =
                    s"""
                       |{
                       |  "size": ${s * 3},
                       |  "fields": ["name","props"],
                       |  "query": {
                       |    "terms": {
                       |      "name": [$namesStr]
                       |    }
                       |  }
                       |}
                    """.stripMargin

                val httpRequest = Request(Http11, Method.Post, s"/viewpoint/index/_search",  Reader.fromBuf(ByteArray(data.getBytes: _*)))

                try {
                    val rs = httpService(httpRequest)
                        .onSuccess(r => {
                            debug(r.contentString)
                        })
                        .onFailure(e=>warn("Index failed", e))
                        .map(r => {
                            import scala.collection.JavaConversions._
                            val resultNode = objectMapper.parse[JsonNode](r.contentString)
                            resultNode.at("/hits/hits").elements().map(h => {
                                val name = h.at("/fields/name").elements().toSeq.head.asText()
                                val props = h.at("/fields/props").elements().toSeq.head.asText()
                                (name, props.split(",").toSet)
                            }).toSeq.foldLeft(Map[String, Set[String]]()) { (sum, ele) => {
                                sum.get(ele._1) match {
                                    case None => sum + ele
                                    case Some(p) => sum + (ele._1 -> (ele._2 ++ p))
                                }
                            }}
                        })
                    Await.result(rs)

                } catch {
                    case e: Throwable =>
                        error(s"Query props by names faild($names)")
                        Map.empty
                }


        }

    }
    */
  }
  
  def googleCacheExample1() {
/*    import com.google.common.cache.{Cache, CacheBuilder}

    object FormulaCacheHolder {
    
        val eventCache: Cache[String, Event] =  CacheBuilder.newBuilder()
                .expireAfterWrite(2, TimeUnit.MINUTES)
                .build()
    
        val eventGroupCache: Cache[String, Seq[EventGroup]] = CacheBuilder.newBuilder()
                .expireAfterWrite(2, TimeUnit.MINUTES)
                .build()
    
        val eventSeqCache: Cache[String, Seq[Event]] =  CacheBuilder.newBuilder()
            .expireAfterWrite(2, TimeUnit.MINUTES)
            .build()
    
        val eventCountEstimate: Cache[String, String] =  CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build()
    }
    
    get("/computing") {request: DSLRequest =>
        val dsl = request.q
        val result = futurePool {
            FormulaCacheHolder.eventSeqCache.get(dsl, new Callable[Seq[Event]] {
                override def call(): Seq[Event] = {
                    computingService.queryByDsl(request.q)
                }
            })
        }
        result
    }*/    
    
  }
  
  def twitterPoolExample1() {
/*  
 		import com.twitter.finatra.utils.FuturePools  
		def futurePool = {
        FuturePools.unboundedPool("CallbackConverter")
    }
    
    get("/dashboard/list") { request: Request =>
      futurePool {
          elasticsearchService.getDashboardList
      }    
    }
*/
  }
  
}