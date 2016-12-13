package dvdSockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class DVDClient extends Socket{
    private static final String SERVER_IP ="127.0.0.1";
    private static final int SERVER_PORT =2016;
    private Socket client;
    private FileOutputStream fOutputStream;
    private DataInputStream dataInputStream;
    byte[] sendBytes=null;
    
    public DVDClient() throws UnknownHostException, IOException {
		// TODO Auto-generated constructor stub
    	client=new Socket(SERVER_IP, SERVER_PORT);
    	dataInputStream=new DataInputStream(client.getInputStream());
    	fOutputStream=new FileOutputStream(getPic());
    	sendBytes=new byte[1024];
	}
    //client get the pic send by server.
   public void recievePic() throws IOException{
	   int len=0;
	   //write pic through the inputSteam into picfile (write what the server has sent into file .)
	   while((len=dataInputStream.read(sendBytes))!=-1){
		   fOutputStream.write(sendBytes,0,len);
	   }
	   dataInputStream.close();
	   fOutputStream.close();
	   client.close();
   }
}
