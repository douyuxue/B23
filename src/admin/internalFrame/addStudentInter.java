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
		
		JLabel  stuno = new JLabel ("学号：");
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
		
		JLabel  stuname = new JLabel ("姓名：");
		final JTextField stunames = new JTextField(12);
		
		JLabel stuage = new JLabel ("年龄：");
		final JTextField stuages = new JTextField(12);
		
		JLabel stuphone = new JLabel ("电话：");
		final JTextField stuphones = new JTextField(12);
		
		JLabel stuschool = new JLabel ("学校：");
		final JTextField stuschools = new JTextField(12);
		
		Button tianjia  = new Button("添加");
		tianjia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (stunos.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "学号不能为空！", "警告",
						JOptionPane.WARNING_MESSAGE);
				stunos.requestFocus();
			} else {
				if (stunames.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "姓名不能为空！", "警告",
							JOptionPane.WARNING_MESSAGE);
					stunames.requestFocus();
				} else {
					if (stuages.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "年龄不能为空！",
								"警告", JOptionPane.WARNING_MESSAGE);
						stuages.requestFocus();
					} else {
						if (stuphones.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "电话不能为空！",
									"警告", JOptionPane.WARNING_MESSAGE);
							stuphones.requestFocus();
						} else {
							if (stuschools.getText().length() == 0) {
								JOptionPane.showMessageDialog(null,
										"学校不能为空！", "警告",
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
															"添加成功！",
															"警告",
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
															"该学生已经存在，添加失败！",
															"警告",
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
											"年龄不能包含非法字符！", "警告",
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
		
		JButton cancelb = new JButton("取消");
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
