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
	super("ά��ϵͳ");
	     this.user = user;
	     this.person = person;
	    desktoppane = new JDesktopPane();
	    desktoppane.setBackground(Color.getColor("#cccccc"));
	    this.setSize(600, 550);
		this.setLocation(700, 200);
		this.getContentPane().add(desktoppane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menubar= new JMenuBar();

		student = new JMenu("ѧ������");
		admin = new JMenu("����Ա����");
		ordermenu = new JMenu("��������");
		exits = new JMenu("ϵͳ");

		addstu = new JMenuItem("���ѧ��");
		addstu.addActionListener(new addstuEvent());

		alterstu = new JMenuItem("�޸�ѧ��");
		alterstu.addActionListener(new alterstuEvent());

		delstu = new JMenuItem("ɾ��ѧ��");
		delstu.addActionListener(new delstuEvent());

		checkstu = new JMenuItem("��ѯѧ��");
		checkstu.addActionListener(new checkstuEvent());
		
		addadm = new JMenuItem("��ӹ���Ա");
		addadm.addActionListener(new addadmEvent());

		alteradm = new JMenuItem("�޸Ĺ���Ա");
		alteradm.addActionListener(new alteradmEvent());

		deladm = new JMenuItem("ɾ������Ա");
		deladm.addActionListener(new deladmEvent());

		checkadm = new JMenuItem("��ѯ����Ա");
		checkadm.addActionListener(new checkadmEvent());
		

		query = new JMenuItem("��ѯ����");
		query.addActionListener(new queryEvent());

		exit = new JMenuItem("�˳�");
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
			final JInternalFrame addscInerF = new addStudentInter("���ѧ��",
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
			final JInternalFrame delestu = new alterStudentInter("�޸�ѧ��",
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
			final JInternalFrame delcInerF = new deleteStudentInter("ɾ��ѧ��", false,
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
			final JInternalFrame checkcInerF = new queryStudentInter("��ѯѧ��",
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
			final JInternalFrame addAdmin = new addStudentInter("��ӹ���Ա",
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
			final JInternalFrame alterAdmin = new alterStudentInter("�޸Ĺ���Ա",
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
			final JInternalFrame delcInerF = new deleteStudentInter("ɾ���γ�", false,
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
			final JInternalFrame checkcInerF = new queryAdminInter("��ѯѧ��",
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

