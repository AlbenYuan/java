package com.albenyuan.spring.aware;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

/**
 * @Author Alben Yuan
 * @Date 2018-08-29 16:26
 */
public class EmbeddedValueResolverAwarer implements EmbeddedValueResolverAware {

    private StringValueResolver resolver;

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;

    }

    public StringValueResolver getResolver() {
        return resolver;
    }
}
