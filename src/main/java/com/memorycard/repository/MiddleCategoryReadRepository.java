package com.memorycard.repository;

import com.memorycard.entity.MiddleCategoryEntity;
import lombok.RequiredArgsConstructor;
import nu.studer.sample.tables.MiddleCategory;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MiddleCategoryReadRepository {

    private final DSLContext dsl;

    private final MiddleCategory middleCategory = MiddleCategory.MIDDLE_CATEGORY;

    public Page<MiddleCategoryEntity> getMiddleCategories(Pageable pageable) {
        List<MiddleCategoryEntity> middleCategories = dsl.select()
                .from(middleCategory)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetchInto(MiddleCategoryEntity.class);
        return new PageImpl<>(middleCategories, pageable, dsl.fetchCount(dsl.selectFrom(middleCategory)));
    }

    public MiddleCategoryEntity findById(Long id) {
        return dsl.select()
                .from(middleCategory)
                .where(middleCategory.ID.eq(id))
                .fetchOneInto(MiddleCategoryEntity.class);
    }

    public List<MiddleCategoryEntity> getMiddleCategoriesByMainCategoryId(Long id) {
        List<MiddleCategoryEntity> middleCategoryEntities = dsl.selectFrom(middleCategory)
                .where(middleCategory.MAIN_CATEGORY_ID.eq(id))
                .orderBy(middleCategory.ID.asc())
                .fetchInto(MiddleCategoryEntity.class);
        return middleCategoryEntities;
    }
}
