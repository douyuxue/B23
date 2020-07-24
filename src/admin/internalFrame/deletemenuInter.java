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

import admin.getinfor.mysql.adminmenuDao;
import admin.mybean.model.Menu;

public class deletemenuInter  extends JInternalFrame{
       public deletemenuInter(String title, boolean resizable, boolean closable,
   			boolean maximizable) {
   		super(title, resizable, closable, maximizable);
   		this.setSize(250, 250);
   		
   		final adminmenuDao menudao = new adminmenuDao();
   		
   		JPanel jp = new JPanel();
   		
   		JLabel menuid = new JLabel("�˵���:");
		final JTextField menuids = new JTextField(10);
		
		JLabel menuname = new JLabel("�γ���:");
		final JTextField menunames = new JTextField(15);
		menunames.setEditable(false);//���ɱ༭
		
		final JButton queding = new JButton("ȷ��");
		queding.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (menuids.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "�˵��Ų���Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					menuids.requestFocus();
				} else {
					if(menudao.hasTheMenu(menuids.getText())){
						Menu menu = null;
						try {
							menu = menudao.getMenuByNo(menuids.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						menunames.setText(menu.getMenu_name());
					}else{
						JOptionPane.showMessageDialog(null, "�ò��������ڣ�", "����",
								JOptionPane.WARNING_MESSAGE);
						menuids.setText("");
						menunames.setText("");
						menuids.requestFocus();
					}
				}
			}

		});
		
		JButton okb = new JButton("ɾ��");
		okb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (menuids.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "�˵��Ų���Ϊ�գ�", "����",
							JOptionPane.WARNING_MESSAGE);
					menuids.requestFocus();
				} else {
					if(!menudao.hasTheMenu(menuids.getText())){
						JOptionPane.showMessageDialog(null, "�ò˵������ڣ�", "����",
								JOptionPane.WARNING_MESSAGE);
						menuids.setText("");
						menunames.setText("");
						menuids.requestFocus();
					}else{
						try {
							if(menudao.delMenu(menuids.getText())){
								JOptionPane.showMessageDialog(null, "ɾ���ɹ���", "����",
										JOptionPane.INFORMATION_MESSAGE);
								menuids.setText("");
								menunames.setText("");
								menuids.requestFocus();
							}else{
								JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�", "����",
										JOptionPane.INFORMATION_MESSAGE);
								menuids.setText("");
								menunames.setText("");
								menuids.requestFocus();
							}
						} catch (HeadlessException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}

		});
		

		JButton cancelb = new JButton("ȡ��");
		cancelb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				deletemenuInter.this.dispose();
			}

		});

		jp.add(menuid);
		jp.add(menuids);
		jp.add(queding);
		jp.add(menuname);
		jp.add(menunames);
		jp.add(okb);
		jp.add(cancelb);

		this.add(jp);

		this.setVisible(true);
       }
}
