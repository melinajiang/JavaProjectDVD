package dvdSockets;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class DVDClient extends Socket{
    private static final String SERVER_IP ="127.0.0.1";
    private static final int SERVER_PORT1 =2016;
    private static final int SERVER_PORT2 =2015;
    //private static String command="";
    private Socket client;
    private FileOutputStream fOutputStream;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private String[] picture;
    private File[] pics;
    byte[] sendBytes=null;
    
    public DVDClient() throws UnknownHostException, IOException {
		// TODO Auto-generated constructor stub
    	client=new Socket(SERVER_IP, SERVER_PORT1);
    	pic pic=new pic();
		pics=pic.getPics();
    	picture=new String[]{"1.PNG","2.PNG","3.PNG","4.PNG"};
    	//System.arraycopy(pic.pics, 0, picture, 0, picture.length);
    	//dataInputStream=new DataInputStream(client.getInputStream());
    	/*
    	for (int i = 0; i < pic.size(); i++) {
			new FileOutputStream(pic.get(i));
	
    	*/
    	//getPic()这个函数从数据库获取一张图片的url
    	//pic这个集合利用写数据返回的同学给我的函数来构造。
    	sendBytes=new byte[1024];
	}
    
    //client get the pic send by server.
   public void recievePic() throws IOException{ 
	   dataOutputStream=new DataOutputStream(client.getOutputStream());
	  // dataOutputStream.writeUTF("sendpic");
	   dataInputStream= new DataInputStream(new BufferedInputStream(client.getInputStream())); 
	   //String picEnd=null;
	   int length=0;
	  // picEnd=dataInputStream.readUTF();
	   for(int i=1;i<pics.length;i++){ long picLength=pics[i].length();
		//while (true) {
	   	   fOutputStream=new FileOutputStream(pics[i].getName());
	   	   
		// if (dataInputStream.readUTF().equals("start!")) {
		   //write pic through the inputSteam into picfile (write what the server has sent into file .)
		   while(picLength>0 && (length = dataInputStream.read(sendBytes)) !=-1  ){
			   		System.out.println(length);
			   		if ((picLength-length)<0) {
			   			fOutputStream.write(sendBytes,0,(int)picLength);
					}
			   		else {
					fOutputStream.write(sendBytes,0,length);	
					}
					picLength-=length;
					
		   }
		  
		  // length = dataInputStream.read(sendBytes);
		  // fOutputStream.write(sendBytes,0,length);
		   System.out.println("recieve one pic");
		   //picEnd=dataInputStream.readUTF();
		  // }
		//else {
		//	continue;
		//}
		//}
	   }
	   
			 dataInputStream.close();
			 fOutputStream.close();
			 client.close();
		}

		}
	

		
		
		
		

	/*
	 dataInputStream.close();
	 fOutputStream.close();
	 client.close();
	*/	   
	   
  
  
