package com.expense_tracker.expense_tracker.Repository;

import com.expense_tracker.expense_tracker.Entity.Category;
import com.expense_tracker.expense_tracker.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryType name);
    Category findByName(String categoryName);
}
