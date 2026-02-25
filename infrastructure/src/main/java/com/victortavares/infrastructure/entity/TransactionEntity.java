package com.victortavares.infrastructure.entity;

import com.victortavares.core.domain.enums.TransactionStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Transactions")
public class TransactionEntity {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FromWallet")
    private WalletEntity fromWalletEntity;

    @ManyToOne
    @JoinColumn(name = "ToWallet")
    private WalletEntity toWalletEntity;

    @Column(name = "TransactionValue", nullable = false)
    private BigDecimal transactionValue;

    @Column(name = "Status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatusEnum status;

    @Column(name = "CreateAt", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "UpdateAt")
    private LocalDateTime updateAt;

    public TransactionEntity(WalletEntity fromWalletEntity, WalletEntity toWalletEntity, BigDecimal transactionValue, TransactionStatusEnum status, LocalDateTime createAt, LocalDateTime updateAt) {
        this.fromWalletEntity = fromWalletEntity;
        this.toWalletEntity = toWalletEntity;
        this.transactionValue = transactionValue;
        this.status = status;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
