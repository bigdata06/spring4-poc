package org.spring4.poc.util;

/**
 * Created by admin on 04/03/2015.
 */



/**
 * Extends AbstractDependencyInjectionSpringContextTests and adds support for application
 * context access via ContextSingletonBeanFactoryLocator
 *
 * Subclasses must override either getConfigLocations() or
 * getParentSelector()/getParentFactoryKey()
 *
 *
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;


public abstract class AbstractDependencyInjectionSpringContextWithParentTests extends AbstractDependencyInjectionSpringContextTests
{

    @Override
    protected String[] getConfigLocations() {
        return null;
    }

    @Override
//	protected ConfigurableApplicationContext getContext(Object key) {
//		ApplicationContext parent = getParentApplicationContext();
//		if (parent == null) {
//			assertNotNull("key", key);
//			return super.getContext(key);
//		} else
//			return (ConfigurableApplicationContext) parent;
//	}

    protected ConfigurableApplicationContext loadContextLocations(
            String[] locations) throws Exception {
        ApplicationContext parent = getParentApplicationContext();
        if (parent != null)
            throw new RuntimeException("never here");
        else
            return super.loadContextLocations(locations);
    }

    protected ApplicationContext getParentApplicationContext() {
        String selector = getParentSelector();
        String factoryKey = getParentFactoryKey();
        if (selector != null && factoryKey != null)
            return TheBeanFactory.getApplicationContext(selector, factoryKey);
        return null;
    }

    protected String getParentSelector() {
        return null;
    }

    protected String getParentFactoryKey() {
        return null;
    }

}
