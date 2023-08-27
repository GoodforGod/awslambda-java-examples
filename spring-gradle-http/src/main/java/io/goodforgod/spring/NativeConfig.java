package io.goodforgod.spring;

import io.goodforgod.spring.http.EtherscanBlock;
import io.goodforgod.spring.http.EtherscanBlockResponse;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@RegisterReflectionForBinding({Request.class, Response.class, EtherscanBlock.class, EtherscanBlockResponse.class})
public class NativeConfig { }
