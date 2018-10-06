package com.heygis.common.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    /**
     * 項目的ApplicationContext，在別處通過util獲取到
     */
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static <T> T getBean(String name)
    {
        try
        {
            return (T) context.getBean(name);
        }
        catch (NoSuchBeanDefinitionException e)
        {
            e.printStackTrace();
            return null;
        }

    }
}
