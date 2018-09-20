package com.skych.fullsystem.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class SpringContainerTest {
    
    //beanFactory容器创建
    private static ResourcePatternResolver resolver
                        = new PathMatchingResourcePatternResolver();
    private static Resource resource = null;
    private static DefaultListableBeanFactory beanFactory
                        = new DefaultListableBeanFactory();
    private static XmlBeanDefinitionReader reader
                        = new XmlBeanDefinitionReader(beanFactory);
    private volatile boolean isInitBeanFactory = false;
    private static String DEFAULT_URL = "url";
    private void initBeanFactory() {
        if (isInitBeanFactory) {
            return;
        }
        resource = resolver.getResource(DEFAULT_URL);
        reader.loadBeanDefinitions(resource);
        isInitBeanFactory =  true;
    }
    public void setResourcePath(String path) {
        DEFAULT_URL = path;
        isInitBeanFactory = false;
        initBeanFactory();
    }
    public Object getBean(String beanName) {
        if (!isInitBeanFactory) {
            initBeanFactory();
        }
        return beanFactory.getBean(beanName);
    }
    
    
    //ApplicationContext容器创建
    @SuppressWarnings("resource")
    public Object getBeanViaApplicationContext(String beanName) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//        ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
        
        return ctx.getBean(beanName);
    }
    
    @SuppressWarnings("resource")
    public Object getBeanViaAnnotation(String beanName) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeansConfiguration.class);
        return ctx.getBean(beanName);
    }
}
