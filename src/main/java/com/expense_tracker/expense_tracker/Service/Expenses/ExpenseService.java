package com.expense_tracker.expense_tracker.Service.Expenses;

import com.expense_tracker.expense_tracker.Entity.Expense;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ExpenseService {
    Expense addExpense(Expense payload);
    List<Expense> getAllExpenses();
    List<Expense> getExpensesByCategory(String categoryName);
    List<Object []> getMonthlyExpenseSummary(int year, int month);
    Page<Expense> getAllExpensesPage(int page, int size, String sortBy, String direction);
}
