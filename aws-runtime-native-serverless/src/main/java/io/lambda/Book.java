package io.lambda;

import io.micronaut.core.annotation.TypeHint;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.3.2021
 */
@TypeHint(value = { Book.class }, accessType = { TypeHint.AccessType.ALL_PUBLIC })
public class Book {

    private final String id;
    private final String name;

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
