package com.expense_tracker.expense_tracker.Controller;

import com.expense_tracker.expense_tracker.Entity.Category;
import com.expense_tracker.expense_tracker.Service.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/api/v1/createCategory")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }
}
