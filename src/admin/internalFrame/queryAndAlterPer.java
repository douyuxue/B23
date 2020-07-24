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
		
		JLabel namel = new JLabel("姓        名:");
		final JTextField namet = new JTextField(15);
		namet.setEditable(false);
		
		JLabel nomber = new JLabel("账      号:");
		final JTextField nombert = new JTextField(15);
		
		JLabel phone = new JLabel("电话号码:");
		final JTextField phonet = new JTextField(15);
		
		JLabel place = new JLabel("所属学校:");
		final JTextField placet = new JTextField(15);
		
        JButton okb = new JButton("修改");
        okb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (namet.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "姓名不能为空！", "警告",
							JOptionPane.WARNING_MESSAGE);
					namet.requestFocus();
				} else {
					if (nombert.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "账号不能为空！", "警告",
								JOptionPane.WARNING_MESSAGE);
						nombert.requestFocus();
					} else {
						if (phonet.getText().length() == 0) {
							JOptionPane.showMessageDialog(null, "出生日期不能为空！",
									"警告", JOptionPane.WARNING_MESSAGE);
							phonet.requestFocus();
						} else {
							if (placet.getText().length() == 0) {
								JOptionPane.showMessageDialog(null, "电话不能为空！",
										"警告", JOptionPane.WARNING_MESSAGE);
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
																"修改成功！",
																"提示",
																JOptionPane.INFORMATION_MESSAGE);
												

											} 
											else{
												JOptionPane.showMessageDialog(null,
														"修改失败！", "警告",
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

		
		JButton cancelb = new JButton("取消");
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
