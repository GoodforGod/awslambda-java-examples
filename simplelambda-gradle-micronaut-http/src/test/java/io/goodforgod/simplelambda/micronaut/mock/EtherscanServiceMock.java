package io.goodforgod.simplelambda.micronaut.mock;

import io.goodforgod.aws.lambda.simple.convert.Converter;
import io.goodforgod.aws.lambda.simple.http.SimpleHttpClient;
import io.goodforgod.simplelambda.micronaut.http.EtherscanBlock;
import io.goodforgod.simplelambda.micronaut.http.EtherscanService;
import io.micronaut.context.annotation.Primary;
import io.micronaut.context.annotation.Replaces;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 30.11.2021
 */
@Primary
@Replaces(EtherscanService.class)
@Singleton
public class EtherscanServiceMock extends EtherscanService {

    @Inject
    public EtherscanServiceMock(Converter converter, SimpleHttpClient httpClient) {
        super(converter, httpClient);
    }

    @Override
    public EtherscanBlock getBlockByNumber(int blockNumber) {
        return new EtherscanBlock("1",
                "1438269988",
                "0x05a56e2d52c817161883f50c441c3228cfe54d9f",
                "5000000000000000000",
                "0",
                List.of());
    }
}
