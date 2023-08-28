package cli;

public abstract class CommandTreeNode{


    private Command command;

    private CommandTreeNode rightSibling, leftmostChild, father;


    //Methods
    public Command getCommand(){
        return this.command;
    }

    public CommandTreeNode getLeftmostChild(){
        return this.leftmostChild;
    }

    public CommandTreeNode getRithSibling(){
        return this.rightSibling;
    }
    
    CommandTreeNode getFather(){
        return this.father;
    }

    
}
