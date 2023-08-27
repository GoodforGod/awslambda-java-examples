package io.goodforgod.spring;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@RegisterReflectionForBinding({Request.class, Response.class})
public class NativeConfig { }
