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
public class MainCategoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "mainCategoryEntity", cascade = CascadeType.REFRESH)
    private List<MiddleCategoryEntity> middleCategories = new ArrayList<>();

    @Column(length = 100, nullable = false)
    private String name;

    @Builder
    public MainCategoryEntity(Long id) {
        this.id = id;
    }

}
