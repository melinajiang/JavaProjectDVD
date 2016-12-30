package dvdSockets;
import javax.swing.*;  
import java.awt.Image;  
	  
public class setPicSize  { 
//200*180
//100*150	
	 
	   // private JLabel jlb = new JLabel();  
	   private ImageIcon image;  
	   
	    
	    public setPicSize(String name,JLabel jLabel,getPicPath picPath,int width,int height) {
			// TODO Auto-generated constructor stub
		
	        //this.setSize(800, 600);  
	        //this.setLayout(null);  
	    	
	        image = new ImageIcon(picPath.getOnePicPath(name));  
	        // image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));  
	        Image img = image.getImage();
	        img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);  
	        image.setImage(img);  
	        jLabel.setIcon(image);  
	  		
	       // this.add(jlb);  
	       // jlb.setSize(width, height);  
	        //this.setVisible(true);  
	    }  
	  
	   
	
}
