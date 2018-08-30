package com.albenyuan.spring.aware;

import org.springframework.context.*;

/**
 * @Author Alben Yuan
 * @Date 2018-08-29 16:16
 */
public class ApplicationEventPublisherAwarer implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public ApplicationEventPublisher getPublisher() {
        return publisher;
    }
}
