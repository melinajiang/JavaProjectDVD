package dvdSockets;
	import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
	import java.io.DataOutputStream;
	import java.io.File;
	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
	import java.net.Socket;

import javax.imageio.stream.FileImageInputStream;
import javax.net.ssl.SSLException;
	
public class DVDServer {
		//this is the commander to tell the server what to give .
		
		private static final int SERVER_PORT =2016;
		protected static int picNum;
		ServerSocket serverSocket=null;
		Socket client=null;
		private File[] pictures;
		//private String[] picName;
		//change to try and catch!
		
		public DVDServer() throws IOException, InterruptedException {
			// TODO Auto-generated constructor stub
			while (true) {
				serverSocket =new ServerSocket(SERVER_PORT);
				client=serverSocket.accept();
				System.out.println("success connection!");
				ServerThread serverThread1=new ServerThread(client);
				Thread threadPic=new Thread(serverThread1);
				threadPic.start();
				serverSocket.close();
				
			}
		}

	
	    class ServerThread implements  Runnable{
	    	private Socket client;
		    public ServerThread(Socket client) {
				// TODO Auto-generated constructor stub
		    	this.client=client;
			}
		    //what server do to the client can be seen in run! 
		    //the server will input pic through outputsteam into client 
			public void run() {
				byte[] sendByte=new byte[1024];
				FileInputStream fileInputStream = null;
				DataOutputStream outputStream = null;
				pic pic=new pic();
				pictures=pic.getPics();
				String allName = pic.getAllName();
				String allLength = pic.getAllLength();
				try {
					
					outputStream =new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				try {
					outputStream.writeUTF(allLength);
					outputStream.writeUTF(allName);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					System.out.println("write head info wrong");
				}
				
				
				for (int i = 1; i < pictures.length; i++) {
					
					try {
						fileInputStream=new FileInputStream(pictures[i]);
						System.out.println("find one pic");
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println("pic not found");
						e.printStackTrace();
					}
					
					System.out.println("ready to send pics");
					try {
						sendPic(fileInputStream, outputStream, sendByte);
						System.out.println("send pic success!!!");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("error");
					}
					
					try {
						fileInputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("close it wrong");
					}
				}
				System.out.println("already send all");
				/*
				try {
					System.out.println("send comand.");
					String command = "send all";
					int size = command.length();
					outputStream.writeInt (size);
					outputStream.writeChars(command);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("wrong writing!");
				}
				
				try {
					fileInputStream = new FileInputStream("/Users/jiangruishan/Documents/file/lan.docx");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
}


		System.out.println("start to send file");
				try {

					fileInputStream = new FileInputStream("/Users/jiangruishan/Documents/file/lan.docx");

					System.out.println("open the file success!");

					} catch (FileNotFoundException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

					System.out.println("fail in opening file");

					}


					try {

					System.out.println("ready to send");
					sendFile(fileInputStream, outputStream, sendByte);
					System.out.println("send file success!");

					} catch (IOException e1) {

					// TODO Auto-generated catch block

					e1.printStackTrace();

					System.out.println("sendfile failed");

}
*/
				try {
					
					outputStream.close();
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("wrong closing");
				}
				
				

				
			}
			
			public void sendPic(FileInputStream fileInputStream,DataOutputStream outputStream,byte[] sendByte) throws IOException {
				int len=0;
				while ((len=fileInputStream.read(sendByte))!=-1) {
					System.out.println(len);
					outputStream.write(sendByte,0,len);
					waitIt();
					//outputStream.flush();
					if (len!=1024) {
						byte[] b = new byte[1024 -len];  
						outputStream.write(b,0,b.length);
					}
				}
			}
			public void  sendFile(FileInputStream fileInputStream,DataOutputStream outputStream,byte[] sendByte) throws IOException {

				int len=0;

				while ((len=fileInputStream.read(sendByte))!=-1) {

				System.out.println(len);

				outputStream.write(sendByte,0,len);

				//outputStream.flush();

				}

				}
			public boolean waitIt() {
				int a=1;
				for(int i=0;i<10;i++){
					a=a*i;
				}
				return true;
			}
		}
}
