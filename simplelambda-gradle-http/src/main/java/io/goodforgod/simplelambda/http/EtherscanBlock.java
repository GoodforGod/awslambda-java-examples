package io.goodforgod.simplelambda.http;

import io.goodforgod.graalvm.hint.annotation.TypeHint;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@TypeHint
@Setter
@Getter
public class EtherscanBlock {

    @Setter
    @Getter
    public static class Uncle {

        public String miner;
        public String unclePosition;
        public String blockreward;
    }

    public String blockNumber;
    public String timeStamp;
    public String blockMiner;
    public String blockReward;
    public String uncleInclusionReward;
    public List<Uncle> uncles;
}
