package io.goodforgod.spring.http;

import java.util.List;
import org.springframework.nativex.hint.TypeHint;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@TypeHint(types = { EtherscanBlock.class, EtherscanBlock.Uncle.class })
public record EtherscanBlock(String blockNumber,
                             String timeStamp,
                             String blockMiner,
                             String blockReward,
                             String uncleInclusionReward,
                             List<Uncle> uncles) {

    public record Uncle(String miner, String unclePosition, String blockreward) {}
}
