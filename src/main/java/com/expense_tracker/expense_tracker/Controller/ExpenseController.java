package com.expense_tracker.expense_tracker.Controller;

import com.expense_tracker.expense_tracker.Entity.Expense;
import com.expense_tracker.expense_tracker.Service.Expenses.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Add New Expense")
    public Expense addExpense(@RequestBody Expense payload) {
        return expenseService.addExpense(payload);
    }

    @GetMapping("/api/v1/getAllExpense")
    @Operation(summary = "List All Expenses")
    public List<Expense> getAllExpenses(){
        List<Expense> allExpensesList = expenseService.getAllExpenses();
        return allExpensesList;
    }

    @GetMapping("/api/v1/getExpense")
    @Operation(summary = "Get Expense By Category")
    public List<Expense> getExpensesByCategory(@RequestParam String categoryName){
        return expenseService.getExpensesByCategory(categoryName);
    }

    @GetMapping("/api/v1/summary")
    @Operation(summary = "Summarize expense by month and year")
    public List<Object []> getMonthlySalary(@RequestParam int year, @RequestParam int month){
        return expenseService.getMonthlyExpenseSummary(year, month);
    }

    @GetMapping("/api/v1/expenses")
    @Operation(summary = "Expense Paging and Sorting")
    public Page<Expense> getAllExpensesPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "date") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ){
        return expenseService.getAllExpensesPage(page, size, sortBy, direction);
    }
}
