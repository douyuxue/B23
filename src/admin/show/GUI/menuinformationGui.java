package admin.show.GUI;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.jws.soap.SOAPBinding.Use;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import admin.internalFrame.addmenInter;
import admin.internalFrame.altermenuInter;
import admin.internalFrame.deletemenuInter;
import admin.internalFrame.queryAndAlterPer;
import admin.internalFrame.querymenuInter;
import admin.mybean.model.Admin;
import admin.mybean.model.User;
import admin.mybean.model.personalinfor;
public class menuinformationGui extends JFrame{
	JFrame jf= null;
	JPanel jp = null;
	JMenuItem altermenu = null;
	JMenuItem addmenu = null;
	JMenuItem deletemenu = null;
	JMenuItem querymenu = null;
	JMenu information = null;
	JMenu show = null;
	JMenu exit = null;
	JDesktopPane desktoppane = null;
	JMenuBar menubar = null;
	
	JMenuItem alterAndquery = null;
	
	
	boolean addscopend = false;
	boolean queryment = false;
	boolean delete = false;
	boolean alter = false;
	Admin admin = null;
	User user = null;
	personalinfor person = null;
	//JInternalFrame quermenu = null;
	
	public menuinformationGui(User user,personalinfor person) {
		super("菜品管理信息");
		this.user = user;
		this.person = person;
		desktoppane = new JDesktopPane();
		desktoppane.setBackground(Color.getColor("#cccccc"));
		this.setSize(600, 550);
		this.setLocation(700, 200);
		this.getContentPane().add(desktoppane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jp = new JPanel();
		menubar = new JMenuBar();
		show = new JMenu("菜品管理");
		
		addmenu = new JMenuItem("添加菜品");
		addmenu.addActionListener(new addmenuEvent());
		
		
		deletemenu = new JMenuItem("删除菜品");
		deletemenu.addActionListener(new deletemenuEvent());
		
		
		querymenu = new JMenuItem("查询菜品");
		querymenu.addActionListener(new querymenuEvent());
		
		
		altermenu = new JMenuItem("修改菜品");
		altermenu.addActionListener(new altermenuEvent());
		
		information = new JMenu("个人信息");
		alterAndquery =  new JMenuItem("个人信息");
		alterAndquery.addActionListener(new alterAndqueryEvent());

		
		exit = new JMenu ();
		exit.addActionListener(new exitEvent());
		
		information.add(alterAndquery);
		
		
		show.add(addmenu);
		show.add(deletemenu);
		show.add(querymenu);
		show.add(altermenu);
		
		menubar.add(show);
		menubar.add(information);
		menubar.add(exit);
	
		this.setJMenuBar(menubar);
		this.setVisible(true);
	}
	class addmenuEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!addscopend) {

				addscopend = true;
				final JInternalFrame addscInerF = new addmenInter("添加菜单",
						false, true, false);
				addscInerF.addInternalFrameListener(new InternalFrameAdapter() {

					public void internalFrameClosed(InternalFrameEvent arg0) {
						addscopend = false;
					}
				});
				desktoppane.add(addscInerF);
			}
		}
	}
	class deletemenuEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!delete) {
				delete = true;
				final JInternalFrame checksInerF = new deletemenuInter("删除学生",
						false, true, false);
				checksInerF
						.addInternalFrameListener(new InternalFrameAdapter() {

							public void internalFrameClosed(
									InternalFrameEvent arg0) {
								delete = false;
							}
						});
				desktoppane.add(checksInerF);
			}
			
			
		}
	}
	
	class altermenuEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!alter) {

				alter = true;
				final JInternalFrame modifyscInternalF = new altermenuInter(
						"修改菜单", false, true, false);
				modifyscInternalF
						.addInternalFrameListener(new InternalFrameAdapter() {

							public void internalFrameClosed(
									InternalFrameEvent arg0) {
								alter = false;
							}
						});
				desktoppane.add(modifyscInternalF);
			}
			                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
		}
		
		
	}
	class querymenuEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!queryment) {

				queryment = true;
				JInternalFrame checkscInerF = null;
				
					checkscInerF = new querymenuInter(
						"查询菜单", false, true, false);
				
				checkscInerF.addInternalFrameListener(new InternalFrameAdapter() {

							public void internalFrameClosed(
									InternalFrameEvent arg0) {
								queryment = false;
							}
						});
				desktoppane.add(checkscInerF);
			}
			
		}
	}
	class alterAndqueryEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (!queryment) {
				queryment = true;
				JInternalFrame  queryimfor= null;
				
				queryimfor = new queryAndAlterPer(
						"查询菜单", false, true, false,person);
				
				queryimfor.addInternalFrameListener(new InternalFrameAdapter() {

							public void internalFrameClosed(
									InternalFrameEvent arg0) {
								queryment = false;
							}
						});
				desktoppane.add(queryimfor);
			}
		}
}
	
	class exitEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
}
}
	
	