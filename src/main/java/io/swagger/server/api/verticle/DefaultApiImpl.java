package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Customer2;

public class DefaultApiImpl implements DefaultApi {
    @Override
    public Customer2 customer2Get() {
        Customer2 mycust=new Customer2();
        mycust.setCategory("Go          ld");
        mycust.setName("Real Customer name will be stay here");
        mycust.setRegion("AMERican");
        mycust.setId(5);
        System.out.println("--------------------");
        return mycust;
    }

    @Override
    public Customer2 customer2Post(Customer2 body) {
        return null;
    }

    @Override
    public Customer2 customer2Put(Customer2 body) {
        return null;
    }
}
