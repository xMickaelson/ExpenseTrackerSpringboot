package com.expense_tracker.expense_tracker.Repository;

import com.expense_tracker.expense_tracker.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    @Query(
            value = "select *from expenses_tbl AS e where e.category_id = :categoryId",
            nativeQuery = true
    )
    List<Expense> findByCategoryId(@Param("categoryId") Long categoryId);

    @Query(
    """
        SELECT e.category.name, SUM(e.amount)
        FROM Expense e
        WHERE YEAR(e.date) = :year
          AND MONTH(e.date) = :month
        GROUP BY e.category.name
    """
    )
    List<Object []> getMonthlySummary(@Param("year") int year, @Param("month") int month);
}
