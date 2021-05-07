package io.micronaut.aws;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;

import java.util.UUID;

@Introspected
public class BookLambda extends MicronautRequestHandler<Book, BookSaved> {

    @Override
    public BookSaved execute(Book input) {
        return new BookSaved()
                .setName(input.getName())
                .setIsbn(UUID.randomUUID().toString());
    }
}
