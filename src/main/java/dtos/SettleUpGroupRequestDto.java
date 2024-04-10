package dtos;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SettleUpGroupRequestDto {
    private Long GroupId;
    private Long UserId;
}
