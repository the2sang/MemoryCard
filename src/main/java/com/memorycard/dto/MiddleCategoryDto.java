package com.memorycard.dto;

import com.memorycard.entity.MainCategoryEntity;
import com.memorycard.entity.MiddleCategoryEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MiddleCategoryDto {

    private final Long id;
    private final String name;
    private final MainCategoryDto mainCategoryDto;


    @Builder
    public MiddleCategoryDto(Long id, String name, MainCategoryDto mainCategoryDto) {
        this.id = id;
        this.name = name;
        this.mainCategoryDto = mainCategoryDto;
    }

    public MiddleCategoryEntity toEntity() {
        return MiddleCategoryEntity.builder()
                .id(id)
                .mainCategoryEntity(new MainCategoryEntity(mainCategoryDto.getId()))
                .name(name)
                .build();
    }


}
