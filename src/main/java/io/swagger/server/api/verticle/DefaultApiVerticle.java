package io.swagger.server.api.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import io.swagger.server.api.model.Customer2;
import io.swagger.server.api.MainApiException;

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
                service.customer2Get(result -> {
                    if (result.succeeded())
                        message.reply(new JsonObject(Json.encode(result.result())).encodePrettily());
                    else {
                        Throwable cause = result.cause();
                        manageError(message, cause, "GET_customer2");
                    }
                });
            } catch (Exception e) {
                logUnexpectedError("GET_customer2", e);
                message.fail(MainApiException.INTERNAL_SERVER_ERROR.getStatusCode(), MainApiException.INTERNAL_SERVER_ERROR.getStatusMessage());
            }
        });
        
        //Consumer for POST_customer2
        vertx.eventBus().<JsonObject> consumer(POST_CUSTOMER2_SERVICE_ID).handler(message -> {
            try {
                Customer2 body = Json.mapper.readValue(message.body().getJsonObject("body").encode(), Customer2.class);
                service.customer2Post(body, result -> {
                    if (result.succeeded())
                        message.reply(new JsonObject(Json.encode(result.result())).encodePrettily());
                    else {
                        Throwable cause = result.cause();
                        manageError(message, cause, "POST_customer2");
                    }
                });
            } catch (Exception e) {
                logUnexpectedError("POST_customer2", e);
                message.fail(MainApiException.INTERNAL_SERVER_ERROR.getStatusCode(), MainApiException.INTERNAL_SERVER_ERROR.getStatusMessage());
            }
        });
        
        //Consumer for PUT_customer2
        vertx.eventBus().<JsonObject> consumer(PUT_CUSTOMER2_SERVICE_ID).handler(message -> {
            try {
                Customer2 body = Json.mapper.readValue(message.body().getJsonObject("body").encode(), Customer2.class);
                service.customer2Put(body, result -> {
                    if (result.succeeded())
                        message.reply(new JsonObject(Json.encode(result.result())).encodePrettily());
                    else {
                        Throwable cause = result.cause();
                        manageError(message, cause, "PUT_customer2");
                    }
                });
            } catch (Exception e) {
                logUnexpectedError("PUT_customer2", e);
                message.fail(MainApiException.INTERNAL_SERVER_ERROR.getStatusCode(), MainApiException.INTERNAL_SERVER_ERROR.getStatusMessage());
            }
        });
        
    }
    
    private void manageError(Message<JsonObject> message, Throwable cause, String serviceName) {
        int code = MainApiException.INTERNAL_SERVER_ERROR.getStatusCode();
        String statusMessage = MainApiException.INTERNAL_SERVER_ERROR.getStatusMessage();
        if (cause instanceof MainApiException) {
            code = ((MainApiException)cause).getStatusCode();
            statusMessage = ((MainApiException)cause).getStatusMessage();
        } else {
            logUnexpectedError(serviceName, cause); 
        }
            
        message.fail(code, statusMessage);
    }
    
    private void logUnexpectedError(String serviceName, Throwable cause) {
        LOGGER.error("Unexpected error in "+ serviceName, cause);
    }
}
