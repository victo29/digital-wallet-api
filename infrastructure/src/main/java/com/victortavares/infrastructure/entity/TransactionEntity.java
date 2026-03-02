package com.victortavares.infrastructure.entity;

import com.victortavares.core.domain.enums.TransactionStatusEnum;
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
@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_wallet_id")
    private WalletEntity fromWalletEntity;

    @ManyToOne
    @JoinColumn(name = "to_wallet_id")
    private WalletEntity toWalletEntity;

    @Column(name = "transaction_value", nullable = false)
    private BigDecimal transactionValue;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public TransactionEntity(WalletEntity fromWalletEntity, WalletEntity toWalletEntity, BigDecimal transactionValue, TransactionStatusEnum status) {
        this.fromWalletEntity = fromWalletEntity;
        this.toWalletEntity = toWalletEntity;
        this.transactionValue = transactionValue;
        this.status = status;
    }

    public TransactionEntity(long id, WalletEntity fromWalletEntity, WalletEntity toWalletEntity, BigDecimal transactionValue, TransactionStatusEnum status) {
        this.id = id;
        this.fromWalletEntity = fromWalletEntity;
        this.toWalletEntity = toWalletEntity;
        this.transactionValue = transactionValue;
        this.status = status;
    }
}
