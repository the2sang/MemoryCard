package com.memorycard.dto;


import com.memorycard.entity.MainCategoryEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MainCategoryDto {

    private final Long id;
    private final String name;

    @Builder
    public MainCategoryDto(Long id, String name) {
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
