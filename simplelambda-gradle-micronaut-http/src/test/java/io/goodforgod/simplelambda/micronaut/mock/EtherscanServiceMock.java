package io.goodforgod.simplelambda.micronaut.mock;

import io.goodforgod.aws.simplelambda.convert.Converter;
import io.goodforgod.aws.simplelambda.http.SimpleHttpClient;
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
        final EtherscanBlock block = new EtherscanBlock();
        block.setBlockNumber("1");
        block.setBlockReward("5000000000000000000");
        block.setTimeStamp("1438269988");
        block.setUncleInclusionReward("0");
        block.setBlockMiner("0x05a56e2d52c817161883f50c441c3228cfe54d9f");
        block.setUncles(List.of());
        return block;
    }
}
