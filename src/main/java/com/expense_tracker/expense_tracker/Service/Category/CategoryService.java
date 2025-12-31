package com.expense_tracker.expense_tracker.Service.Category;

import com.expense_tracker.expense_tracker.Entity.Category;
import org.springframework.stereotype.Service;

public interface CategoryService {
    Category createCategory(Category category);
}
