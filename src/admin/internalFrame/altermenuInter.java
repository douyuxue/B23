package admin.internalFrame;

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
import admin.mybean.model.Menu;

public class altermenuInter extends JInternalFrame{
	public altermenuInter (String title, boolean resizable, boolean closable,
			boolean maximizable) {

		super(title, resizable, closable, maximizable);
		this.setSize(250, 150);

		final adminmenuDao menudao = new adminmenuDao();

		JPanel jp = new JPanel();

		JLabel menuno = new JLabel("�˵���:");
		final JTextField menunos = new JTextField(10);

		JLabel menuname = new JLabel("�˵���:");
		final JTextField menunames = new JTextField(15);

		final JButton queding = new JButton("ȷ��");
		queding.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (menunos.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "�˵��Ų���Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					menunos.requestFocus();
				} else {
					if (!menudao.hasTheMenu(menunos.getText())) {
						JOptionPane.showMessageDialog(null, "�ò��������ڣ�", "����",
								JOptionPane.WARNING_MESSAGE);
						menunos.setText("");
						menunames.setText("");
						menunos.requestFocus();
					} else {
						Menu menu = null;
						try {
							menu = menudao.getMenuByNo(menunos.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						menunames.setText(menu.getMenu_name());
					}
				}
			}

		});
		
		JButton okb = new JButton("�޸�");
		okb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (menunos.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "�˵��Ų���Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					menunos.requestFocus();
				} else {
					if (menunames.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "�˵�������Ϊ�գ�", "����",
								JOptionPane.WARNING_MESSAGE);
						menunames.requestFocus();
					} else {
						if(!menudao.hasTheMenu(menunos.getText())){
							JOptionPane.showMessageDialog(null, "�ò˵������ڣ�", "����",
									JOptionPane.WARNING_MESSAGE);
							menunos.setText("");
							menunames.setText("");
							menunos.requestFocus();
						}else{
							Menu menu = new Menu();
							menu.setMenu_id(Integer.parseInt(menunos.getText()));
							menu.setMenu_name(menunames.getText());
							
							if(menudao.modifyMenu(menu)){
								JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "ע��",
										JOptionPane.INFORMATION_MESSAGE);
								menunos.setText("");
								menunames.setText("");
								menunos.requestFocus();
							}else{
								JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�", "ע��",
										JOptionPane.INFORMATION_MESSAGE);
								menunos.setText("");
								menunames.setText("");
								menunos.requestFocus();
							}
						}
					}
				}

			}
		});
		JButton cancelb = new JButton("ȡ��");
		cancelb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				altermenuInter.this.dispose();
			}

		});

		jp.add(menuno);
		jp.add(menunos);
		jp.add(queding);
		jp.add(menuname);
		jp.add(menunames);

		jp.add(okb);
		jp.add(cancelb);

		this.add(jp);

		this.setVisible(true);

	}
}
