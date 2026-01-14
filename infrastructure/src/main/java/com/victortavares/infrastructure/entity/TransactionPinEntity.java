package com.victortavares.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "TransactionsPin")
public class TransactionPinEntity {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Pin", nullable = false)
    private String pin;

    @Column(name = "Attempt", nullable = false)
    private int attempt;

    @Column(name = "Blocked", nullable = false)
    private Boolean blocked;

    @Column(name = "CreateAt", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "UpdateAt")
    private LocalDateTime updateAt;

    public TransactionPinEntity(String pin, int attempt, Boolean blocked, LocalDateTime createAt, LocalDateTime updateAt) {
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
