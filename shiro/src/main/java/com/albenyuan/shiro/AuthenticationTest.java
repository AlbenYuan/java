package com.albenyuan.shiro;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
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

    private DefaultSecurityManager securityManager;

    private Realm realm;

    UsernamePasswordToken token;


    private String username = "AlbenYuan";

    private String password = "password";

    @Before
    public void before() {
        securityManager = new DefaultSecurityManager();
        token = new UsernamePasswordToken(username, password);
    }

    @Test
    public void testSimpleAccountRealm() {
        SimpleAccountRealm realm = new SimpleAccountRealm();
        realm.addAccount(username, password);
        this.realm = realm;
        securityManager.setRealm(realm);
        login();
    }


    @Test
    public void testIniRealm() {
        realm = new IniRealm("classpath:shiro.ini");
        securityManager.setRealm(realm);
        login();
    }

    @Test
    public void testJDBCRealm() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/shiro");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        JdbcRealm realm = new JdbcRealm();
        realm.setDataSource(dataSource);
        realm.setPermissionsLookupEnabled(true);
        this.realm = realm;
        securityManager.setRealm(realm);
        login();
    }

    private void login() {
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        // 登录
        subject.login(token);
        logger.info("login: {}", subject.isAuthenticated());
        // 登出
        subject.logout();
        logger.info("login: {}", subject.isAuthenticated());
//        token.setUsername(null);
//        token.setPassword(null);
        subject.login(token);
        logger.info("login: {}", subject.isAuthenticated());
    }


}
