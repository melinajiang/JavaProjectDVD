package cn.edu.usst.wsy;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame {

	static JButton button1;
	
	public static void main(String[] args) {
		JFrame frame= new JFrame("balabala");
		frame.setBounds(500,200,400,130);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    frame.setVisible(true);
	    frame.setLayout(null);
	    
	    JLabel label1 = new JLabel("用户名或密码输入错误！");
	    label1.setBounds(100,30,150,25);
	    frame.getContentPane().add(label1);
	    
	    button1 = new JButton();
	    button1.setText("返回上层");
	    button1.setBounds(250,60,80,25);
	    frame.getContentPane().add(button1);
	    button1.setVisible(true);
	}

}
