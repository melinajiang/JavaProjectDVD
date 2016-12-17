package cn.edu.usst.wsy;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;



public class Panel {


	public static void main(String[] args) {
		
		JFrame frm = new JFrame();
		frm.setTitle("xx");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);
		
		//按钮组件
		JButton button1 = new JButton();
		button1.setText("登录");
		button1.setBounds(510,0,50,25);
		frm.getContentPane().add(button1);
		
		JButton button2 = new JButton();
		button2.setText("注册");
		button2.setBounds(550,0,50,25);
		frm.getContentPane().add(button2);

		//修改后的文本
		JLabel label3 = new JLabel("近期热映");
		label3.setBounds(10,30,65,25);
		label3.setFont(new Font("",Font.BOLD,13));
		frm.getContentPane().add(label3);
		
		JLabel label4 = new JLabel("重温经典");
		label4.setBounds(10,200,65,25);
		label4.setFont(new Font("",Font.BOLD,13));
		frm.getContentPane().add(label4);
		
		
		
片
		JLabel label1 = new JLabel("奇异博士");
		label1.setBounds(30,40,96,141);
		label1.setFont(new Font("",Font.BOLD,13));
		label1.setIcon(new ImageIcon("1.jpg"));
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		
		
		label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setVerticalAlignment(JLabel.BOTTOM); 
		frm.getContentPane().add(label1);
		
		
		
		
		frm.setBounds(400,200,600,400);
		frm.setVisible(true);
		
		
		
		
	}

}
