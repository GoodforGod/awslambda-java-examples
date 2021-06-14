package io.aws.lambda.micronaut;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Introspected
public class HelloWorldLambda extends MicronautRequestHandler<Book, BookSaved> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public BookSaved execute(Book input) {
        logger.info("Processing input book...");
        return new BookSaved()
                .setName(input.getName())
                .setIsbn(UUID.randomUUID().toString());
    }
}
