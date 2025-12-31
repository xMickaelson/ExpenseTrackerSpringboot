package com.expense_tracker.expense_tracker.Model;

import com.expense_tracker.expense_tracker.enums.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {
    private Long categoryId;
    private CategoryType name;
}
