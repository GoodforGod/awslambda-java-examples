package io.aws.lambda.spring;

import io.aws.lambda.spring.http.EtherscanBlock;
import io.aws.lambda.spring.http.EtherscanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 13.8.2021
 */
@Service
public class ResponseService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final EtherscanService etherscanService;

    @Autowired
    public ResponseService(EtherscanService etherscanService) {
        this.etherscanService = etherscanService;
    }

    public Response getResponse(Request request) {
        logger.info("Processing Block with number: {}", request.getBlockNumber());
        final long started = System.currentTimeMillis();

        final EtherscanBlock block = etherscanService.getBlockByNumber(request.getBlockNumber());

        logger.info("Block retrieval took '{}' millis", System.currentTimeMillis() - started);
        return new Response(block.getBlockReward(), "Hello Miner - " + block.getBlockMiner());
    }
}
