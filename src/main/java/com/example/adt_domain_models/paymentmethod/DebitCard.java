package com.example.adt_domain_models.paymentmethod;

public record DebitCard(String cardNumber) implements PaymentMethod {

}
