package com.liroustore.paymentliroustore.models.shared;

public record Address(
        String region,
        String city,
        String postalCode,
        String street,
        String number,
        String locality,
        String country,
        String regionCode,
        String complement
) {}