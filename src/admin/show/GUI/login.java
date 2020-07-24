package admin.show.GUI;

import java.awt.BorderLayout;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import admin.mybean.model.User;
import admin.mybean.model.personalinfor;
import admin.getinfor.mysql.GetDBConnection;
import admin.getinfor.mysql.LoginDao;
import admin.getinfor.mysql.LoginDao;
import admin.mybean.model.Admin;

public class login extends JFrame {
	boolean registeropend = false;
	Box boxHone,boxHtow,boxHthree,boxHfour;    //行式盒
	Box boxV;         //列式盒
	JTextField text1=null;         //文本框
	JPasswordField text2=null;
	JLabel usertypeLabel=null,usernameLabel=null,passwordLabel=null;   //标签
	JButton loginB=null,registerB=null,canelB=null;      //按钮
	@SuppressWarnings("rawtypes")
	JComboBox combox=null;    //下拉列表
	
	private JDesktopPane m_desktop = null;
	
	public login(String title){                       //构造方法
		super(title);
		setLayout(new java.awt.FlowLayout());
		init();
		
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void init(){
		
		m_desktop = new JDesktopPane();
		m_desktop.setBackground(Color.getColor("#cccccc"));
		this.setSize(600, 550);
		this.setLocation(700, 200);
		getContentPane().add(m_desktop);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		boxHone=Box.createHorizontalBox();
		boxHtow=Box.createHorizontalBox();
		boxHthree=Box.createHorizontalBox();
		boxHfour=Box.createHorizontalBox();
		boxV=Box.createVerticalBox();
		usertypeLabel=new JLabel("用户类型：");
		usernameLabel=new JLabel("用  户  名： ");
		passwordLabel=new JLabel("密        码：  ");
		text1 = new JTextField(15);
		text2 = new JPasswordField(15);
		
		loginB=new JButton("登录");
		loginBEvent loginb=new loginBEvent();
		loginB.addActionListener(loginb);
		
		//registerB=new JButton("注册");
		//registerB.addActionListener(new registerBEvent());
		
		canelB=new JButton("取消");
		canelB.addActionListener(new canelBEvent());
		
		combox=new JComboBox();
		combox.addItem("选择用户类型");
		String [] a={"学生","食堂","超级管理员"};
		for(int i=0;i<a.length;i++){
			combox.addItem(a[i]);
		}
		comboxEvent comb=new comboxEvent();
		combox.addItemListener(comb);
		comb.setJComboBox(combox);
		comb.setworkTogether(loginb);
	
		boxHone.add(usertypeLabel);
		boxHtow.add(usernameLabel);
		boxHthree.add(passwordLabel);
		boxHone.add(combox);
		boxHtow.add(text1);
		boxHthree.add(text2);

		boxHfour.add(loginB);
		boxHfour.add(Box.createHorizontalStrut(10));
		//boxHfour.add(registerB);
		boxHfour.add(Box.createHorizontalStrut(10));
		boxHfour.add(canelB);
		
		
		boxV.add(Box.createVerticalStrut(50));
		boxV.add(boxHone);
		boxV.add(Box.createVerticalStrut(20));
		boxV.add(boxHtow);
		boxV.add(Box.createVerticalStrut(20));
		boxV.add(boxHthree);
		boxV.add(Box.createVerticalStrut(20));
		boxV.add(boxHfour);
		add(boxV);
		setVisible(true);
	
	}
	public static void main(String[] args) {

		new login("食堂售餐系统");
	}

	class canelBEvent implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			System.exit(0);
		}

	}
	class comboxEvent implements ItemListener {  //下拉列表

		JComboBox<String> choice;
		loginBEvent workTogether;
		public void setJComboBox(JComboBox<String> box){
			choice=box;
		}
		public void setworkTogether(loginBEvent login){
			workTogether=login;
		}
		public void itemStateChanged(ItemEvent e) {
			String type=choice.getSelectedItem().toString();
			workTogether.setType(type);
			
		}

	}
	
	class loginBEvent implements ActionListener{    //登陆按钮
		String type;
		public void setType(String s){
			type=s;
		}
		public void actionPerformed(ActionEvent arg0){
			if(text1.getText().length()==0){
				JOptionPane.showMessageDialog(null,"用户名不能为空！","警告",JOptionPane.WARNING_MESSAGE);
				text1.requestFocus();
			}
			else if(text2.getText().length()==0){
				JOptionPane.showMessageDialog(null,"密码不能为空！","警告",JOptionPane.WARNING_MESSAGE);
				text2.requestFocus();
			}
			else{
				User a=new User();
				a.setUsername(text1.getText());
				a.setPass(text2.getText());
				//System.out.println("User:"+a.getUserno());
				LoginDao lm = new LoginDao();
				try {
					Boolean flag=lm.checkLogin(a);
					//System.out.println("flag:"+flag);
					if(flag){
						login.this.dispose();
						personalinfor person=lm.getLoginUserMsg(text1.getText());
						if(type.equals("学生")){
							new studentGUI(a,person);
						}
						else if(type.equals("食堂")){
							new  menuinformationGui(a , person);	
						}
						else if(type.equals("超级管理员")){
							//查询出登入的用户信息
							//PersonlInformation person=lm.getLoginUserMsg(text1.getText());
							new  managerinforGUI(a, person);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "用户名或者密码错误！", "警告",JOptionPane.WARNING_MESSAGE);
						text1.setText("");
						text2.setText("");
					}
				} catch (HeadlessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	/*class registerBEvent implements ActionListener{   //注册按钮
		public void actionPerformed(ActionEvent e) {

			if (!registeropend){

				registeropend = true;
				final JInternalFrame register = new RegisterInternalF("用户注册",
						false, true, false);
				
				register.addInternalFrameListener(new InternalFrameAdapter() {

							public void internalFrameClosed(
									InternalFrameEvent arg0) {
								registeropend = false;
							}
						});
				m_desktop.add(register);
			}
		}
	}*/
	
	}


