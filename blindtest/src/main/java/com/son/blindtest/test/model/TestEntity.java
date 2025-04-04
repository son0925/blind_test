package com.son.blindtest.test.model;

import com.son.blindtest.category.model.CategoryEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "test")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "category")
@Builder
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testId;

    private String question;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

}
