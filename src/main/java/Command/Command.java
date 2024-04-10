package Command;

public interface Command {

    public boolean matches(String input);
    public void execute(String input);
}
