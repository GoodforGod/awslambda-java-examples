package io.goodforgod.spring;

import io.goodforgod.spring.http.EtherscanBlock;
import io.goodforgod.spring.http.EtherscanBlockResponse;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 13.8.2021
 */
@SpringBootApplication
public class LambdaEntrypoint {

    public static void main(String[] args) {
        SpringApplication.run(LambdaEntrypoint.class, args);
    }

}
