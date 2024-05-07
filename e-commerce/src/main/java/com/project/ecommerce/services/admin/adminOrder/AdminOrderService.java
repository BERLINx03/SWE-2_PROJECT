package com.project.ecommerce.services.admin.adminOrder;

import com.project.ecommerce.dto.AnalyticsResponse;
import com.project.ecommerce.dto.OrderDto;

import java.util.List;

public interface AdminOrderService {

    List<OrderDto> getAllPlacedOrders();

    OrderDto changeOrderStatus(Long orderId, String status);

    AnalyticsResponse calculateAnalytics();
}
