package com.victortavares.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Wallets")
@Table
public class WalletEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "transaction_pin_id")
    private TransactionPinEntity transactionPinEntity;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public WalletEntity(BigDecimal balance, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {
        this.balance = balance;
        this.userEntity = userEntity;
        this.transactionPinEntity = transactionPinEntity;
    }

    public WalletEntity(Long id, BigDecimal balance, UserEntity userEntity, TransactionPinEntity transactionPinEntity) {
        this.id = id;
        this.balance = balance;
        this.userEntity = userEntity;
        this.transactionPinEntity = transactionPinEntity;
    }
}
