package io.aws.lambda.spring.http;

import lombok.Getter;
import lombok.Setter;
import org.springframework.nativex.hint.TypeHint;

import java.util.List;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 20.08.2021
 */
@TypeHint(types = { EtherscanBlock.class, EtherscanBlock.Uncle.class })
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
