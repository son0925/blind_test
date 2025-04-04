package com.son.blindtest.category.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.son.blindtest.test.model.TestEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "category")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<TestEntity> testEntityList;

}
