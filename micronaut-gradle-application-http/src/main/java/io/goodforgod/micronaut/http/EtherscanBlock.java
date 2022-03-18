package io.goodforgod.micronaut.http;

import io.micronaut.core.annotation.TypeHint;
import java.util.List;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@TypeHint(value = { EtherscanBlock.class, EtherscanBlock.Uncle.class }, accessType = TypeHint.AccessType.ALL_PUBLIC)
public record EtherscanBlock(String blockNumber,
                             String timeStamp,
                             String blockMiner,
                             String blockReward,
                             String uncleInclusionReward,
                             List<Uncle> uncles) {

    public record Uncle(String miner, String unclePosition, String blockreward) {}
}
