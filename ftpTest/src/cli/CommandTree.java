package cli;

import java.util.regex.*;
import java.util.LinkedList;

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
    boolean insertCommand(Command command){
        var URLParser = new commandURLParser(command.getCommandURL());
        var currentNode = this.getRootState();

        while(URLParser.peekPath() != null){
            var tempNode = currentNode.getLeftmostChild();
            do{
                if(tempNode.getCommand().getCommandName().equals(URLParser.peekPath())){
                    currentNode = tempNode;
                    URLParser.consume();
                    break;
                }else{
                    tempNode = tempNode.getRightSibling();
                }
            }while(tempNode != null);
            if(tempNode == null)throw new IllegalArgumentException("Command carries invalid CommandURL");
        }
       
    }
    
    boolean stepToNextState(String commandURL);


    boolean deleteCommand(String commandURL);

    String retrieveAvailableCommands();


    //Inner Parser Class for Command URLs

    class commandURLParser{
        //Attributes
        private StringBuilder commandURL;
        private LinkedList<String> commandPath = new LinkedList<String>();
        private StringBuilder commandName;

        //Constructor
        /**
         * Constructor to create Parsing Object for CommandURLS that allows to consume URLs step by step for each of their component. 
         * @param commandURL 
         * The URL of the command that is supposed to be added
         * @throws IllegalArgumentException
         */
        commandURLParser(String commandURL) throws IllegalArgumentException{
            //Check CommandURL for basic node pattern xxx.xxx.xx
            String pattern = "^([^ ]+\\.)++[^ \\.]+$";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(commandURL);
            if(!matcher.find()){
                throw new IllegalArgumentException("The passed CommandURL is syntactically incorrect");
            }
            this.commandURL = new StringBuilder(commandURL);
            //split the commandURL in its components
            this.setCommandComponents();
        }

        /**
         * Internal Method to split the CommandURL in its name and the path leading to the command's position in the command tree
         */
        private void setCommandComponents(){
            //Part to parse the part in Front of the final '.' as the command name itself instead of the path to the command
            for(int i = commandURL.length()-1; commandURL.charAt(i) != '.';i--){
                this.commandName.append(this.commandURL.charAt(i));
                this.commandURL.deleteCharAt(i);
            }
            this.commandName.reverse();
            this.commandURL.deleteCharAt(commandURL.length()-1);


            var tempString = new StringBuffer();
            while(!this.commandURL.isEmpty()){
                if(this.commandURL.charAt(0) != '.'){
                    tempString.append(this.commandURL.charAt(0));
                    this.commandURL.deleteCharAt(0);
                }else{
                    this.commandPath.add(tempString.toString());
                    this.commandURL.deleteCharAt(0);
                }
            }
        }
        /**
         * Method that consumes the components of CommandURL's path one by one. 
         * @return
         * Each subsequent call returns the next path component as a String. If the Path has been fully consumed the method returns null. 
         */
        public String consume(){
            if(!this.commandPath.isEmpty()){
                String temp = this.commandPath.getFirst();
                this.commandPath.removeFirst();
                return temp;
            }else{
                return null;
            }
        }
        public String peekPath(){
            return this.commandPath.isEmpty()?null:this.commandPath.getFirst();
        }
        /**
         * 
         * @return
         * Returns the Name of the Command, so the yyy part in xxx.xxx.yyy
         */
        public String getName(){
            return this.commandName.toString();
        }


        
    }
}
