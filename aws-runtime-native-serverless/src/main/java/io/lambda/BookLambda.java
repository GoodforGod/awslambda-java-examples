package io.lambda;

import io.aws.lambda.runtime.Lambda;
import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;
import java.util.UUID;

@Singleton
public class BookLambda implements Lambda<Book, User> {

    @Override
    public Book handle(@NotNull User user) {
        return new Book(UUID.randomUUID().toString(), user.getName());
    }
}
