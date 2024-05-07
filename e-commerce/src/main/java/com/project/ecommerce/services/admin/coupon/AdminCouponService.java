package com.project.ecommerce.services.admin.coupon;

import com.project.ecommerce.entities.Coupon;

import java.util.List;

public interface AdminCouponService {
    Coupon createCoupon(Coupon coupon);
    List<Coupon> getAllCoupons();
}
