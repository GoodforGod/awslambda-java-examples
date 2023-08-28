package io.goodforgod.quarkus;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.goodforgod.quarkus.http.EtherscanBlock;
import io.goodforgod.quarkus.http.EtherscanService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 28.07.2021
 */
@Named("hello-world")
@ApplicationScoped
public class LambdaHandler implements RequestHandler<Request, Response> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final EtherscanService etherscanService;

    public LambdaHandler(EtherscanService etherscanService) {
        this.etherscanService = etherscanService;
    }

    @Override
    public Response handleRequest(Request request, Context context) {
        logger.info("Processing Block with number: {}", request.blockNumber());
        final long started = System.currentTimeMillis();

        final EtherscanBlock block = etherscanService.getBlockByNumber(request.blockNumber());

        logger.info("Block retrieval took '{}' millis", System.currentTimeMillis() - started);
        return new Response(block.blockReward(), "Hello Miner - " + block.blockMiner());
    }
}
