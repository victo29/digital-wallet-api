package com.victortavares.core.domain;

import com.victortavares.core.exception.TransactionPinException;
import com.victortavares.core.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionPin {
    private Long id;
    private String pin;
    private  Integer attempt;
    private Boolean blocked;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    public TransactionPin(Long id, String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public TransactionPin(String pin) throws TransactionPinException {
        setPin(pin);
        this.attempt = 3;
        this.blocked = false;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinException {
        this.pin = pin;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt() {
        if (this.attempt == 1){
            this.blocked = true;
            this.attempt = 0;
        }else{
        this.attempt = this.attempt - 1;
        }
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void restaureAttempt(){
        this.attempt = 3;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TransactionPin that = (TransactionPin) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getPin(), that.getPin()) && Objects.equals(getAttempt(), that.getAttempt()) && Objects.equals(getBlocked(), that.getBlocked()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdateAt(), that.getUpdateAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPin(), getAttempt(), getBlocked(), getCreatedAt(), getUpdateAt());
    }
}
