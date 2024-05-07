package com.project.ecommerce.Aspect;


import com.project.ecommerce.dto.ProductDto;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductValidationAspect {

    @Before("execution(* com.project.ecommerce.services.admin.adminproduct.AdminProductService.addProduct(..)) && args(productDto)")
    public void validateAddProduct(ProductDto productDto) {
        // Add validation logic for adding a product here
        // Example: Ensure required fields are not null or empty
        if (productDto.getName() == null || productDto.getName().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        // Add more validation logic as needed
    }

    // Add similar validation methods for other service methods as needed

    @AfterReturning(
            pointcut = "execution(* com.project.ecommerce.services.admin.adminproduct.AdminProductService.*(..))",
            returning = "result")
    public void logAfterReturning(Object result) {
        // Optionally, you can log successful method executions here
    }
}
