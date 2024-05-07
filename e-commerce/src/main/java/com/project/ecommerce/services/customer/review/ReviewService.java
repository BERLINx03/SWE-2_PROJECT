package com.project.ecommerce.services.customer.review;

import com.project.ecommerce.dto.OrderedProductsResponseDto;
import com.project.ecommerce.dto.ReviewDto;

import java.io.IOException;

public interface ReviewService {
    OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);

    ReviewDto giveReview(ReviewDto reviewDto) throws IOException;
}
