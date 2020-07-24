package admin.internalFrame;

import java.awt.Button;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import admin.getinfor.mysql.adminmenuDao;
import admin.getinfor.mysql.managerStudentDao;
import admin.mybean.model.Menu;
import admin.mybean.model.student;

public class addStudentInter  extends JInternalFrame{
	public addStudentInter(String title, boolean resizable, boolean closable,
			boolean maximizable) {
		super(title, resizable, closable, maximizable);
		this.setSize(250, 200);
		
    	JPanel	jp = new JPanel();
		
		JLabel  stuno = new JLabel ("ѧ�ţ�");
		final JTextField stunos = new JTextField(12);
		
		final managerStudentDao studentdao = new managerStudentDao();
		String sno = null;
		try {
			sno = studentdao.getMaxCno();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		stunos.setText(sno);
		
		JLabel  stuname = new JLabel ("������");
		final JTextField stunames = new JTextField(12);
		
		JLabel stuage = new JLabel ("���䣺");
		final JTextField stuages = new JTextField(12);
		
		JLabel stuphone = new JLabel ("�绰��");
		final JTextField stuphones = new JTextField(12);
		
		JLabel stuschool = new JLabel ("ѧУ��");
		final JTextField stuschools = new JTextField(12);
		
		Button tianjia  = new Button("���");
		tianjia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (stunos.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ�գ�", "����",
						JOptionPane.WARNING_MESSAGE);
				stunos.requestFocus();
			} else {
				if (stunames.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "��������Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					stunames.requestFocus();
				} else {
					if (stuages.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "���䲻��Ϊ�գ�",
								"����", JOptionPane.WARNING_MESSAGE);
						stuages.requestFocus();
					} else {
						if (stuphones.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "�绰����Ϊ�գ�",
									"����", JOptionPane.WARNING_MESSAGE);
							stuphones.requestFocus();
						} else {
							if (stuschools.getText().length() == 0) {
								JOptionPane.showMessageDialog(null,
										"ѧУ����Ϊ�գ�", "����",
										JOptionPane.WARNING_MESSAGE);
								stuschools.requestFocus();
							} else {          

								student stu = new student();               

								try {
									stu.setSno(Integer.parseInt(stunos.getText()));
									stu.setSname(stunames.getText());
									stu.setSage(Integer.parseInt(stuages.getText()));
									stu.setSphone(stuphones.getText());
									stu.setSschool(stuschools.getText());
									
									try {
										if (studentdao.addStudent(stu)) {
											JOptionPane
													.showMessageDialog(
															null,
															"��ӳɹ���",
															"����",
															JOptionPane.INFORMATION_MESSAGE);
											try {
												stunos.setText(studentdao.getMaxCno());
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											stunos.getText();
											stunames.setText("");
											stuages.setText("");
											stuphones.setText("");
											stuschools.setText("");
											stunos.requestFocus();

										} else {
											JOptionPane
													.showMessageDialog(
															null,
															"��ѧ���Ѿ����ڣ����ʧ�ܣ�",
															"����",
															JOptionPane.WARNING_MESSAGE);
											try {
												stunos.setText(studentdao.getMaxCno());
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}
									} catch (HeadlessException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

								} catch (NumberFormatException nfe) {
									JOptionPane.showMessageDialog(null,
											"���䲻�ܰ����Ƿ��ַ���", "����",
											JOptionPane.WARNING_MESSAGE);
									stuages.setText("");
									stuages.requestFocus();
								}
							}
						}
					}
				}
			}
		}

	});
		
		JButton cancelb = new JButton("ȡ��");
		cancelb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudentInter.this.dispose();
			}
		});
		
		jp.add(stuno);
		jp.add(stunos);
		jp.add(stuname);
		jp.add(stunames);
		jp.add(stuage);
		jp.add(stuages);
		jp.add(stuphone);
		jp.add(stuphones);
		jp.add(stuschool);
		jp.add(stuschools);
		jp.add(tianjia);
		jp.add(cancelb);
		
		this.add(jp);

		this.setVisible(true);

	
	
		}

}
