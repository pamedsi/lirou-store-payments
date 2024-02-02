package com.liroustore.paymentliroustore.models;


import com.liroustore.paymentliroustore.models.shared.Address;

import java.time.LocalDateTime;
import java.util.List;

public record Order(
        String referenceId,
        Customer customer, List<Item> items,
        List<QRCode> qrCodes,
        Shipping shipping,
        List<String> notificationUrls
){}

record Customer(String name, String email, String taxId, List<Phone> phones) {}

record Phone(String country, String area, String number, String type) {}

record Item(String name, int quantity, double unitAmount) {}

record QRCode(Amount amount, LocalDateTime expirationDate) {}

record Shipping(Address address) {}