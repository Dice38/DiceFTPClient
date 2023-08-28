package cli;

public interface Command {
    //Method Definitions
    String getCommandURL();

    boolean run(String string);

    String getHelp();

}
