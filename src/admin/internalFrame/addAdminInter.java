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

import admin.getinfor.mysql.managerBYadminDao;
import admin.mybean.model.Admin;

public class addAdminInter  extends JInternalFrame {
	public  addAdminInter(String title, boolean resizable,boolean closable,
			boolean maximizable) {
		super(title, resizable, closable, maximizable);
		this.setSize(250, 200);
		
JPanel	jp = new JPanel();
		
		JLabel  ano = new JLabel ("工号：");
		final JTextField anos = new JTextField(12);
		
		final managerBYadminDao admindao = new managerBYadminDao();
		String sno = null;
		try {
			sno = admindao.getMaxCno();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		anos.setText(sno);
		
		JLabel  aname = new JLabel ("姓名：");
		final JTextField anames = new JTextField(12);
		
		JLabel aphone = new JLabel ("电话：");
		final JTextField aphones = new JTextField(12);
		
		JLabel workplace = new JLabel ("学校：");
		final JTextField workplaces = new JTextField(12);
		
		Button tianjia  = new Button("添加");
		tianjia.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (anos.getText().length() == 0) {
				JOptionPane.showMessageDialog(null, "学号不能为空！", "警告",
						JOptionPane.WARNING_MESSAGE);
				anos.requestFocus();
			} else {
				if (anames.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "姓名不能为空！", "警告",
							JOptionPane.WARNING_MESSAGE);
					anames.requestFocus();
				} else {
					if (aphones.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "电话号码不能为空！",
								"警告", JOptionPane.WARNING_MESSAGE);
						aphones.requestFocus();
					} else {
						if (workplaces.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "工作地点不能为空！",
									"警告", JOptionPane.WARNING_MESSAGE);
							workplaces.requestFocus();
						}  else {          

								Admin admin = new Admin();             

								try {
									admin.setA_no(anos.getText());
									admin.setA_name(anames.getText());
									admin.setA_phone(aphones.getText());
									admin.setA_workplace(workplaces.getText());
									
									try {
										if (admindao.addAdmin(admin)) {
											JOptionPane
													.showMessageDialog(
															null,
															"添加成功！",
															"警告",
															JOptionPane.INFORMATION_MESSAGE);
											try {
												anos.setText(admindao.getMaxCno());
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											anos.getText();
											anames.setText("");
											aphones.setText("");
											workplaces.setText("");

										} else {
											JOptionPane
													.showMessageDialog(
															null,
															"该管理员已经存在，添加失败！",
															"警告",
															JOptionPane.WARNING_MESSAGE);
											try {
												anos.setText(admindao.getMaxCno());
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
				addAdminInter.this.dispose();
			}
		});
		
		jp.add(ano);
		jp.add(anos);
		jp.add(aname);
		jp.add(anames);
		jp.add(aphone);
		jp.add(aphones);
		jp.add(workplace);
		jp.add(workplaces);
		
		jp.add(tianjia);
		jp.add(cancelb);
		
		this.add(jp);

		this.setVisible(true);
		
	}

}
