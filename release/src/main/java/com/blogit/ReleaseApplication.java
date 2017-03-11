package com.blogit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "com.blogit.controllers",
        "com.blogit.Entity"
})
public class ReleaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReleaseApplication.class, args);
    }

    @Bean
    public ViewResolver thymeLeafResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

        templateResolver.setTemplateMode("XHTML");
        templateResolver.setPrefix("resources/templates");
        templateResolver.setSuffix(".html");

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }
}
