package com.son.blindtest.category.controller;

import com.son.blindtest.category.model.CategoryEntity;
import com.son.blindtest.category.service.CategoryService;
import com.son.blindtest.test.model.TestRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public String getCategoryEntity(Model model) {
        List<CategoryEntity> list = categoryService.getCategoryList();
        model.addAttribute("categoryList", list);

        return "main";
    }

    @GetMapping("/quiz/{categoryId}")
    public String getQuiz(
            @PathVariable Long categoryId,
            Model model
    ) {
        CategoryEntity entity = categoryService.findByIdWithThrow(categoryId);
        model.addAttribute("test", entity);

        return "test";
    }

    @PostMapping("/register/{name}")
    public void register(
            @PathVariable String name
    ) {
        categoryService.register(name);
    }

    @ResponseBody
    @PostMapping("/create")
    public void createCategory(
            @RequestBody TestRequest request
    ) {
        categoryService.createTest(request.getCategoryId(), request);
    }

}
