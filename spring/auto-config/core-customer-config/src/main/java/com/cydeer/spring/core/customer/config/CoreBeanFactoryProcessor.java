package com.cydeer.spring.core.customer.config;

import com.cydeer.spring.core.CoreBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.ClassUtils;

/**
 * @author song.z
 * @date 2022/2/16 10:00 下午
 */
public class CoreBeanFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if (!ClassUtils.isPresent("com.cydeer.spring.core.CoreBean", CoreBeanFactoryProcessor.class.getClassLoader())) {
            return;
        }

        if (beanFactory.containsBeanDefinition("coreBean")) {
            return;
        }
        
        if (beanFactory instanceof BeanDefinitionRegistry) {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(CoreBean.class);
            ((BeanDefinitionRegistry) beanFactory).registerBeanDefinition("coreBean", beanDefinition);
        } else {
            beanFactory.registerSingleton("coreBean", new CoreBean());
        }
    }
}
