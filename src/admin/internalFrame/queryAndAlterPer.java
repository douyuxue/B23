package admin.internalFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import admin.getinfor.mysql.personaoDao;
import admin.mybean.model.personalinfor;

public class queryAndAlterPer extends JInternalFrame{
	public queryAndAlterPer(String title, boolean resizable, boolean closable,
			boolean maximizable,personalinfor person){
		
		super(title, resizable, closable, maximizable);
		this.setSize(500, 300);
		
        final personaoDao pm = new personaoDao();
		
		JPanel jp = new JPanel();
		
		JLabel namel = new JLabel("��        ��:");
		final JTextField namet = new JTextField(15);
		namet.setEditable(false);
		
		JLabel nomber = new JLabel("��      ��:");
		final JTextField nombert = new JTextField(15);
		
		JLabel phone = new JLabel("�绰����:");
		final JTextField phonet = new JTextField(15);
		
		JLabel place = new JLabel("����ѧУ:");
		final JTextField placet = new JTextField(15);
		
        JButton okb = new JButton("�޸�");
        okb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (namet.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "��������Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					namet.requestFocus();
				} else {
					if (nombert.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ�գ�", "����",
								JOptionPane.WARNING_MESSAGE);
						nombert.requestFocus();
					} else {
						if (phonet.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "�������ڲ���Ϊ�գ�",
									"����", JOptionPane.WARNING_MESSAGE);
							phonet.requestFocus();
						} else {
							if (placet.getText().length() == 0) {
								JOptionPane.showMessageDialog(null, "�绰����Ϊ�գ�",
										"����", JOptionPane.WARNING_MESSAGE);
								placet.requestFocus();
							}else {

								personalinfor p = new personalinfor();
									try {
										if(pm.hasPersonal(namet.getText())){
											p.setUsername(namet.getText());
											p.setUsernomber(nombert.getText());
											p.setUserphone(phonet.getText());
											p.setUserplace(placet.getText());
											
											if (pm.alterPersonal(p)) {
												JOptionPane
														.showMessageDialog(
																null,
																"�޸ĳɹ���",
																"��ʾ",
																JOptionPane.INFORMATION_MESSAGE);
												

											} 
											else{
												JOptionPane.showMessageDialog(null,
														"�޸�ʧ�ܣ�", "����",
														JOptionPane.WARNING_MESSAGE);
											}
										}
									}
										

									catch (NumberFormatException nfe) {
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
				queryAndAlterPer.this.dispose();
			}

		});
		namet.setText(person.getUsername());
		nombert.setText(person.getUsernomber());
		phonet.setText(person.getUserphone());
        placet.setText(person.getUserplace());		
		
		jp.add(namel);
		jp.add(namet);
		jp.add(nomber);
		jp.add(nombert);
		jp.add(phone);
		jp.add(phonet);
		jp.add(place);
		jp.add(placet);
		jp.add(okb);
		jp.add(cancelb);
		
		add(jp);
		setVisible(true);
		
	}

	
	

}
