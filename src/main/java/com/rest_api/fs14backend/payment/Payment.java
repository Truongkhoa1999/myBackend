package com.rest_api.fs14backend.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity(name = "payment")
@Table(name = "payment")
@Data
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID paymentId;
    @Column(nullable = false)
    private boolean isPaid;
   @Enumerated(EnumType.STRING)
    private PaymentMethod method;

}
