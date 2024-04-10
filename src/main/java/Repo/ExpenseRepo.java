package Repo;

import models.Expense;
import models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {

    List<Expense> findAllByGroup(Group g);
}
