package cli;


public abstract class CommandTree {
    //Attributes
    CommandTreeNode rootState, currentState;


    //Methods
    
    CommandTreeNode getRootState(){
        return this.rootState;
    }

    CommandTreeNode getCurrentState(){
        return this.currentState;
    }

    boolean stepToNextState(String commandURL);

    boolean insertCommand(Command command);

    boolean deleteCommand(String commandURL);

    String retrieveAvailableCommands();

    boolean stepToPreviousState();

    boolean stepToRootState();
}
