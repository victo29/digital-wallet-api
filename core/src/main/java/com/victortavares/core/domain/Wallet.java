package com.victortavares.core.domain;

import com.victortavares.core.domain.enums.UserTypeEnum;
import com.victortavares.core.exception.TransferException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Wallet {
    private Long id;
    private TransactionPin transactionPin;
    private BigDecimal balance;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public Wallet(Long id, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updateAt, TransactionPin transactionPin) {
        this.id = id;
        this.transactionPin = transactionPin;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Wallet(BigDecimal balance, User user,  TransactionPin transactionPin) {
        this.balance = balance;
        this.user = user;
        this.transactionPin = transactionPin;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    public void receiveTransfer(BigDecimal value){
        this.balance.add(value);
    }

    public void transfer(BigDecimal value) throws TransferException  {
        if(this.user.getType() == UserTypeEnum.SHOPKEEPER){
            throw new TransferException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());
        }

        if(this.balance.compareTo(value) < 0){
            throw new TransferException(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }

        this.balance.subtract(value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(getId(), wallet.getId()) && Objects.equals(getTransactionPin(), wallet.getTransactionPin()) && Objects.equals(getBalance(), wallet.getBalance()) && Objects.equals(getUser(), wallet.getUser()) && Objects.equals(getCreatedAt(), wallet.getCreatedAt()) && Objects.equals(getUpdateAt(), wallet.getUpdateAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTransactionPin(), getBalance(), getUser(), getCreatedAt(), getUpdateAt());
    }
}
