package com.albenyuan.spring.aware;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @Author Alben Yuan
 * @Date 2018-08-29 16:30
 */
public class EnvironmentAwarer implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
