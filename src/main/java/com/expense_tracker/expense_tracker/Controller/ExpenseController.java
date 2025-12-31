package com.expense_tracker.expense_tracker.Controller;

import com.expense_tracker.expense_tracker.Entity.Expense;
import com.expense_tracker.expense_tracker.Service.Expenses.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/api/v1/addExpense")
    public Expense addExpense(@RequestBody Expense payload) {
        return expenseService.addExpense(payload);
    }

    @GetMapping("/api/v1/getAllExpense")
    public List<Expense> getAllExpenses(){
        List<Expense> allExpensesList = expenseService.getAllExpenses();
        return allExpensesList;
    }

    @GetMapping("/api/v1/getExpense")
    public List<Expense> getExpensesByCategory(@RequestParam String categoryName){
        return expenseService.getExpensesByCategory(categoryName);
    }

    @GetMapping("/api/v1/summary")
    public List<Object []> getMonthlySalary(@RequestParam int year, @RequestParam int month){
        return expenseService.getMonthlyExpenseSummary(year, month);
    }

    @GetMapping("/api/v1/expenses")
    public Page<Expense> getAllExpensesPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "date") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ){
        return expenseService.getAllExpensesPage(page, size, sortBy, direction);
    }
}
