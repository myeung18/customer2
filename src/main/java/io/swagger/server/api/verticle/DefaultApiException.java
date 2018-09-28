package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Customer2;
import io.swagger.server.api.MainApiException;

public final class DefaultApiException extends MainApiException {
    public DefaultApiException(int statusCode, String statusMessage) {
        super(statusCode, statusMessage);
    }
    
    

}