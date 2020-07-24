package admin.internalFrame;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import admin.getinfor.mysql.managerStudentDao;
import admin.mybean.model.student;

public class alterStudentInter  extends JInternalFrame  {
	public alterStudentInter(String title, boolean resizable, boolean closable,
			boolean maximizable) {
		
		super(title, resizable, closable, maximizable);
		this.setSize(250, 250);
		
		final managerStudentDao studentdao = new managerStudentDao();

		JPanel jp = new JPanel();

		JLabel  stuno = new JLabel ("学号：");
		final JTextField stunos = new JTextField(12);
		
		JLabel  stuname = new JLabel ("姓名：");
		final JTextField stunames = new JTextField(12);
		
		JLabel stuage = new JLabel ("年龄：");
		final JTextField stuages = new JTextField(12);
		
		JLabel stuphone = new JLabel ("电话：");
		final JTextField stuphones = new JTextField(12);
		
		JLabel stuschool = new JLabel ("学校：");
		final JTextField stuschools = new JTextField(12);
		
		Button queding  = new Button("修改");
		queding.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(stunos.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "学号不能为空！", "警告",
							JOptionPane.WARNING_MESSAGE);
					stunos.requestFocus();
				}else{
					if(!studentdao.hasTheStudent(stunos.getText())){
						JOptionPane.showMessageDialog(null, "该学生不存在！", "警告",
								JOptionPane.WARNING_MESSAGE);
						stunos.getText();
						stunames.setText("");
						stuages.setText("");
						stuphones.setText("");
						stuschools.setText("");
						stunos.requestFocus();

					}else{
						student stu= null;
						try {
							stu = studentdao.getMenuByNo(stunos.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						stunames.setText(stu.getSname());
						stuages.setText(String.valueOf(stu.getSage()));
						stuphones.setText(stu.getSphone());
						stuschools.setText(stu.getSschool());
						
					}
				}
			}
			
		});
		
		

		JButton okb = new JButton("修改");
		okb.addActionListener(new ActionListener() {

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
											"地址不能为空！", "警告",
											JOptionPane.WARNING_MESSAGE);
									stuschools.requestFocus();
								} else {

									student s = new student();
									try {
										if(studentdao.hasTheStudent(stunos.getText())){
											s.setSno(Integer.parseInt(stunos.getText()));
											s.setSname(stunames.getText());
											s.setSage(Integer.parseInt(stuages.getText()));
											s.setSphone(stuphones.getText());
											s.setSschool(stuschools.getText());

											if (studentdao.modifyStudent(s)) {
												JOptionPane
														.showMessageDialog(
																null,
																"修改成功！",
																"注意",
																JOptionPane.INFORMATION_MESSAGE);
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
																"主键冲突，修改失败！",
																"警告",
																JOptionPane.WARNING_MESSAGE);
												stunos.setText(studentdao.getMaxCno());
											}
										}else{
											JOptionPane
											.showMessageDialog(
													null,
													"无此学生！",
													"警告",
													JOptionPane.WARNING_MESSAGE);
											stunos.getText();
											stunames.setText("");
											stuages.setText("");
											stuphones.setText("");
											stuschools.setText("");
											stunos.requestFocus();
										}
									} catch (NumberFormatException nfe) {
										JOptionPane.showMessageDialog(null,
												"年龄不能包含非法字符！", "警告",
												JOptionPane.WARNING_MESSAGE);
										stuages.setText("");
										stuages.requestFocus();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
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
				alterStudentInter.this.dispose();
			}

		});

		jp.add(stuno);
		jp.add(stunos);
		jp.add(queding);
		jp.add(stuname);
		jp.add(stunames);
		jp.add(stuage);
		jp.add(stuages);
		jp.add(stuphone);
		jp.add(stuphones);
		jp.add(stuschool);
		jp.add(stuschools);
		jp.add(okb);
		jp.add(cancelb);

		this.add(jp);

		this.setVisible(true);
	}
}
