package com.example.adt_domain_models.orderstatus;

import java.time.LocalDateTime;

public record Shipped(LocalDateTime shippedDate) implements OrderStatus {

}
