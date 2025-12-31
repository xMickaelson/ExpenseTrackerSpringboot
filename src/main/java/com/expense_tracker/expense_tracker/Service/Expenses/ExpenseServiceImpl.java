package com.expense_tracker.expense_tracker.Service.Expenses;

import com.expense_tracker.expense_tracker.Entity.Category;
import com.expense_tracker.expense_tracker.Entity.Expense;
import com.expense_tracker.expense_tracker.Repository.CategoryRepository;
import com.expense_tracker.expense_tracker.Repository.ExpenseRepository;
import com.expense_tracker.expense_tracker.enums.CategoryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Expense addExpense(Expense payload) {
        CategoryType categoryType = payload.getCategory().getName();

        Category category = categoryRepository.findByName(categoryType)
                .orElseThrow(() -> new RuntimeException("Invalid category"));

        Expense expense = Expense.builder()
                .amount(payload.getAmount())
                .category(category)
                .title(payload.getTitle())
                .date(payload.getDate())
                .note(payload.getNote())
                .build();
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        List<Expense> allExpense = expenseRepository.findAll();
        return allExpense;
    }

    @Override
    public List<Expense> getExpensesByCategory(String categoryName) {
        CategoryType categoryType = CategoryType.valueOf(categoryName.toUpperCase());
        Category category = categoryRepository.findByName(categoryType)
                .orElseThrow(() -> new RuntimeException("Invalid category"));

        return expenseRepository.findByCategoryId(category.getCategoryId());
    }

    @Override
    public List<Object[]> getMonthlyExpenseSummary(int year, int month) {
        return expenseRepository.getMonthlySummary(year, month);
    }

    @Override
    public Page<Expense> getAllExpensesPage(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return expenseRepository.findAll(pageable);
    }
}
