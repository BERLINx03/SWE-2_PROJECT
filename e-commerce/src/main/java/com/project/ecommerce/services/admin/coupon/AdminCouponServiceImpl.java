package com.project.ecommerce.services.admin.coupon;

import com.project.ecommerce.entities.Coupon;
import com.project.ecommerce.exceptions.ValidationException;
import com.project.ecommerce.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCouponServiceImpl implements AdminCouponService {


    private final CouponRepository couponRepository;


    public Coupon createCoupon(Coupon coupon) {
        if(couponRepository.existsByCode(coupon.getCode())) {
            throw new ValidationException("Coupon code is already exists");
        }
        return couponRepository.save(coupon);
    }

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

}
