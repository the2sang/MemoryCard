package com.memorycard.repository;

import com.memorycard.entity.MainCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainCategoryWriteRepository extends JpaRepository<MainCategoryEntity, Long> {
}
