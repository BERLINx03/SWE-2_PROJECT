package com.project.ecommerce.Aspect;


import com.project.ecommerce.dto.CategoryDto;
import com.project.ecommerce.dto.FAQDto;
import com.project.ecommerce.dto.SignupRequest;
import com.project.ecommerce.entities.Coupon;
import com.project.ecommerce.exceptions.ValidationException;
import com.project.ecommerce.services.auth.AuthService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Aspect
@Component
public class ValidationAspect {

    @Before("execution(* com.project.ecommerce.controllers.admin.*.*(..))")
    public ResponseEntity<?> validateInput(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;
                if (bindingResult.hasErrors()) {
                    List<ObjectError> errors = bindingResult.getAllErrors();
                    StringBuilder errorMessage = new StringBuilder();
                    for (ObjectError error : errors) {
                        errorMessage.append(error.getDefaultMessage()).append("\n");
                    }
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.toString());
                }
            }
        }
        return null;
    }
    @Before("execution(* com.project.ecommerce.services.admin.category.CategoryService.createCategory(..)) && args(categoryDto)")
    public void validateCategoryCreation(CategoryDto categoryDto) {
        if (categoryDto.getName() == null || categoryDto.getName().isEmpty()) {
            throw new ValidationException("Category name cannot be empty");
        }
        // Add more validation logic as needed
    }

    @Before("execution(* com.project.ecommerce.services.admin.coupon.AdminCouponService.createCoupon(..)) && args(coupon)")
    public void validateCouponCreation(Coupon coupon) {
        if (coupon.getCode() == null || coupon.getCode().isEmpty()) {
            throw new ValidationException("Coupon code cannot be empty");
        }
        // Add more validation logic as needed
    }

    @Before("execution(* com.project.ecommerce.services.admin.faq.FAQService.postFAQ(..)) && args(productId, faqDto)")
    public void validateFAQ(Long productId, FAQDto faqDto) {
        // Your validation logic here
        // For example:
        if (faqDto.getQuestion() == null || faqDto.getQuestion().isEmpty()) {
            throw new IllegalArgumentException("FAQ question cannot be empty");
        }
        // Add more validation as needed
    }
    @Autowired(required = false)
    private AuthService authService;

    @Before("execution(* com.project.ecommerce.services.auth.AuthService.createUser(..)) && args(signupRequest)")
    public void validateSignupRequest(SignupRequest signupRequest) {
        if (authService != null && authService.hasUserWithEmail(signupRequest.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        // You can add more validation logic as needed
    }
}
