package com.expense_tracker.expense_tracker.Service.Category;

import com.expense_tracker.expense_tracker.Entity.Category;
import com.expense_tracker.expense_tracker.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
}
