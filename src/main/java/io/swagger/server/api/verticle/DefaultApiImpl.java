package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Customer2;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

public class DefaultApiImpl implements DefaultApi {
    @Override
    public Customer2 customer2Get(Handler<AsyncResult<Customer2>> handler) {
        Customer2 mycust=new Customer2();
        mycust.setCategory("Gold");
        mycust.setName("Real Customer (polo) name here");
        mycust.setRegion("USA");
        mycust.setId(5);
        return mycust;
    }

    @Override
    public Customer2 customer2Post(Customer2 body, Handler<AsyncResult<Customer2>> handler) {
        return null;
    }

    @Override
    public Customer2 customer2Put(Customer2 body, Handler<AsyncResult<Customer2>> handler) {
        return null;
    }
}
