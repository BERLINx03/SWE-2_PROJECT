package com.project.ecommerce.dto;

import com.project.ecommerce.entities.CartItems;
import com.project.ecommerce.entities.User;
import com.project.ecommerce.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDto {
    private Long id;

    private String orderDescription;

    private Date date;

    private Long amount;//after coupon

    private String address;

    private String payment;

    private OrderStatus orderStatus;

    private Long totalAmount;

    private Long discount;

    private UUID trackingId;//random id

    private String userName;

    private List<CartItemsDto> cartItems;

    private String couponName;
}
