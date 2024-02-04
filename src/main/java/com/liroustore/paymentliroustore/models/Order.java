package com.liroustore.paymentliroustore.models;

import com.liroustore.paymentliroustore.models.shared.Address;
import com.liroustore.paymentliroustore.types.PhoneType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

public record Order(
        String reference_id,
        @Valid Customer customer,
        List<Item> items,
        Shipping shipping,
        List<QRCode> qr_codes,
        List<String> notification_urls
){}

record Customer(String name, String email, @NotBlank String tax_id, List<Phone> phones) {}

record Phone(int country, int area, int number, PhoneType type) {}

record Item(String name, int quantity, double unitAmount) {}

record QRCode(Amount amount, LocalDateTime expiration_date) {}

record Shipping(Address address) {}