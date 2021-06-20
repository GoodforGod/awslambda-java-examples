package io.aws.lambda.spring;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.function.Function;

@Slf4j
public class RequestFunction implements Function<String, String> {

    public static final String FUNCTION_NAME = "requestFunction";

    @Override
    public String apply(final String request) {
        log.info("Started converting request...");
//        final Response response = createResponse(request);
        log.info("Finished converting response..");
//        return response;
        return "{\"id\":\"" + UUID.randomUUID() + "\"}";
    }

    private Response createResponse(final Request request) {
        final Response response = new Response();
        response.setName(request.getName());
        response.setSaved(true);
        return response;
    }
}
