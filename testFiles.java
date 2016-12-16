package dvdSockets;

import java.io.File;

import org.omg.CORBA.PUBLIC_MEMBER;

public class testFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("/Users/jiangruishan/Documents/picture" );
		File [] f2=file.listFiles();
		
		
		 for(int i=1;i<f2.length;i++){
				   System.out.println(" "+f2[i]);
				   System.out.println(f2[i].getName());
				   System.out.println(f2[i].length());
				 }
		 
	}
	

}
