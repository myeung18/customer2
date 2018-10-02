package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Customer2;

import java.util.List;
import java.util.Map;

public interface DefaultApi  {
    //GET_customer2
    public Customer2 customer2Get();
    
    //POST_customer2
    public Customer2 customer2Post(Customer2 body);
    
    //PUT_customer2
    public Customer2 customer2Put(Customer2 body);
    
}
