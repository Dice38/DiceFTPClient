import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPSClient;




class FTPSClientBuilder {
    FTPSClient ftpsClient;
    String server, username, password;

    public FTPSClientBuilder(){
        this.ftpsClient = new FTPSClient();
    }


   public FTPSClientBuilder reset(){
        this.ftpsClient = new FTPSClient();
        return this;
   }

   public FTPSClientBuilder connect(String server){
        try{
            this.ftpsClient.connect(server);
            this.server = server;
        }catch(SocketException socket){
            System.out.println("Couldn't connect to server");
            socket.printStackTrace(System.out);
        }catch(IllegalArgumentException argumentException){
            System.out.print
        }
    }


}
