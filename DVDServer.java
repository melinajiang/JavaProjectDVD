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
				ServerThread serverThread=new ServerThread(client);
				Thread thread=new Thread(serverThread);
				thread.start();
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
				try {
					
					outputStream =new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
			
				try {
					//fileInputStream.close();
					outputStream.close();
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("wrong closing");
				}
				
				/*
				for(int i=0;i<picName.length;i++){
				try {
						
						fileInputStream = new FileInputStream(picName[i]);
						
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					System.out.println("hi");
					outputStream =client.getOutputStream();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				byte[] sendByte=new byte[1024];
				try {
					sendPic(fileInputStream, outputStream, sendByte);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				picNum++;
				}
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			*/	
				
			}
			
			public void sendPic(FileInputStream fileInputStream,DataOutputStream outputStream,byte[] sendByte) throws IOException {
				int len=0;
				while ((len=fileInputStream.read(sendByte))!=-1) {
					System.out.println(len);
					outputStream.write(sendByte,0,len);
					//outputStream.flush();
					if (len!=1024) {
						byte[] b = new byte[1024 -len];  
						outputStream.write(b,0,b.length);
					}
				}
			}
			
		}
}
