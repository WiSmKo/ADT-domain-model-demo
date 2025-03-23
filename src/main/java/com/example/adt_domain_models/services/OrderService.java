package com.example.adt_domain_models.services;

import com.example.adt_domain_models.entities.Order;
import com.example.adt_domain_models.properties.orderstatus.Canceled;
import com.example.adt_domain_models.properties.orderstatus.Delivered;
import com.example.adt_domain_models.properties.orderstatus.Pending;
import com.example.adt_domain_models.properties.orderstatus.Shipped;

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
