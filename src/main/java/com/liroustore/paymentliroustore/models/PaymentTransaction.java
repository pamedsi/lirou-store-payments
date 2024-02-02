package com.liroustore.paymentliroustore.models;

import com.liroustore.paymentliroustore.models.shared.Address;

import java.util.List;
import java.util.Map;

public record PaymentTransaction(
        String id,
        String status,
        String createdAt,
        String description,
        Amount amount,
        PaymentResponse paymentResponse,
        PaymentMethod paymentMethod,
        List<Link> links,
        List<String> notificationUrls,
        Map<String, String> metadata
) {}

record Amount(
        int value,
        String currency,
        Summary summary
) {}

record Summary(
        int total,
        int paid,
        int refunded
) {}

record PaymentResponse(
        String code,
        String message
) {}

record PaymentMethod(
        String type,
        Boleto boleto
) {}

record Boleto(
        String id,
        String barcode,
        String formattedBarcode,
        String dueDate,
        InstructionLines instructionLines,
        Holder holder
) {}

record InstructionLines(
        String line1,
        String line2
) {}

record Holder(
        String name,
        String taxId,
        String email,
        Address address
) {}


record Link(
        String rel,
        String href,
        String media,
        String type
) {}
