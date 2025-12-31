package com.expense_tracker.expense_tracker.Entity;

import jakarta.persistence.*;
import jakarta.websocket.ClientEndpointConfig;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(
        name = "expenses_tbl"
)
@Builder
public class Expense {
    @Id
    @SequenceGenerator(
            name = "expense_sequence",
            sequenceName = "expense_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "expense_sequence"
    )
    private Long expenseId;
    private String title;
    private BigDecimal amount;
    private LocalDate date;
    private String note;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
