package services;

import Repo.ExpenseRepo;
import Repo.ExpenseUserRepo;
import Repo.GroupRepo;
import Repo.UserRepo;
import Stratergy.SettleUpStratergy;
import models.Expense;
import models.ExpenseUser;
import models.Group;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SettleUpService {

    private UserRepo userRepo;
    private ExpenseUserRepo expenseUserRepo;

    private SettleUpStratergy settleUpStratergy;

    private GroupRepo groupRepo;

    private ExpenseRepo expenseRepo;

    @Autowired
    SettleUpService(
            UserRepo userRepo,
            ExpenseUserRepo expenseUserRepo,
            SettleUpStratergy settleUpStratergy,
            GroupRepo groupRepo,
            ExpenseRepo expenseRepo
    ){
        this.userRepo = userRepo;
        this.expenseUserRepo = expenseUserRepo;
        this.settleUpStratergy = settleUpStratergy;
        this.groupRepo = groupRepo;
        this.expenseRepo = expenseRepo;
    }

    public List<Expense> SettleUpUser(Long UserId) {
        // 1. validate User
        Optional<User> userOption = this.userRepo.findById(UserId);
        if(userOption.isEmpty()){
            throw new RuntimeException("User not found");
        }
        User u = userOption.get();

        // 2. get all expenses related to that User
        List<ExpenseUser> expenses = expenseUserRepo.findAllByUser(u);

        Set<Expense> expensesSet = new HashSet<>();

        for (ExpenseUser e: expenses){
            expensesSet.add(e.getExpense());
        }


        // 3. Iterate to find the net aggregate of this users
        // 4. make transactions/expense..

        List<Expense> transactions = settleUpStratergy.settleUp(expensesSet.stream().toList());

        // 5. return all transactions created..

        return transactions;
    }


    public List<Expense> SettleUpGroup(Long GroupId, Long UserId){
        // 1 validate group and user
            Optional<Group> groupOption = this.groupRepo.findById(GroupId);
            if(groupOption.isEmpty()){
                throw new RuntimeException("group not found");
            }
            Group group = groupOption.get();
        Optional<User> userOption = this.userRepo.findById(UserId);
        if(userOption.isEmpty()){
            throw new RuntimeException("User not found");
        }
        User u = userOption.get();
        // 2 Extract all transaction in group..

        List<Expense> expenses = expenseRepo.findAllByGroup(group);
        // 3 Iterate to find the net aggregate of all users
        // 4. make transactions/expense..

        List<Expense> transactions = settleUpStratergy.settleUp(expenses);
        // 5. return all transactions created..



        return transactions;
    }

}
