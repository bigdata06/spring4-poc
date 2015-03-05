package org.spring4.poc.util;



import junit.framework.Assert;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;



import java.util.Map;

/**
 * Created by admin on 04/03/2015.
 */
public class LocalSessionFactoryBeanUtil {

    public static LocalSessionFactoryBean getLocalSessionFactoryBean(
            ApplicationContext applicationContext) {
        Map beans = BeanFactoryUtils
                .beansOfTypeIncludingAncestors(
                        applicationContext,
                        LocalSessionFactoryBean.class);
//        Assert.assertEquals("LocalSessionFactoryBean",
//                1, beans.size());
        LocalSessionFactoryBean localSessionFactoryBean = (LocalSessionFactoryBean) beans
                .values().iterator().next();
        return localSessionFactoryBean;
    }
}