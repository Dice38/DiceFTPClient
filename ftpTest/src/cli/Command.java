package cli;

public interface Command {
    //Method Definitions
    String getCommandURL();

    String getCommandName();

    boolean run(String string);

    String getHelp();

}
