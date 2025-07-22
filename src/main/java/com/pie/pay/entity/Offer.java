package com.pie.pay.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bank_name")          // 👈 explicitly map to DB column
    private String bankName;

    @Column(name = "title")              // 👈 optional but clear
    private String title;

    @Column(name = "discount_amount")    // 👈 explicitly map to DB column
    private Double discountAmount;

    @Column(name = "payment_instrument") // 👈 explicitly map to DB column
    private String paymentInstrument;

    @Column(name = "created_at")         // 👈 explicitly map to DB column
    private LocalDateTime createdAt;

    // getters & setters
}
