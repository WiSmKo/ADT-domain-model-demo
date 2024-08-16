package com.example.adt_domain_models.order;

import java.time.LocalDateTime;
import java.util.List;

import com.example.adt_domain_models.customer.Customer;
import com.example.adt_domain_models.orderstatus.Canceled;
import com.example.adt_domain_models.orderstatus.Delivered;
import com.example.adt_domain_models.orderstatus.OrderStatus;
import com.example.adt_domain_models.orderstatus.Pending;
import com.example.adt_domain_models.orderstatus.Shipped;
import com.example.adt_domain_models.paymentmethod.PaymentMethod;

public record Order(String orderId,Customer customer, List<String> items, PaymentMethod paymentMethod, OrderStatus status) {

    public Order {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Items cannot be null or empty");
        }
    }

    public Order updateStatus(OrderStatus newStatus) {
        return new Order(orderId, customer, items, paymentMethod, newStatus);
    }

    public Order ship() {
        if (this.status instanceof Pending) {
            return this.updateStatus(new Shipped(LocalDateTime.now()));
        } else {
            throw new IllegalStateException("Order cannot be shipped. Current status: " + this.status);
        }
    }

    public Order deliver() {
        if (this.status instanceof Shipped) {
            return this.updateStatus(new Delivered(LocalDateTime.now()));
        } else {
            throw new IllegalStateException("Order cannot be delivered. Current status: " + this.status);
        }
    }

    public Order cancel(String reason) {
        if (!(this.status instanceof Delivered)) {
            return this.updateStatus(new Canceled(reason));
        } else {
            throw new IllegalStateException("Delivered order cannot be canceled.");
        }
    }

    public String orderSummary() {
        return "Order for " + customer.name() +
                " with " + items.size() + " items " +
                "is currently " + status;
    }
}
