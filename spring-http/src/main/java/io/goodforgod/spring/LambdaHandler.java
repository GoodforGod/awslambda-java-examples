package io.goodforgod.spring;

import io.goodforgod.spring.http.EtherscanBlock;
import io.goodforgod.spring.http.EtherscanService;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 13.8.2021
 */
@Service
public class LambdaHandler implements Function<Request, Response> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final EtherscanService etherscanService;

    @Autowired
    public LambdaHandler(EtherscanService etherscanService) {
        this.etherscanService = etherscanService;
    }

    @Override
    public Response apply(Request request) {
        logger.info("Processing Block with number: {}", request.blockNumber());
        final long started = System.currentTimeMillis();

        final EtherscanBlock block = etherscanService.getBlockByNumber(request.blockNumber());

        logger.info("Block retrieval took '{}' millis", System.currentTimeMillis() - started);
        return new Response(block.blockReward(), "Hello Miner - " + block.blockMiner());
    }
}
