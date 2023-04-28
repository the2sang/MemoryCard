package com.memorycard.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MiddleCategoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private MainCategoryEntity mainCategoryEntity;

    @OneToMany(mappedBy = "middleCategoryEntity")
    private List<MemoryCardEntity> memoryCardEntityList = new ArrayList<>();

    @Column(nullable = false, length = 100)
    private String name;

    @Builder
    public MiddleCategoryEntity(Long id, MainCategoryEntity mainCategoryEntity, String name ) {
        this.id = id;
        this.mainCategoryEntity = mainCategoryEntity;
        this.name = name;
    }


}
