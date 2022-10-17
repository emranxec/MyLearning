package com.xec.spring.BeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class DemoBeanPostProcessor1 implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(DemoBeanPostProcessor1.class.getName() + " :: processing bean after init of bean: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(DemoBeanPostProcessor1.class.getName() + " :: processing bean before init of bean: " + beanName);
        return bean;
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
