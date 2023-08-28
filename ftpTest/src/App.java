import java.io.Console;

import cli.*;



public class App {
    public static void main(String[] args) {
        
        Console console = System.console();

        
        if(console == null){
            System.err.println("No Console available");
            System.exit(333);
        }else{

        }
    }
}
