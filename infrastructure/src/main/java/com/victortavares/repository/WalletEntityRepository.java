package com.victortavares.repository;

import com.victortavares.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
}
