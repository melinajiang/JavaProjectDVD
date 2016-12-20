package cn.edu.usst.wsy;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class Panel {

	static JButton button1 ;
	static JButton button2 ;
	static JTextField text1 ;
	static JLabel label5;
	static String loginName ;
	static JFrame frm;
	public static void main(String[] args) {
		
		frm = new JFrame();
		frm.setTitle("xx");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);
		
		//按钮组件
		button1 = new JButton();
		button1.setText("登录");
		button1.setBounds(510,0,50,25);
		frm.getContentPane().add(button1);
		text1 = new JTextField();
		loginName = "hi";
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame frame= new JFrame("balabala");
				frame.setBounds(500,200,250,300);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			    frame.setVisible(true);
                frame.setLayout(null);			   
			    //frm.setVisible(false);
			
			    JLabel label6 = new JLabel("登陆");
			    label6.setBounds(107,40,50,25);
			    frame.getContentPane().add(label6);
			   
			    
			    
			    text1.setHorizontalAlignment(JTextField.LEFT);
			    text1.setBounds(60,70,120,30);
			    frame.getContentPane().add(text1);
			    text1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						loginName = text1.getText();
					}
				});
			    
			    
			    JPasswordField pwdText= new JPasswordField();
			    pwdText.setText("mypassword");
			    pwdText.setEchoChar('*');
			    pwdText.setBounds(60,107,120,30);
			    frame.getContentPane().add(pwdText);
			
			    
			    
			    
			}
		});
		
		
		
		button2 = new JButton();
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
		
		
		

		JLabel label1 = new JLabel("");
		label1.setBounds(40,51,96,141);
		label1.setFont(new Font("",Font.BOLD,13));
		label1.setIcon(new ImageIcon("1.jpg"));
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		
		
		label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setVerticalAlignment(JLabel.BOTTOM); 
		frm.getContentPane().add(label1);
		
	
		frm.setBounds(400,200,600,400);
		frm.setVisible(true);
		
		while (true) {
		System.out.println("wait input");
		if (!(loginName.equals("hi"))) {
		System.out.println("resset");
		resetBanner();
		break;
		}
		}
	}
		
		
			
	
	
	
	public static void  resetBanner() {
		System.out.println(loginName);
		JLabel label5 = new JLabel(loginName);
		frm.getContentPane().add(label5);
		label5.setBounds(510,0,100,25);
		label5.setVisible(true);
		button1.setVisible(false);
		button2.setVisible(false);
		}
		
		
	
	
	
}
	

