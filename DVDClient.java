package dvdSockets;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
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
    int count = 1024;
    
    public DVDClient() throws UnknownHostException, IOException {
		// TODO Auto-generated constructor stub
    	client=new Socket(SERVER_IP, SERVER_PORT1);
    	//pic pic=new pic();
		//pics=pic.getPics();
    	picture=new String[]{"1.PNG","2.PNG","3.PNG","4.PNG"};
    	
    	//getPic()这个函数从数据库获取一张图片的url
    	//pic这个集合利用写数据返回的同学给我的函数来构造。
    	
    	sendBytes=new byte[count];
	}
    
    //client get the pic send by server.
   public void recievePic() throws IOException{ 
	   
	  dataOutputStream=new DataOutputStream(client.getOutputStream());
	  // dataOutputStream.writeUTF("sendpic");
	  dataInputStream= new DataInputStream(new BufferedInputStream(client.getInputStream())); 
	 // BufferedReader bufferedReader = null
	   //String picEnd=null;
	   int length=0;
	  // picEnd=dataInputStream.readUTF();/Users/jiangruishan/Documents/test.
	   String allLength = dataInputStream.readUTF();
	   String allName = dataInputStream.readUTF();
	   
	   
	   String [] name= allName.split(" ");
	   String [] len = allLength.split(" ");
		long [] picLength =new long [ len.length];
		for (int i = 0; i < picLength.length; i++) {
			picLength[i]= Long.parseLong(len[i]);
		}
		
	   for(int i=1;i<6;i++){ 
		  
		   File file = new File("/Users/jiangruishan/Documents/test");
		   file = new File("/Users/jiangruishan/Documents/test/"+name[i-1]);
		   if (file.exists()) {
			  file.createNewFile();
		}
		   else {
			   file.createNewFile();
		}
		 
	   	   fOutputStream=new FileOutputStream(file);
	   	   
	   	  
	   	 int end;
	   	   
		   while(picLength[i-1]>0  ){
			   
			   		length= writeCount();
			   		System.out.println(length);
			   		if ((picLength[i-1]-length)<0) {
			   			fOutputStream.write(sendBytes,0,(int)picLength[i-1]);
					}
			   		else {
					fOutputStream.write(sendBytes,0,length);	
					}
					picLength[i-1]-=length;
					
		   }
		   System.out.println("recieve one pic");
		 
	   }
	   System.out.println("recieve all");
	   
	   System.out.println("ready to recieve file .");

/*
	   String command = "";
		int size = dataInputStream.readInt();
		for (int i = 0; i < size; i++) {
			command=command+dataInputStream.readChar();
		}
		 System.out.println(command);

		 if ((command ).equals("send all")) {


			   System.out.println("creating a new file");

			   int sz=0;

			   fOutputStream=new FileOutputStream("info.doc");

			 while(( sz = dataInputStream.read(sendBytes)) !=-1  ){

			   System.out.println(sz);

			   fOutputStream.write(sendBytes, 0, sz);

			   }
	*/

			 System.out.println("sucess write a file");
			 dataInputStream.close();
			 fOutputStream.close();
			 client.close();
		}
   
public int writeCount() throws IOException {
	 int readCount = 0; // 已经成功读取的字节的个数
  	  while (readCount < count) {
  	   readCount += dataInputStream.read(sendBytes, readCount, count - readCount);
  	  }
	return readCount;
}

		}

	

		
		
		
		

	/*
	 dataInputStream.close();
	 fOutputStream.close();
	 client.close();
	*/	   
	   
  
  
