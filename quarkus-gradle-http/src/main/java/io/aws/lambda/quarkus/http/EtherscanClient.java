package io.aws.lambda.quarkus.http;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 21.08.2021
 */
@Path("/api")
@RegisterRestClient(configKey = "etherscan-api")
public interface EtherscanClient {

    @GET
    @Path("/")
    @Produces(value = MediaType.APPLICATION_JSON)
    EtherscanBlockResponse getBlockByNumber(@QueryParam("module") String module,
                                            @QueryParam("action") String action,
                                            @QueryParam("blockno") int blockNumber);
}
