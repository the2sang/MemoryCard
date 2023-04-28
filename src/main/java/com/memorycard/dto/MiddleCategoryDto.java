package com.memorycard.dto;

import com.memorycard.entity.MainCategoryEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MiddleCategoryDto {

    private final Long id;
    private final String name;

    @Builder
    public MiddleCategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MainCategoryEntity toEntity() {
        return MainCategoryEntity.builder()
                .id(id)
                .name(name)
                .build();
    }


}
