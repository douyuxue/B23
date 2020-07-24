package admin.show.GUI;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import admin.mybean.model.User;
import admin.mybean.model.personalinfor;
import admin.internalFrame.queryAndAlterPer;
import admin.internalFrame.queryhuncai;
import admin.internalFrame.querysucai;
import admin.internalFrame.querytaocan;

public class studentGUI extends JFrame {
	User user = null;
	personalinfor person = null;
	JMenuBar menubar = null;
	JMenu showmenu = null;
	JMenu personal = null;
	JMenu system = null;
	
	boolean querysucai = false;
	boolean querhuncai = false;
	boolean quertaocan = false;
	boolean queryandalter =false;
	
	JMenuItem sucai = null;
	JMenuItem huncai  = null;
	JMenuItem taocan  = null;
	
	JMenuItem lookpersonal = null;
	
	JMenuItem exit = null;
	
	JDesktopPane desktoppane = null;
	
	public studentGUI(User user,personalinfor person) {
		super("菜品信息");
		this.user = user;
		this.person = person;
		desktoppane = new JDesktopPane();
		desktoppane.setBackground(Color.getColor("#cccccc"));
		this.setSize(700, 550);
		this.setLocation(300, 100);
		this.getContentPane().add(desktoppane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menubar = new JMenuBar();
		
		showmenu = new JMenu("菜品信息");
		personal = new JMenu("个人信息");
		system = new JMenu("系统");
		
		sucai = new JMenuItem("素菜");
		sucai.addActionListener(new sucaiEvent());
		
		huncai = new JMenuItem("荤菜");
		huncai.addActionListener(new huncaiEvent());
		
		taocan = new JMenuItem("套餐");
		taocan.addActionListener(new taocanEvent());
		
		lookpersonal = new JMenuItem("个人信息");
		lookpersonal.addActionListener(new personalEvent());
		
		exit = new  JMenuItem("退出");
		exit.addActionListener(new exitEvent());
		
		showmenu.add(sucai);
		showmenu.add(huncai);
		showmenu.add(taocan);
		
		personal.add(lookpersonal);
		
		system.add(exit);
		
		menubar.add(showmenu);
		menubar.add(personal);
		menubar.add(system);
		
		setJMenuBar(menubar);
		setVisible(true);
		
	}
	
	
	class sucaiEvent implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (!querysucai) {

				querysucai = true;
				final JInternalFrame  sucai = new querysucai("素菜",
						false, true, false);
				sucai.addInternalFrameListener(new InternalFrameAdapter() {

					public void internalFrameClosed(InternalFrameEvent arg0) {
						querysucai = false;
					}
				});
				desktoppane.add(sucai);
			}
			
		}
	}
	
	class exitEvent implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
	
	class huncaiEvent implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (!querhuncai) {

				querhuncai = true;
				final JInternalFrame  huncai = new queryhuncai("荤菜",
						false, true, false);
				huncai.addInternalFrameListener(new InternalFrameAdapter() {

					public void internalFrameClosed(InternalFrameEvent arg0) {
						querhuncai = false;
					}
				});
				desktoppane.add(huncai);
			}
			
		}
	}
	
	class taocanEvent implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (!quertaocan) {

				quertaocan = true;
				final JInternalFrame  taocan = new querytaocan("套餐",
						false, true, false);
				taocan.addInternalFrameListener(new InternalFrameAdapter() {

					public void internalFrameClosed(InternalFrameEvent arg0) {
						quertaocan = false;
					}
				});
				desktoppane.add(taocan);
			}
			
		}
	}
	
	class personalEvent implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			if (!queryandalter) {

				queryandalter = true;
				final JInternalFrame  queryAalter = new queryAndAlterPer("个人信息",
						false, true, false, person);
				queryAalter.addInternalFrameListener(new InternalFrameAdapter() {

					public void internalFrameClosed(InternalFrameEvent arg0) {
						queryandalter = false;
					}
				});
				desktoppane.add(queryAalter);
			}
		}
	}
	

}
