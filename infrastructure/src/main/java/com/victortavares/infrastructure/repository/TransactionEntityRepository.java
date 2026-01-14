package com.victortavares.infrastructure.repository;

import com.victortavares.infrastructure.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity, Long> {
}
