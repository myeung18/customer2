package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Customer2;
import io.swagger.server.api.MainApiException;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

import java.util.List;
import java.util.Map;

public interface DefaultApi  {
    //GET_customer2
    Customer2 customer2Get(Handler<AsyncResult<Customer2>> handler);
    
    //POST_customer2
    Customer2 customer2Post(Customer2 body, Handler<AsyncResult<Customer2>> handler);
    
    //PUT_customer2
    Customer2 customer2Put(Customer2 body, Handler<AsyncResult<Customer2>> handler);
    
}
