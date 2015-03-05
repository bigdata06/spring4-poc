package org.spring4.poc.util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.context.ApplicationContext;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;

/**
 * Created by admin on 04/03/2015.
 */
public class TheBeanFactory {

    public static Object getBean(String name, Class type) {
        return getBean(null, null, name, type);
    }

    public static Object getBean(String selector,
                                 String factoryKey, String name, Class type) {
        if (selector == null)
            selector = "configurations/default-spring-context.xml";
        if (factoryKey == null)
            factoryKey = "spring-context.xml";
        BeanFactoryReference reference = ContextSingletonBeanFactoryLocator
                .getInstance(
                        System.getProperty("spring.configuration",
                                selector)).useBeanFactory(
                        factoryKey);
        BeanFactory beanFactory = reference.getFactory();
        return beanFactory.getBean(name, type);
    }

    public static ApplicationContext getApplicationContext(String selector, String factoryKey) {
        if (selector == null)
            selector = "configurations/default-spring-context.xml";
        if (factoryKey == null)
            factoryKey = "spring-context.xml";
        BeanFactoryReference reference = ContextSingletonBeanFactoryLocator
                .getInstance(
                        System.getProperty("spring.configuration",
                                selector)).useBeanFactory(
                        factoryKey);
        BeanFactory beanFactory = reference.getFactory();
        return (ApplicationContext) beanFactory;
    }
}