package com.victortavares.infrastructure.repository;

import com.victortavares.infrastructure.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, Long> {
}
