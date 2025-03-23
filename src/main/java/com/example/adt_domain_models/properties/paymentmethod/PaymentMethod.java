package com.example.adt_domain_models.properties.paymentmethod;

public sealed interface PaymentMethod permits DebitCard, Paypal {

}
