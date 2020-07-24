package admin.internalFrame;

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
import admin.mybean.model.student;

public class deleteAdminInter extends JInternalFrame {
	public deleteAdminInter(String title, boolean resizable, boolean closable,
			boolean maximizable) {
		super(title, resizable, closable, maximizable);
		this.setSize(250, 250);
		
		JPanel	jp = new JPanel();
		final managerBYadminDao admindao = new managerBYadminDao();
		
		JLabel  ano = new JLabel ("工号：");
		final JTextField anos = new JTextField(12);
		
		JLabel  aname = new JLabel ("姓名：");
		final JTextField anames = new JTextField(12);
		anames.setEditable(false);
		
		JLabel aphone = new JLabel ("电话：");
		final JTextField aphones = new JTextField(12);
		aphones.setEditable(false);
		
		JLabel workplace = new JLabel ("工作地点：");
		final JTextField workplaces= new JTextField(12);
		workplaces.setEditable(false);
		
		final JButton queding = new JButton("删除");
		queding.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (anos.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "工号不能为空！", "警告",
							JOptionPane.WARNING_MESSAGE);
					anos.requestFocus();
				} else {
					if (!admindao.hasTheAdmin(anos.getText())) {
						JOptionPane.showMessageDialog(null, "该学生不存在！", "警告",
								JOptionPane.WARNING_MESSAGE);
						anos.setText("");
						anames.setText("");
						aphones.setText("");
						workplaces.setText("");
						anos.requestFocus();
					} else {
						Admin admin = null;
						try {
							admin =  admindao.getAdminByNo(anos.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						anames.setText(admin.getA_name());
						aphones.setText(admin.getA_phone());
						workplaces.setText(admin.getA_workplace());

					}
				}
			}

		});

		JButton okb = new JButton("删除");
		okb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (anos.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "工号不能为空！", "警告",
							JOptionPane.WARNING_MESSAGE);
					anos.requestFocus();
				} else {

					student s = new student();

					try {
						if (admindao.delAdmin(anos.getText())) {
							JOptionPane.showMessageDialog(null, "删除成功！", "注意",
									JOptionPane.INFORMATION_MESSAGE);
							anos.getText();
							anames.setText("");
							aphones.setText("");
							workplaces.setText("");

						} else {
							JOptionPane.showMessageDialog(null, "删除失败！", "警告",
									JOptionPane.WARNING_MESSAGE);
							try {
								anos.setText(admindao.getMaxCno());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});

		JButton cancelb = new JButton("取消");
		cancelb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				deleteAdminInter.this.dispose();
			}

		});

		jp.add(ano);
		jp.add(anos);
		jp.add(queding);
		jp.add(aname);
		jp.add(anames);
		jp.add(aphone);
		jp.add(aphones);
		jp.add(workplace);
		jp.add(workplaces);
		
		jp.add(okb);
		jp.add(cancelb);

		this.add(jp);

		this.setVisible(true);
		
		
		
	}

}
