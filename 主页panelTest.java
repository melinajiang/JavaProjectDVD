package dvdSockets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.usst.db.LogonCheck;

import javax.sound.midi.MidiDevice.Info;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JPasswordField;
import javax.swing.JButton;


public class 主页panelTest {

	static JButton button1 ;
	static JButton button2 ;
	static JTextField text1 ;
	static JLabel label5;
	static String loginName ;
	static JFrame frm;
	static ImageIcon image; 
	private static final int width=100;
	private static final int height=150;
	private static final int innerWidth = 200;
	private static final int innerHeight = 280; 
	LogonCheck logonCheck;
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		DVDClient dvdClient=new DVDClient();
		dvdClient.recievePic();
		getPicPath getPicPath = new getPicPath(dvdClient.getPath());
		LogonCheck logonCheck = new LogonCheck();
		frm = new JFrame();
		frm.setTitle("xx");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);
		
		//按钮组件
	
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
		label1.setSize(100, 150);
		label1.setFont(new Font("",Font.BOLD,13));
		//label1.setIcon(new ImageIcon("1.jpg"));
		/*
		 image = new ImageIcon("/Users/jiangruishan/Documents/picture/你的名字.PNG");  
        // image.setImage(image.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT));  
        Image img = image.getImage();  
        img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);  
        image.setImage(img);  
        label1.setIcon(image);  
        */
		
		//"你的名字处用数据库返回的名字的方法。"
		String moiveName = "情书";
		new setPicSize(moiveName, label1,getPicPath,width,height);
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setVerticalAlignment(JLabel.BOTTOM); 
		frm.getContentPane().add(label1);
		
		
		label1.addMouseListener(new MouseListener() {
			String []dvdInfo = new String[3];
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(loginName);
				dvdInfo = logonCheck.finDvd(moiveName);
				Info_Page_new修改.setInfoPage(moiveName, Info_Page_new修改.poster1, getPicPath, innerWidth, innerHeight, frm, dvdInfo, logonCheck, loginName);
				frm.setVisible(false);
			}
		});
		
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
				//打包成方法setLoginPage。
				/*
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
			
			    
			  */
				主页panelTest.setLoginPage();
			    
			}
			
				
		});
		
		
		
		button2 = new JButton();
		button2.setText("注册");
		button2.setBounds(550,0,50,25);
		frm.getContentPane().add(button2);

	
		frm.setBounds(400,200,600,400);
		frm.setVisible(true);
		
		主页panelTest.loginListener();
		
		/*
		while (true) {
		System.out.println("wait input");
		if (!(loginName.equals("hi"))) {
		System.out.println("resset");
		resetBanner();
		break;
		}
		}
		*/
	}
		
		
	public static void setLoginPage() {
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
				System.out.println(loginName);
			}
		
		});
	    
	    
	    JPasswordField pwdText= new JPasswordField();
	    pwdText.setText("mypassword");
	    pwdText.setEchoChar('*');
	    pwdText.setBounds(60,107,120,30);
	    frame.getContentPane().add(pwdText);
	    //Info_Page_new修改.setInfoPage(moiveName, Info_Page_new修改.poster1, getPicPath, innerWidth, innerHeight, frm, dvdInfo, logonCheck, loginName);
	}
	
	public static String returnLoginName() {
		return loginName;
		// TODO Auto-generated method stub
		
	}
	public static void loginListener() {
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
		//return loginName;
		}
		
	
}

