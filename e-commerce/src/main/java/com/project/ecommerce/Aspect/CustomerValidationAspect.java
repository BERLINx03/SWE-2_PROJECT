package com.project.ecommerce.Aspect;


import com.project.ecommerce.exceptions.ValidationException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import javax.validation.ConstraintViolationException;

@Aspect
@Component
public class CustomerValidationAspect {

    @AfterThrowing(pointcut = "execution(* com.project.ecommerce.controllers.customer.*.*(..))", throwing = "ex")
    public ResponseEntity<?> handleValidationExceptions(Exception ex) {
        if (ex instanceof ConstraintViolationException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } else if (ex instanceof ValidationException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error occurred");
        }
    }
}
