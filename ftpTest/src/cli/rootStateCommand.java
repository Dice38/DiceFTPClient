package cli;

class rootStateCommand implements Command {
    

    //Methods
    public String getHelp(){
        return "Root State of the Application";
    }

    public boolean run(String commandParameters) throws IllegalStateException{
        throw new IllegalStateException("Root State is not a runnable command. Look for runnable commands in the children of the root");
    }

    public String getCommandURL(){
        return "root";
    }

}
