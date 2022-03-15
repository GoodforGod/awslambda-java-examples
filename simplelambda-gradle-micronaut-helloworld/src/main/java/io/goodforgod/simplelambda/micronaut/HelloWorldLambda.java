package io.goodforgod.simplelambda.micronaut;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.goodforgod.aws.simplelambda.micronaut.MicronautInputLambdaEntrypoint;
import io.goodforgod.graalvm.hint.annotation.NativeImageHint;
import io.micronaut.core.annotation.Introspected;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 31.07.2021
 */
@NativeImageHint(entrypoint = MicronautInputLambdaEntrypoint.class)
@Introspected
@Singleton
public class HelloWorldLambda implements RequestHandler<Request, Response> {

    private final ResponseService responseService;

    @Inject
    public HelloWorldLambda(ResponseService responseService) {
        this.responseService = responseService;
    }

    @Override
    public Response handleRequest(Request request, Context context) {
        return responseService.getResponse(request);
    }
}