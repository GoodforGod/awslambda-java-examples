package io.aws.lambda.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.Function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import reactor.core.Fuseable;
import reactor.core.publisher.Flux;

@Disabled
@FunctionalSpringBootTest
class AwsLambdaRuntimeTests extends Assertions {

  @Autowired
  private FunctionCatalog catalog;

  @Test
  void responseSuccess() {
    final Response response = new Response();
    response.setName("Bob");
    response.setSaved(true);

    final Function<Request, Response> function = catalog.lookup(Function.class, RequestFunction.FUNCTION_NAME);

    final Request request = new Request();
    request.setName("Bob");
    final Response actual = function.apply(request);

    assertEquals(response, actual);
  }
}
