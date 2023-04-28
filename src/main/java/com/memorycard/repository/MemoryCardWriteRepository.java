package com.memorycard.repository;

import com.memorycard.entity.MemoryCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoryCardWriteRepository extends JpaRepository<MemoryCardEntity, Long> {
}
