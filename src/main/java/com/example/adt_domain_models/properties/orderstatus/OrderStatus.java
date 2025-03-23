package com.example.adt_domain_models.properties.orderstatus;

public sealed interface OrderStatus permits Pending, Shipped, Delivered, Canceled {
}
