package dtos;


import lombok.Data;
import models.Expense;

import java.util.List;

@Data
public class SettleUpGroupResponseDto {

    private List<Expense> transaction;

}
