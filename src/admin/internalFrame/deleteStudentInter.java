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

import admin.getinfor.mysql.managerStudentDao;
import admin.mybean.model.student;

public class deleteStudentInter extends JInternalFrame {
	public deleteStudentInter(String title, boolean resizable, boolean closable,
			boolean maximizable) {

		super(title, resizable, closable, maximizable);
		this.setSize(250, 250);

	JPanel	jp = new JPanel();
	final managerStudentDao studentdao = new managerStudentDao();
		
		JLabel  stuno = new JLabel ("ѧ�ţ�");
		final JTextField stunos = new JTextField(12);
		
		JLabel  stuname = new JLabel ("������");
		final JTextField stunames = new JTextField(12);
		stunames.setEditable(false);
		
		JLabel stuage = new JLabel ("���䣺");
		final JTextField stuages = new JTextField(12);
		stuages.setEditable(false);
		
		JLabel stuphone = new JLabel ("�绰��");
		final JTextField stuphones = new JTextField(12);
		stuphones.setEditable(false);
		
		JLabel stuschool = new JLabel ("ѧУ��");
		final JTextField stuschools = new JTextField(12);
		stuschools.setEditable(false);
		
		final JButton queding = new JButton("ȷ��");
		queding.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (stunos.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					stunos.requestFocus();
				} else {
					if (!studentdao.hasTheStudent(stunos.getText())) {
						JOptionPane.showMessageDialog(null, "��ѧ�������ڣ�", "����",
								JOptionPane.WARNING_MESSAGE);
						stunos.setText("");
						stunames.setText("");
						stuages.setText("");
						stuphones.setText("");
						stuschools.setText("");
						stunos.requestFocus();
					} else {
						student s1 = null;
						try {
							s1 = studentdao.getMenuByNo(stunos.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						stunames.setText(s1.getSname());
						stuages.setText(String.valueOf(s1.getSage()));
						stuphones.setText(s1.getSphone());
						stuschools.setText(s1.getSschool());

					}
				}
			}

		});

		JButton okb = new JButton("ɾ��");
		okb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (stunos.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					stunos.requestFocus();
				} else {

					student s = new student();

					try {
						if (studentdao.delstudent(stunos.getText())) {
							JOptionPane.showMessageDialog(null, "ɾ���ɹ���", "ע��",
									JOptionPane.INFORMATION_MESSAGE);
							stunos.setText("");
							stunames.setText("");
							stuages.setText("");
							stuphones.setText("");
							stuschools.setText("");
							stunos.requestFocus();

						} else {
							JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�", "����",
									JOptionPane.WARNING_MESSAGE);
							try {
								stunos.setText(studentdao.getMaxCno());
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

		JButton cancelb = new JButton("ȡ��");
		cancelb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				deleteStudentInter.this.dispose();
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
