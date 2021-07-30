package io.aws.lambda.spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class HelloWorldLambda implements Function<String, String> {

    public static final String FUNCTION_NAME = "requestHandler";

    private final ResponseService responseService;
    private final ObjectMapper mapper;

    @Autowired
    public HelloWorldLambda(ResponseService responseService, ObjectMapper mapper) {
        this.responseService = responseService;
        this.mapper = mapper;
    }

    @Override
    public String apply(final String requestAsJson) {
        try {
            final Request request = mapper.readValue(requestAsJson, Request.class);
            final Response response = responseService.getResponse(request);
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
