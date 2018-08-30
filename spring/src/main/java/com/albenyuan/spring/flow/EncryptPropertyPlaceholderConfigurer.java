package com.albenyuan.spring.flow;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * 配置文件解密处理
 *
 * @Author Alben Yuan
 * @Date 2018-04-08 11:20
 */

public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
            throws BeansException {
        try {
            String keys = props.getProperty("encryption.key");
            if (StringUtils.isNotEmpty(keys)) {
                String[] encryptProperties = keys.split(",");
                for (String property : encryptProperties) {
                    String value;
                    if (StringUtils.isNotEmpty(property)
                            && StringUtils.isNotEmpty(value = props.getProperty(property))) {
                        props.setProperty(property, decrypt(value));
                    }
                }
            }
            super.processProperties(beanFactory, props);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BeanInitializationException(e.getMessage());
        }
    }

    private String decrypt(String value) {
//        new String(DES.decrypt(new BASE64Decoder().decodeBuffer(value), "解密秘钥"))
        return value;
    }
}
