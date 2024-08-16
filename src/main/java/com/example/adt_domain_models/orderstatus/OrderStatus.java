package com.example.adt_domain_models.orderstatus;

public sealed interface OrderStatus permits Pending, Shipped, Delivered, Canceled {

}
