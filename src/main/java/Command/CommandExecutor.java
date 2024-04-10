package Command;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {

    List<Command> commands = new ArrayList<>();



    public void AddCommand(Command c){
        commands.add(c);
    }

    public void RemoveCommand(Command c){
        commands.remove(c);
    }

    public void execute(String input){
        for(Command c: commands){
            if(c.matches(input)){
                c.execute(input);
                return;
            }
        }
    }

}
