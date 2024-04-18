// package com.icekiwi.banking.configurations;

// import org.springframework.beans.BeansException;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.ApplicationContextAware;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.thymeleaf.spring6.SpringTemplateEngine;
// import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
// import org.thymeleaf.templatemode.TemplateMode;
// import org.thymeleaf.templateresolver.ITemplateResolver;
// import org.thymeleaf.standard.StandardDialect;
// import nz.net.ultraq.thymeleaf.LayoutDialect;

// @Configuration
// public class ThymeleafConfiguration implements ApplicationContextAware {
// private ApplicationContext applicationContext;

// @Override
// public void setApplicationContext(ApplicationContext applicationContext)
// throws BeansException {
// this.applicationContext = applicationContext;
// }

// @Bean
// public SpringTemplateEngine thymeleafLayoutDialiect() {
// SpringTemplateEngine engine = new SpringTemplateEngine();
// engine.setEnableSpringELCompiler(true);
// // engine.setTemplateResolver(templateResolver());
// engine.setDialect(new LayoutDialect());
// return engine;

// }

// private ITemplateResolver templateResolver() {
// SpringResourceTemplateResolver templateResolver = new
// SpringResourceTemplateResolver();
// templateResolver.setApplicationContext(applicationContext);
// templateResolver.setSuffix(".html");
// templateResolver.setTemplateMode(TemplateMode.HTML);
// templateResolver.setCharacterEncoding("UTF-8");
// templateResolver.setOrder(1);
// templateResolver.setCheckExistence(true);

// return templateResolver;
// }
// }
