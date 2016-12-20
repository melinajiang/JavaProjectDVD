package dvdSockets;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

public class pic {
	/*
	public static String[] pics=new String[]{"a.PNG","b.PNG","c.PNG","d.PNG"};
	public pic() {
		// TODO Auto-generated constructor stub
		pics=new String[]{"a","b","c","d"};
	}
	public static String[] getPic() {
		return pics;
	}*/
	private File picFile;
	private File[] pics;
	private String allLength="";

	private String allName= "";
	

	public void setAllLength(String allLength) {
		this.allLength = allLength;
	}

	public pic() {
		// TODO Auto-generated constructor stub
		picFile=new File("/Users/jiangruishan/Documents/picture" );
		pics=picFile.listFiles();
		
		 for(int i=0;i<pics.length;i++){
				   System.out.println(" "+pics[i]);
				   System.out.println(pics[i].getName());
				   System.out.println(pics[i].length());
				 }
		 for (int i = 1; i < pics.length; i++) {
		
		allLength = allLength+pics[i].length() + " ";
		allName = allName + pics[i].getName()+" ";
	}
		System.out.println(allLength);
		System.out.println(allName);
		String [] name= allName.split(" ");
		String [] len = allLength.split(" ");
		long [] length =new long [ len.length];
		for (int i = 0; i < length.length; i++) {
			length[i]= Long.parseLong(len[i]);
		}
	for (int i = 0; i < length.length; i++) {
		System.out.println(name[i]);
		System.out.println(length[i]);
	}
	}
	
	public File[] getPics() {
		return pics;
	}
	public String getAllName() {
		System.out.println(allLength);
		return allName;
	}
	public String getAllLength() {
		System.out.println(allName);
		return allLength;
	}
	
}
