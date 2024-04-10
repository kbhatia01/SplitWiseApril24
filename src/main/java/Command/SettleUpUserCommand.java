package Command;

import java.util.List;

public class SettleUpUserCommand implements Command{
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        if(words.size() == 2 && words.get(0).equals("SettleUpUser")){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {

    }
}
