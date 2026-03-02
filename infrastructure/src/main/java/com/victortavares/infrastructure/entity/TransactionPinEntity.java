package com.victortavares.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "transactions_pin")
public class TransactionPinEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pin", nullable = false)
    private String pin;

    @Column(name = "attempt", nullable = false)
    private int attempt;

    @Column(name = "blocked", nullable = false)
    private Boolean blocked;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public TransactionPinEntity(Long id,String pin, int attempt, Boolean blocked) {
        this.id = id;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
    }

    public TransactionPinEntity(String pin, int attempt, Boolean blocked) {
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
    }
}
