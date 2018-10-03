package io.swagger.server.api;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.phiz71.vertx.swagger.router.OperationIdServiceIdResolver;
import com.github.phiz71.vertx.swagger.router.SwaggerRouter;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.file.FileSystem;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class MainApiVerticle extends AbstractVerticle {
    final static Logger LOGGER = LoggerFactory.getLogger(MainApiVerticle.class); 
    
    final Router router = Router.router(vertx);

    private Map<String, Integer> list = new HashMap<>();
    
    @Override
    public void start(Future<Void> startFuture) throws Exception {



        Json.mapper.registerModule(new JavaTimeModule());
    	FileSystem vertxFileSystem = vertx.fileSystem();
        vertxFileSystem.readFile("swagger.json", readFile -> {
            if (readFile.succeeded()) {
                Swagger swagger = new SwaggerParser().parse(readFile.result().toString(Charset.forName("utf-8")));
                Router swaggerRouter = SwaggerRouter.swaggerRouter(Router.router(vertx), swagger, vertx.eventBus(), new OperationIdServiceIdResolver());

                swaggerRouter.get("/").handler(rc -> rc.response().end("hi there!"));
                swaggerRouter.get("/shopping").handler(this::getList);
                swaggerRouter.post("/shopping").handler(this::addToList);

                deployVerticles(startFuture);
                
                vertx.createHttpServer() 
                    .requestHandler(swaggerRouter::accept) 
                    .listen(8080);
                startFuture.complete();
            } else {
            	startFuture.fail(readFile.cause());
            }
        });        		        
    }

    private void addToList(RoutingContext rc) {
        JsonObject body = rc.getBodyAsJson();
        String name = body.getString("name");
        Integer qty = body.getInteger("quantity", 100);
        list.put(name, qty);
        getList(rc);
    }

    private void getList(RoutingContext rc) {
        list.put("polo", 2000000);
        rc.response().end(Json.encodePrettily(list));
    }

    public void deployVerticles(Future<Void> startFuture) {
        
        vertx.deployVerticle("io.swagger.server.api.verticle.DefaultApiVerticle", res -> {
            if (res.succeeded()) {
                LOGGER.info("DefaultApiVerticle : Deployed");
            } else {
                startFuture.fail(res.cause());
                LOGGER.error("DefaultApiVerticle : Deployement failed");
            }
        });
        
    }
}