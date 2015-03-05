
package org.spring4.poc.util;

import org.springframework.beans.*;
import org.springframework.context.*;
import org.springframework.orm.hibernate3.*;

/*
 * Resets the database by creating the schema using LocalSessionFactoryBean dropDatabaseSchema
 * and createDatabaseSchema 
 */

public class ResetDatabaseByRecreatingSchemaStrategy
        implements DatabaseResetStrategy,
        ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(
            ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void resetDatabase() {
        LocalSessionFactoryBean localSessionFactoryBean = LocalSessionFactoryBeanUtil
                .getLocalSessionFactoryBean(applicationContext);
        localSessionFactoryBean.dropDatabaseSchema();
        localSessionFactoryBean.createDatabaseSchema();
    }

}
