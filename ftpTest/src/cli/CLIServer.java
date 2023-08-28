package cli;

import java.io.*;


public class CLIServer implements Runnable{
    private Reader inputReader;
    private Writer outputWriter, logWriter;

    private CommandTree commandTree;

    //Methods

    
    public CLIServer(Reader input, Writer output, Writer logOutput){

        //Assign Input Output Readers/Writers
        this.inputReader = input;
        this.outputWriter = output;
        this.logWriter = logOutput;

        //Instantiate CommandTree
        

    }

    public void run(){
        
    }

}