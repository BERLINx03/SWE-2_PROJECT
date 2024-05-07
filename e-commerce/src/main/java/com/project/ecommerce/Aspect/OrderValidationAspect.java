package com.project.ecommerce.Aspect;




import com.project.ecommerce.enums.OrderStatus;
import com.project.ecommerce.exceptions.InvalidOrderStatusException;
import com.project.ecommerce.services.admin.adminOrder.AdminOrderService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.project.ecommerce.exceptions.InvalidOrderStatusException;
import java.util.Arrays;

@Aspect
@Component
public class OrderValidationAspect {

    private final AdminOrderService adminOrderService;

    @Autowired
    public OrderValidationAspect(AdminOrderService adminOrderService) {
        this.adminOrderService = adminOrderService;
    }

    @Before("execution(* com.project.ecommerce.services.admin.adminOrder.AdminOrderService.changeOrderStatus(..)) " +
            "&& args(orderId, status)")
    public void validateOrderStatus(Long orderId, String status) {
        if (!isValidOrderStatus(status)) {
            throw new InvalidOrderStatusException("Invalid order status: " + status);
        }
    }

    private boolean isValidOrderStatus(String status) {
        return Arrays.stream(OrderStatus.values())
                .anyMatch(orderStatus -> orderStatus.name().equalsIgnoreCase(status));
    }
}
