package org.spring4.poc.util;

/**
 * Created by admin on 04/03/2015.
 */



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;


/**
 * Base class for writing unit tests that use Hibernate. Makes the Hibernate
 * Configuration available to subclasses
 */

public abstract class HibernateORMTestCase extends
        AbstractDependencyInjectionSpringContextWithParentTests {

    protected Log logger = LogFactory.getLog(getClass());

    protected SessionFactory sessionFactory;

    protected Configuration configuration;

    private LocalSessionFactoryBean localSessionFactoryBean;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Configuration getConfiguration() {
        if (configuration == null) {
            localSessionFactoryBean = LocalSessionFactoryBeanUtil
                    .getLocalSessionFactoryBean(applicationContext);
            configuration = localSessionFactoryBean.getConfiguration();
        }
        return configuration;
    }

}

