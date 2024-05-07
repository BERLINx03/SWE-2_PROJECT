package com.project.ecommerce.config;



import com.project.ecommerce.Aspect.ValidationAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfig {

    @Bean
    public ValidationAspect validationAspect() {
        return new ValidationAspect();
    }
    @Bean
    public ValidationAspect faqValidationAspect() {
        return new ValidationAspect();
    }
}
