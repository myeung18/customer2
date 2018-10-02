package io.swagger.server.api.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import io.swagger.server.api.model.Customer2;

import java.util.List;
import java.util.Map;

public class DefaultApiVerticle extends AbstractVerticle {
    final static Logger LOGGER = LoggerFactory.getLogger(DefaultApiVerticle.class); 
    
    final static String GET_CUSTOMER2_SERVICE_ID = "GET_customer2";
    final static String POST_CUSTOMER2_SERVICE_ID = "POST_customer2";
    final static String PUT_CUSTOMER2_SERVICE_ID = "PUT_customer2";
    
    //TODO : create Implementation
    DefaultApi service = new DefaultApiImpl();

    @Override
    public void start() throws Exception {
        
        //Consumer for GET_customer2
        vertx.eventBus().<JsonObject> consumer(GET_CUSTOMER2_SERVICE_ID).handler(message -> {
            try {
                
                Customer2 result = service.customer2Get();
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
        //Consumer for POST_customer2
        vertx.eventBus().<JsonObject> consumer(POST_CUSTOMER2_SERVICE_ID).handler(message -> {
            try {
                Customer2 body = Json.mapper.readValue(message.body().getJsonObject("body").encode(), Customer2.class);
                
                Customer2 result = service.customer2Post(body);
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
        //Consumer for PUT_customer2
        vertx.eventBus().<JsonObject> consumer(PUT_CUSTOMER2_SERVICE_ID).handler(message -> {
            try {
                Customer2 body = Json.mapper.readValue(message.body().getJsonObject("body").encode(), Customer2.class);
                
                Customer2 result = service.customer2Put(body);
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
    }
}