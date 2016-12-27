package cn.edu.usst.wsy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ActionLister implements ActionListener {

	
	
		public void actionPerformed(ActionEvent e){
			JFrame frame= new JFrame("balabala");
			frame.setBounds(400,200,200, 200);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		    frame.setVisible(true);
		    
		    
		    
		    
	}

}
