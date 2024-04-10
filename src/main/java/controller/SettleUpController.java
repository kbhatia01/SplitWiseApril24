package controller;


import dtos.SettleUpGroupRequestDto;
import dtos.SettleUpGroupResponseDto;
import dtos.SettleUpUserRequestDto;
import dtos.SettleUpUserResponseDto;
import org.springframework.stereotype.Controller;

@Controller
public class SettleUpController {


    // TODO: Call service from controller..
    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto requestDto){
        return  null;

    }

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto requestDto){
        return null;
    }

}
