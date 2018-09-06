package com.albenyuan.spring.aware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

/**
 * @Author Alben Yuan
 * @Date 2018-09-06 16:36
 */
public class AwareSequence implements
        BeanNameAware,
        ApplicationContextAware,
        BeanFactoryAware,
        BeanClassLoaderAware,
        EnvironmentAware,
        EmbeddedValueResolverAware,
        MessageSourceAware,
        ResourceLoaderAware,
        ApplicationEventPublisherAware {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void setBeanName(String beanName) {
        logger.info("set beanName:{}", beanName);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("set beanFactory:{}", beanFactory);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("set applicationContext:{}", applicationContext);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        logger.info("set classLoader:{}", classLoader);
    }

    @Override
    public void setEnvironment(Environment environment) {
        logger.info("set environment:{}", environment);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        logger.info("set applicationEventPublisher:{}", applicationEventPublisher);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        logger.info("set resolver:{}", resolver);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        logger.info("set messageSource:{}", messageSource);
    }


    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        logger.info("set resourceLoader:{}", resourceLoader);
    }
}
