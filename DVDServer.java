package dvdSockets;
	import java.io.BufferedInputStream;
	import java.io.DataInputStream;
	import java.io.DataOutputStream;
	import java.io.File;
	import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
	import java.net.Socket;
	
public class DVDServer {

		private static final int SERVER_PORT =2016;
		ServerSocket serverSocket=null;
		Socket client=null;
		//change to try and catch!
		public DVDServer() throws IOException {
			// TODO Auto-generated constructor stub
			while (true) {
				serverSocket =new ServerSocket(SERVER_PORT);
				client=serverSocket.accept();
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
				FileInputStream fileInputStream=new FileInputStream(getPic());
				OutputStream outputStream=client.getOutputStream();
				byte[] sendByte=new byte[1024];
				sendPic(fileInputStream, outputStream, sendByte);
				fileInputStream.close();
				outputStream.close();
				client.close();
			}
			public void sendPic(FileInputStream fileInputStream,OutputStream outputStream,byte[] sendByte) throws IOException {
				int len=0;
				while ((len=fileInputStream.read(sendByte))!=-1) {
					outputStream.write(sendByte,0,len);
					outputStream.flush();
				}
			}
		}
}
