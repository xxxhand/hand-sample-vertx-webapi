package hand.sample;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class ServerVerticle extends AbstractVerticle{
    @Override
    public void start(Future<Void> startFuture) throws Exception {

        HttpServerOptions opt = new HttpServerOptions();
        opt.setPort(8080);

        HttpServer httpServer = vertx.createHttpServer(opt);

        Router mainRouter = Router.router(vertx);
        mainRouter.route("/").handler((RoutingContext ctx) -> {
            ctx.response()
                    .putHeader("Content-Type", "text/plain")
                    .setStatusCode(200)
                    .end("Hello world");
        });
        mainRouter.get("/api").handler((RoutingContext ctx) -> {
            JsonObject res = new JsonObject();
            res.put("errorCode", 0);
            res.put("message", "");
            res.put("result", "Hello world");
            ctx.response()
                    .putHeader("Content-Type", "application/json")
                    .setStatusCode(200)
                    .end(Json.encode(res));
        });

        httpServer.requestHandler(mainRouter::accept);

        httpServer.listen(e -> {
            if (e.succeeded()) {
                System.out.println("Start http server success on port: " + httpServer.actualPort());
                startFuture.complete();
                return;
            }
            System.out.println("Fail to up http server");
            e.cause().printStackTrace();
            startFuture.fail(e.cause());
        });
    }
}
