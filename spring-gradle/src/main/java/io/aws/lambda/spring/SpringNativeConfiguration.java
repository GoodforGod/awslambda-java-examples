package io.aws.lambda.spring;

import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.ResourceHint;
import org.springframework.nativex.type.NativeConfiguration;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 13.8.2021
 */
@NativeHint(resources = @ResourceHint(patterns = ".*native-image.properties"))
public class SpringNativeConfiguration implements NativeConfiguration {
}
