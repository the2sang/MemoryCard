package com.memorycard.repository;

import com.memorycard.entity.MemoryCardEntity;
import lombok.RequiredArgsConstructor;
import nu.studer.sample.tables.MemoryCard;
import org.jooq.DSLContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemoryCardReadRepository {

    private final DSLContext dsl;

    private final MemoryCard memoryCard = MemoryCard.MEMORY_CARD;


    public Page<MemoryCardEntity> getMemoryCards(Pageable pageable) {
        List<MemoryCardEntity> memoryCards = dsl.select()
                .from(memoryCard)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetchInto(MemoryCardEntity.class);
        return new PageImpl<>(memoryCards, pageable, dsl.fetchCount(dsl.selectFrom(memoryCard)));
    }

    public MemoryCardEntity findById(Long id) {
        return dsl.select()
                .from(memoryCard)
                .where(memoryCard.ID.eq(id))
                .fetchOneInto(MemoryCardEntity.class);
    }
}
