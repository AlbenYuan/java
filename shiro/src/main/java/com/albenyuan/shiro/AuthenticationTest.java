package com.albenyuan.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-05-11 16:38
 */
public class AuthenticationTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Realm realm;

    private String username = "AlbenYuan";

    private String password = "password";

    @Before
    public void before() {
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        simpleAccountRealm.addAccount(username, password);
        realm = simpleAccountRealm;

//        realm = new IniRealm("classpath:shiro.ini");


    }

    @Test
    public void testAuthentication() {

        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        securityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();


        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        subject.login(token);

        logger.info("login: {}", subject.isAuthenticated());

        subject.logout();

        logger.info("login: {}", subject.isAuthenticated());

//        token.setUsername(null);
        token.setPassword(null);

        subject.login(token);

        logger.info("login: {}", subject.isAuthenticated());
    }


}
