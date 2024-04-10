package dtos;

import lombok.Data;
import models.Expense;

import java.util.List;


@Data
public class SettleUpUserResponseDto {

   private List<Expense> transactions;
}
