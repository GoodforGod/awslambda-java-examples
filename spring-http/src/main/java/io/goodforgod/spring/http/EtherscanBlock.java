package io.goodforgod.spring.http;

import java.util.List;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
public record EtherscanBlock(String blockNumber,
                             String timeStamp,
                             String blockMiner,
                             String blockReward,
                             String uncleInclusionReward,
                             List<Uncle> uncles) {

    public record Uncle(String miner, String unclePosition, String blockreward) {}
}
