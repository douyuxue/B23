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

import admin.getinfor.mysql.managerBYadminDao;
import admin.getinfor.mysql.managerStudentDao;
import admin.mybean.model.Admin;
import admin.mybean.model.student;

public class alterAdminInter  extends JInternalFrame{
	public alterAdminInter(String title, boolean resizable, boolean closable,
			boolean maximizable) {
		super(title, resizable, closable, maximizable);
		this.setSize(300, 300);
		
		final managerBYadminDao admindao = new managerBYadminDao();
		
		JPanel jp = new JPanel();

		JLabel  ano= new JLabel ("���ţ�");
		final JTextField anos = new JTextField(12);
		
		JLabel  aname = new JLabel ("������");
		final JTextField anames = new JTextField(12);
		
		JLabel aphone = new JLabel ("�绰��");
		final JTextField aphones = new JTextField(12);
		
		JLabel workplace= new JLabel ("ѧУ��");
		final JTextField workplaces = new JTextField(12);
		
		Button queding  = new Button("�޸�");
		queding.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(anos.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "���Ų���Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					anos.requestFocus();
				}else{
					if(!admindao.hasTheAdmin(anos.getText())){
						JOptionPane.showMessageDialog(null, "��Ա�������ڣ�", "����",
								JOptionPane.WARNING_MESSAGE);
						anos.getText();
						anames.setText("");
						aphones.setText("");
						workplaces.setText("");
						
					}else{
						Admin admin= null;
						try {
							admin = admindao.getAdminByNo(anos.getText());
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
		
		

		JButton okb = new JButton("�޸�");
		okb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (anos.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "���Ų���Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					anos.requestFocus();
				} else {
					if (anames.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "��������Ϊ�գ�", "����",
								JOptionPane.WARNING_MESSAGE);
						anames.requestFocus();
					} else {
						if (aphones.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "�绰����Ϊ�գ�",
									"����", JOptionPane.WARNING_MESSAGE);
							aphones.requestFocus();
						} else {
							if (workplaces.getText().length() == 0) {
								JOptionPane.showMessageDialog(null, "�����ص㲻��Ϊ�գ�",
										"����", JOptionPane.WARNING_MESSAGE);
								workplaces.requestFocus();
							}  else {

									Admin admin = new Admin();
									try {
										if(admindao.hasTheAdmin(anos.getText())){
											admin.setA_no(anos.getText());
											admin.setA_name(anames.getText());
											admin.setA_phone(aphones.getText());
											admin.setA_workplace(workplaces.getText());

											if (admindao.modifyAdmin(admin)) {
												JOptionPane
														.showMessageDialog(
																null,
																"�޸ĳɹ���",
																"ע��",
																JOptionPane.INFORMATION_MESSAGE);
												anos.getText();
												anames.setText("");
												aphones.setText("");
												workplaces.setText("");
												anos.requestFocus();
											} else {
												JOptionPane
														.showMessageDialog(
																null,
																"������ͻ���޸�ʧ�ܣ�",
																"����",
																JOptionPane.WARNING_MESSAGE);
												anos.setText(admindao.getMaxCno());
											}
										}else{
											JOptionPane
											.showMessageDialog(
													null,
													"�޴˹���Ա��",
													"����",
													JOptionPane.WARNING_MESSAGE);
											anos.getText();
											anames.setText("");
											aphones.setText("");
											workplaces.setText("");
											anos.requestFocus();
										}
									} catch (NumberFormatException nfe) {
										
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									
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
				alterAdminInter.this.dispose();
			}

		});

		jp.add(ano);
		jp.add(ano);
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
		this.setSize(300, 250);

		this.setVisible(true);
	}
}
