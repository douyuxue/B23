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

import admin.internalFrame.addStudentInter;
import admin.internalFrame.alterStudentInter;
import admin.internalFrame.deleteStudentInter;
import admin.internalFrame.queryAdminInter;
import admin.internalFrame.queryStudentInter;
import admin.mybean.model.Manager;
import admin.mybean.model.User;
import admin.mybean.model.personalinfor;


public class managerinforGUI extends JFrame {
	boolean addscopend = false;
	boolean checkscopend = false;
	boolean modifyscopend = false;

	boolean addsopend = false;
	boolean modifysopend = false;
	boolean delsopend = false;
	boolean checksopend = false;

	boolean addcopend = false;
	boolean modifycopend = false;
	boolean delcopend = false;
	boolean checkcopend = false;
	
	personalinfor person = null;
	User user = null;
	
	private JDesktopPane desktoppane = null;
	JMenuBar menubar = null;

	JMenu student = null;
	JMenu admin = null;
	JMenu ordermenu = null;
	JMenu exits = null;

	JMenuItem addstu = null;
	JMenuItem alterstu = null;
	JMenuItem delstu = null;
	JMenuItem checkstu = null;

	
	JMenuItem addadm = null;
	JMenuItem alteradm = null;
	JMenuItem deladm = null;
	JMenuItem checkadm = null;
	
	JMenuItem  query = null;
	
	JMenuItem exit = null;
    Manager manager = null;
public managerinforGUI(User user,personalinfor person) {
	super("维护系统");
	     this.user = user;
	     this.person = person;
	    desktoppane = new JDesktopPane();
	    desktoppane.setBackground(Color.getColor("#cccccc"));
	    this.setSize(600, 550);
		this.setLocation(700, 200);
		this.getContentPane().add(desktoppane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menubar= new JMenuBar();

		student = new JMenu("学生管理");
		admin = new JMenu("管理员管理");
		ordermenu = new JMenu("订单管理");
		exits = new JMenu("系统");

		addstu = new JMenuItem("添加学生");
		addstu.addActionListener(new addstuEvent());

		alterstu = new JMenuItem("修改学生");
		alterstu.addActionListener(new alterstuEvent());

		delstu = new JMenuItem("删除学生");
		delstu.addActionListener(new delstuEvent());

		checkstu = new JMenuItem("查询学生");
		checkstu.addActionListener(new checkstuEvent());
		
		addadm = new JMenuItem("添加管理员");
		addadm.addActionListener(new addadmEvent());

		alteradm = new JMenuItem("修改管理员");
		alteradm.addActionListener(new alteradmEvent());

		deladm = new JMenuItem("删除管理员");
		deladm.addActionListener(new deladmEvent());

		checkadm = new JMenuItem("查询管理员");
		checkadm.addActionListener(new checkadmEvent());
		

		query = new JMenuItem("查询订单");
		query.addActionListener(new queryEvent());

		exit = new JMenuItem("退出");
		exit.addActionListener(new exitEvent());

		student.add(addstu);
		student.add(alterstu);
		student.add(delstu);
		student.add(checkstu);
		
		admin.add(addadm);
		admin.add(alteradm);
		admin.add(deladm);
		admin.add(checkadm);

		ordermenu.add(query);
		
		exits.add(exit);

		menubar.add(student);
		menubar.add(admin);
		menubar.add(ordermenu);
		menubar.add(exits);

		this.setJMenuBar(menubar);
		this.setVisible(true);
}
class addstuEvent implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		if (!addscopend) {

			addscopend = true;
			final JInternalFrame addscInerF = new addStudentInter("添加学生",
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

class alterstuEvent implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		if (!modifyscopend) {

			modifyscopend = true;
			final JInternalFrame delestu = new alterStudentInter("修改学生",
					false, true, false);
			delestu.addInternalFrameListener(new InternalFrameAdapter() {

				public void internalFrameClosed(InternalFrameEvent arg0) {
					modifyscopend = false;
				}
			});
			desktoppane.add(delestu);
		}
		
	}
}

class delstuEvent implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		if (!delcopend) {
			delcopend = true;
			final JInternalFrame delcInerF = new deleteStudentInter("删除学生", false,
					true, false);
			delcInerF.addInternalFrameListener(new InternalFrameAdapter() {

				public void internalFrameClosed(InternalFrameEvent arg0) {
					delcopend = false;
				}
			});
			desktoppane.add(delcInerF);
		} 
		
	}
}

class exitEvent implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {

		System.exit(0);
	}
}

class checkstuEvent implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		if (!checkcopend) {
			checkcopend = true;
			final JInternalFrame checkcInerF = new queryStudentInter("查询学生",
					false, true, false);
			checkcInerF
					.addInternalFrameListener(new InternalFrameAdapter() {

						public void internalFrameClosed(
								InternalFrameEvent arg0) {
							checkcopend = false;
						}
					});
			desktoppane.add(checkcInerF);
		}
		
	}
}

class addadmEvent implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		if (!addscopend) {

			addscopend = true;
			final JInternalFrame addAdmin = new addStudentInter("添加管理员",
					false, true, false);
			addAdmin.addInternalFrameListener(new InternalFrameAdapter() {

				public void internalFrameClosed(InternalFrameEvent arg0) {
					addscopend = false;
				}
			});
			desktoppane.add(addAdmin);
		}
		
		
	}
}

class alteradmEvent implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		if (!modifyscopend) {

			modifyscopend = true;
			final JInternalFrame alterAdmin = new alterStudentInter("修改管理员",
					false, true, false);
			alterAdmin.addInternalFrameListener(new InternalFrameAdapter() {

				public void internalFrameClosed(InternalFrameEvent arg0) {
					modifyscopend = false;
				}
			});
			desktoppane.add(alterAdmin);
		}
		
	}
}

class deladmEvent implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		if (!delcopend) {
			delcopend = true;
			final JInternalFrame delcInerF = new deleteStudentInter("删除课程", false,
					true, false);
			delcInerF.addInternalFrameListener(new InternalFrameAdapter() {

				public void deleteAdminInter(InternalFrameEvent arg0) {
					delcopend = false;
				}
			});
			desktoppane.add(delcInerF);
		} 
		
	}
}

class checkadmEvent implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		if (!checkcopend) {
			checkcopend = true;
			final JInternalFrame checkcInerF = new queryAdminInter("查询学生",
					false, true, false);
			checkcInerF
					.addInternalFrameListener(new InternalFrameAdapter() {

						public void internalFrameClosed(
								InternalFrameEvent arg0) {
							checkcopend = false;
						}
					});
			desktoppane.add(checkcInerF);
		}
		
	}
}

class queryEvent implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {

		System.exit(0);
	}
}

}

