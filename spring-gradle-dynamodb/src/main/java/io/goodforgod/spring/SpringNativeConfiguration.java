package io.goodforgod.spring;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.apache.commons.logging.impl.SimpleLog;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.ResourceHint;
import org.springframework.nativex.hint.TypeHint;
import org.springframework.nativex.type.NativeConfiguration;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 13.8.2021
 */
@TypeHint(types = { LogFactory.class, LogFactoryImpl.class, SimpleLog.class })
@NativeHint(resources = @ResourceHint(patterns = ".*native-image.properties"))
public class SpringNativeConfiguration implements NativeConfiguration {}
