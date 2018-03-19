package outerhaven.codesample.ipoint.commentedout

class TwitterHttpServerExample {
    
  def twitterHttpServerExample() {
/*    
    class IPointServer extends HttpServer {

    override val modules = Seq(IPointCoreModule)

    override def configureHttp(router: HttpRouter) {
        router
            .filter[HttpFilter](true)
            .filter[LoggingMDCFilter[Request, Response]]
            .filter[TraceIdMDCFilter[Request, Response]]
            .filter[CommonFilters]
            .add[HelloController]
            .add[InsightController]
            .add[HistoryController]
            .add[DetailController]
            .add[ComputingController]
            .add[DumpController]
            .add[ViewpointController]
            .add[DashboardController]
            .add[RuleController]
            .add[CheckController]
    }

	}
*/
  }
  

}

// Twitter Controller example

/*
import java.util.UUID
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject

import com.codahale.metrics.{ConsoleReporter, Gauge, MetricRegistry}
import com.coupang.xpoint.api.core.service.HelloService
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import org.jboss.netty.handler.codec.http.DefaultCookie

class HelloController @Inject()(hello: HelloService) extends Controller {

    lazy val metrics = {
        val m = new MetricRegistry()
        val reporter = ConsoleReporter.forRegistry(m)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.MILLISECONDS)
            .build()
        reporter.start(10, TimeUnit.SECONDS)
        m
    }
    private lazy val order = new Order(metrics, "order")

    private lazy val responseTimer = metrics.timer(MetricRegistry.name(this.getClass(), "responses"));


    get("/") { request: Request =>
        response.ok.json(""" {"projectName": "Xpoint-Api"} """)
    }

    get("/hello") { request: Request =>
        debug("hello controller is on action")

        hello.hello(request.params.getOrElse("name", "noname"))
    }

    get("/test/:name") { request: Request =>
        debug("hello controller is on action")

        hello.hello(request.params.getOrElse("name", "noname"))
    }

    get("/session") { request: Request =>
        debug("hello controller is on action")
        request.params.get("user") match {
            case None =>
                request.cookies.get("user") match {
                    case None =>
                        val user = UUID.randomUUID().toString
                        val c = new DefaultCookie("user", user)
                        //c.setSecure(true)
                        c.setMaxAge(10000)
                        c.setPath("/")
                        response.ok(hello.hello(user)).cookie(c).toFuture
                    case Some(userCookie) =>
                        hello.hello(userCookie.value)
                }

            case Some(userParam) =>
                val c = new DefaultCookie("user", userParam)
                //c.setSecure(true)
                c.setMaxAge(10000)
                c.setPath("/")
                response.ok(hello.hello(userParam)).cookie(c).toFuture
        }

    }

    get("/count") { request: Request =>
        val timer = responseTimer.time()
        try {
            response.ok.json(s"""{"count": "${order.increase()}"} """)
        } finally {
            timer.stop()
        }

    }

}


class Order(metrics: MetricRegistry, name: String) {
    val count: AtomicLong = new AtomicLong(0)

    metrics.register(MetricRegistry.name(this.getClass, name, "size"),
        new Gauge[Long] {
            override def getValue(): Long = {
                count.get()
            }
        })

    def increase() = count.incrementAndGet()
}


import com.twitter.inject.Logging

class HelloService (world: WorldService) extends Logging{
    def hello(name: String) = {

        debug(s"""$name is visiting""")

        s"""$name is coming to the ${world.world()}"""
    }
}


*/

