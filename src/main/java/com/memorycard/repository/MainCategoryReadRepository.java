package com.memorycard.repository;


import com.memorycard.entity.MainCategoryEntity;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import nu.studer.sample.tables.MainCategory;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class MainCategoryReadRepository {

    private final DSLContext dsl;
    private final MainCategory mainCategory = MainCategory.MAIN_CATEGORY;

    public Page<MainCategoryEntity> getMainCategories(Pageable pageable) {
        List<MainCategoryEntity> categories = dsl.select()
                .from(mainCategory)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetchInto(MainCategoryEntity.class);
        return new PageImpl<>(categories, pageable, dsl.fetchCount(dsl.selectFrom(mainCategory)));
    }

    public MainCategoryEntity findById(Long id) {
        return dsl.select()
                .from(mainCategory)
                .where(mainCategory.ID.eq(id))
                .fetchOneInto(MainCategoryEntity.class);
    }


}
