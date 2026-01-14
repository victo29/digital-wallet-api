package com.victortavares.infrastructure.repository;

import com.victortavares.infrastructure.entity.TransactionPinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPinEntityRepository extends JpaRepository<TransactionPinEntity, Long> {
}
