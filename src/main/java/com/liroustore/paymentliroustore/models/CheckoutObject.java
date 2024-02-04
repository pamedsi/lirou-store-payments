package com.liroustore.paymentliroustore.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.liroustore.paymentliroustore.types.*;

import jakarta.validation.constraints.*;

import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;
import java.util.List;

public record CheckoutObject (
        String id,
        String reference_id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
        LocalDateTime expiration_date,
        Customer customer,
        Boolean customer_modifiable,
        List<Item> items,
        int additional_amount,
        int discount_amount,
        Shipping shipping,
        List<PaymentMethod> payment_methods,
        List<PaymentMethodConfig> payment_method_configs,
        String soft_descriptor,
        String redirect_url,
        List<String> notification_urls,
        List<String> payment_notification_urls

) {}

record Customer(
        @NotNull
        @Size(min = 1, max = 120)
        String name,

        @NotNull
        @Size(min = 10, max = 60)
        @Email
        String email,

        @NotNull
        @Size(min = 11, max = 14)
        @NumberFormat
        String tax_id,

        @NotNull
        Phone phone
) {}

record Phone(
        @NotEmpty
        @Positive
        int country,
        @NotEmpty
        @Positive
        int area,
        @NotEmpty
        @Positive
        int number,
        @NotNull
        TipoDeTelefone type
) {}

record Item(
        @NotNull
        @Size(max = 100)
        String reference_id,

        @NotNull
        @Size(max = 100)
        String name,

        @NotNull
        @Size(max = 255)
        String description,

        @NotNull
        int quantity,

        @NotNull
        int unit_amount
) {}

record Shipping(
        @NotNull
        TipoDeFrete type,

        TipoDeServico service_type,

        Boolean address_modifiable,

        @NotNull
        @Min(1)
        int amount,

        Address address,
        Box box

) {}

record Address(
        @NotNull
        @Size(max = 160)
        String street,

        @NotNull
        @Size(max = 20)
        String number,

        String complement,

        @NotNull
        @Size(max = 60)
        String locality,

        @NotNull
        @Size(max = 90)
        String city,

        @NotNull
        @Size(max = 3)
        String region_code,

        @NotNull
        @Size(max = 3)
        String country,

        @NotNull
        @Size(max = 8)
        String postal_code
) {}

record Box(
        @NotNull
        String weight,

        @NotNull
        Dimensions dimensions) {}

record Dimensions(
        @NotNull
        @Min(15)
        int length,

        @NotNull
        @Min(10)
        int width,

        @NotNull
        @Min(1)
        int height
) {}

record PaymentMethod (
        TipoDePagamento type,
        List<String> brands
){}

record PaymentMethodConfig (
        TipoDeCartao type,
        List<String> brands,
        ConfigOptions config_options
){}

record ConfigOptions (
        String option,
        String value
) {}