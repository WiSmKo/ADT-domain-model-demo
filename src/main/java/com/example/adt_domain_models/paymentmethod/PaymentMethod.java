package com.example.adt_domain_models.paymentmethod;

public sealed interface PaymentMethod permits DebitCard, Paypal {

}
