package com.albenyuan.mybatis.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @Author Alben Yuan
 * @Date 2018-11-21 16:47
 */
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, }

        )
})
public class QueryInterceptor implements Interceptor {

    private static Logger logger = LoggerFactory.getLogger(QueryInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("invocation:{}", invocation.getMethod().getName());
        logger.info("before ....");
        //如果当前代理是一个非代理对象，那么它就会调用真实拦截对象的方法，如果不是他会回调下一个代理对象的代理接口的方法
        Object result = invocation.proceed();
        logger.info("after .....");
        return result;

    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            Executor executor = (Executor) target;
            logger.info("target:{}", executor.getClass());
        }
        logger.info("target:{}", target);
        return target;
    }

    @Override
    public void setProperties(Properties properties) {
        logger.info("properties:{}", properties);
    }
}
