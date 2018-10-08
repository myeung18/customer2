package io.swagger.server.api.predicate;

import io.swagger.server.api.model.Customer2;

import java.util.function.Predicate;

public class StudentPredicate implements Predicate<Customer2> {

    @Override
    public boolean test(Customer2 c2) {
        return c2.getId() == 3;
    }
}
