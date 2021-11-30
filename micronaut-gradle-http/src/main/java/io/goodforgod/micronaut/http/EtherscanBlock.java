package io.goodforgod.micronaut.http;

import io.micronaut.core.annotation.TypeHint;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@TypeHint(value = { EtherscanBlock.class, EtherscanBlock.Uncle.class }, accessType = TypeHint.AccessType.ALL_PUBLIC)
@Setter
@Getter
public class EtherscanBlock {

    @Setter
    @Getter
    public static class Uncle {

        private String miner;
        private String unclePosition;
        private String blockreward;
    }

    private String blockNumber;
    private String timeStamp;
    private String blockMiner;
    private String blockReward;
    private String uncleInclusionReward;
    private List<Uncle> uncles;
}
