package com.memorycard.service;

import com.memorycard.dto.MainCategoryDto;
import com.memorycard.dto.MiddleCategoryDto;
import com.memorycard.entity.MainCategoryEntity;
import com.memorycard.entity.MiddleCategoryEntity;
import com.memorycard.repository.MainCategoryReadRepository;
import com.memorycard.repository.MainCategoryWriteRepository;
import com.memorycard.repository.MiddleCategoryReadRepository;
import com.memorycard.repository.MiddleCategoryWriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final MainCategoryReadRepository mainCategoryReadRepository;
    private final MainCategoryWriteRepository mainCategoryWriteRepository;
    private final MiddleCategoryReadRepository middleCategoryReadRepository;
    private final MiddleCategoryWriteRepository middleCategoryWriteRepository;

    public MainCategoryEntity addMainCategory(MainCategoryDto mainCategoryDto) {
        if (mainCategoryWriteRepository.existsById(mainCategoryDto.getId())) {
            throw new RuntimeException("This category states is duplicated");
        }
        return mainCategoryWriteRepository.save(mainCategoryDto.toEntity());
    }

    public MainCategoryEntity getOneMainCategory(Long id) {
        final MainCategoryEntity targetCategory = mainCategoryReadRepository.findById(id);
        Assert.notNull(targetCategory, "category not found");
        return targetCategory;
    }

    public MiddleCategoryEntity addMiddleCategory(MiddleCategoryDto middleCategoryDto) {
        if (middleCategoryWriteRepository.existsById(middleCategoryDto.getId())) {
            throw new RuntimeException("This category states is duplicated");
        }

        return middleCategoryWriteRepository.save(middleCategoryDto.toEntity());
    }

    public MiddleCategoryEntity getOneMiddleCategory(Long id) {
        final MiddleCategoryEntity targetCategory = middleCategoryReadRepository.findById(id);
        Assert.notNull(targetCategory, "category not found");
        return targetCategory;
    }

    public MainCategoryEntity updateMainCategory(MainCategoryDto mainCategoryDto) {
       final MainCategoryEntity targetCategory = getOneMainCategory(mainCategoryDto.getId());
       Assert.notNull(targetCategory, "category not found");
       return mainCategoryWriteRepository.save(mainCategoryDto.toEntity());
    }

    public MiddleCategoryEntity updateMiddleCategory(MiddleCategoryDto middleCategoryDto) {
        return middleCategoryWriteRepository.save(middleCategoryDto.toEntity());
    }

    public void deleteMainCategory(MainCategoryDto mainCategoryDto) {
        mainCategoryWriteRepository.delete(mainCategoryDto.toEntity());
    }

    public void deleteMiddleCategory(MiddleCategoryDto middleCategoryDto) {
        middleCategoryWriteRepository.delete(middleCategoryDto.toEntity());
    }

    public List<MiddleCategoryEntity> getMiddleCategoriesByMainCategoryId(Long id) {
        return middleCategoryReadRepository.getMiddleCategoriesByMainCategoryId(id);
    }



}
