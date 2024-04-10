package Repo;

import models.ExpenseUser;
import models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserRepo extends JpaRepository<ExpenseUser, Long> {

    List<ExpenseUser> findAllByUser(User u);

}
