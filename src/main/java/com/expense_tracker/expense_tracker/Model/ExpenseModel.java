package com.expense_tracker.expense_tracker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseModel {
    private Long expenseId;
    private String title;
    private BigDecimal amount;
    private LocalDate date;
    private String note;
    private CategoryModel category;
}
