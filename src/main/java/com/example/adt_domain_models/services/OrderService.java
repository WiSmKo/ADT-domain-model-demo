package com.example.adt_domain_models.services;

import com.example.adt_domain_models.order.Order;
import com.example.adt_domain_models.orderstatus.Canceled;
import com.example.adt_domain_models.orderstatus.Delivered;
import com.example.adt_domain_models.orderstatus.Pending;
import com.example.adt_domain_models.orderstatus.Shipped;

public class OrderService {

    public String processOrderStatus(Order order) {
        return switch (order.status()) {
            case Pending p -> "Order is pending.";
            case Shipped s -> "Order shipped on: " + s.shippedDate();
            case Delivered d -> "Order delivered on: " + d.deliveredDate();
            case Canceled c -> "Order canceled because: " + c.reason();
        };
    }
}
