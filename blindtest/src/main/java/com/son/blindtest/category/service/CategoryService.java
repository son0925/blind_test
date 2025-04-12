package com.son.blindtest.category.service;

import com.son.blindtest.category.model.CategoryEntity;
import com.son.blindtest.category.model.CategoryRepository;
import com.son.blindtest.test.model.TestEntity;
import com.son.blindtest.test.model.TestRepository;
import com.son.blindtest.test.model.TestRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final TestRepository testRepository;

    public List<CategoryEntity> getCategoryList() {
        return categoryRepository.findAll();
    }


    public CategoryEntity findByIdWithThrow(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException(""));
    }


    public void createTest(Long categoryId, TestRequest request) {
        // TODO Valid 작업하기
        if (request.getQuestion().isEmpty() || request.getAnswer().isEmpty()) {
            throw new RuntimeException("단어가 존재하지 않음");
        }

        TestEntity entity = TestEntity.builder()
                .imageUrl(request.getImageUrl())
                .question(request.getQuestion())
                .answer(request.getAnswer())
                .category(findByIdWithThrow(categoryId))
                .build();

        testRepository.save(entity);
    }

    public void register(String name) {
        CategoryEntity entity = CategoryEntity.builder()
                .name(name)
                .build()
                ;

        categoryRepository.save(entity);
    }
}
