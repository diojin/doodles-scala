package outerhaven.codesample.ipoint.commentedout

class CassandraOperations {
    def cassandraPersist1() {
/*    val persistProps: (TaskContext, Iterator[(Int, EventWithDump)]) => Unit = (ctx, data) => {
        PersistFuncs.persistService.saveProps(data, ctx.partitionId())
    }
    
    def save(events: RDD[(Int, EventWithDump)]): Unit = {
        events.sparkContext.runJob(events, persistProps)
    }
    
    // eventSteaming as in kafkaConsumer1()
    eventSteaming.foreach(events: RDD[(Int, EventWithDump)] => save(events) _)
    
    class EventPersistService{
       val propCQL = s"insert into $eventRawTable(name,partition,property_name,severity,time,property_value) values(?,?,?,?,?,?)"
       val propStmt = session.prepare(propCQL)
       def saveProps(data: Iterator[(Int, EventWithDump)], partition: Int) = {
          data.zipWithIndex.flatMap(
              pe => {
                  val pIndex = (partition % 10000).toString
                  val dIndex = (pe._1._1 % 100000000).toString
                  val rIndex = (pe._2 % 100000000).toString
                  val index = dIndex + pIndex + rIndex
                  val e = pe._1._2
                  val time = new java.math.BigDecimal(s"${e.time % partitionP}.$index")
                  e.props.map(kv => {
                      val stmt = propStmt.bind()
                      stmt.setString(0, e.name)
                      stmt.setInt(1, (e.time / partitionP).toInt)
                      stmt.setString(2, kv._1)
                      stmt.setInt(3, e.severity)
                      stmt.setDecimal(4, time)
                      stmt.setString(5, kv._2)
                      stmt
                      //session.executeAsync(stmt)
                  })
              }
          ).batchSave()
      }
      implicit class BatchStatementSave(statements: Iterator[Statement]) {
          def batchSave() = {
              import scala.collection.JavaConversions._
              statements.grouped(batchSize).map(s => {
                  val batchStatement = new BatchStatement()
                  batchStatement.addAll(s)
                  (session.executeAsync(batchStatement), s)
              }).foreach(x => {
                  try {
                      val batchResult = x._1
                      batchResult.get()
                  } catch {
                      case e: Exception =>
                          e.printStackTrace()
                          x._2.foreach(statement => try {
                              session.executeAsync(statement)
                          } catch {
                              case subException: Exception => info(s"Error when executing each statement in a batch [${subException.getMessage}]")
                          })
                  }
              })
          }
      }
    }*/
  }
    
  def cassandraQueryExample1(){
    
/*    
 		import com.datastax.driver.core.Session
 		import scala.collection.JavaConversions._
 		
 		private def queryTemplate(r: PartitionRange, limit: Int = ParamConstants.CASSANDRA_SINGLE_QUERY_LIMIT_DEFAULT): String = {

        val partition = r.partition
        val currentTimePartition = System.currentTimeMillis() / Partition.SIZE
        val queryTable = if(currentTimePartition - partition < Partition.KEEP_DAYS) eventRawTable else eventLongKeepTable

        val timeCondition = if (r.isPart) s"""and time < ${r.from + 1} and time > ${r.to}""" else ""
          val propsCondition  = r.prop.split(",").map(p => s"'$p'").mkString(",")
        s"""select
            |time, property_value
            |from $queryTable
            |where
            |name='${r.viewpoint}'
            |and partition = ${r.partition}
            |and property_name = '${r.prop}'
            |and severity = ${r.severity}
            |$timeCondition
            |limit $limit""".stripMargin.replace('\n', ' ')
    }*/
    
    
    
    
  }
}