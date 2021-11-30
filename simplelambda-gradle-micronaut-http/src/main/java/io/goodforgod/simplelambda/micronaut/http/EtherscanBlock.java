package io.goodforgod.simplelambda.micronaut.http;

import io.goodforgod.graalvm.hint.annotation.TypeHint;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@TypeHint(value = { TypeHint.AccessType.ALL_DECLARED })
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
