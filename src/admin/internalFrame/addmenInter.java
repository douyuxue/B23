package admin.internalFrame;

import java.awt.Button;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import admin.getinfor.mysql.adminmenuDao;
import admin.mybean.model.Menu;
import admin.show.GUI.login;

public class addmenInter extends JInternalFrame {
	
	public addmenInter(String title, boolean resizable, boolean closable,
			boolean maximizable) {
		super(title, resizable, closable, maximizable);
		this.setSize(250, 200);
		
    	JPanel	jp = new JPanel();
		
		JLabel  menuno = new JLabel ("��Ӳ˵��ţ�");
		final JTextField menunos = new JTextField(12);
		
		JLabel  menuname = new JLabel ("��Ӳ˵�����");
		final JTextField menunames = new JTextField(12);
		
		JLabel  menuprice = new JLabel ("��Ӳ˵��۸�");
		final JTextField menuprices = new JTextField(12);
		
		Button tianjia  = new Button("ȷ��");
		
		tianjia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(menunos.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "�˵��Ų���Ϊ�գ�", "ע��",
							JOptionPane.WARNING_MESSAGE);
					menunos.requestFocus();
			}else {
				if(menunames.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "�˵�������Ϊ�ղ���Ϊ�գ�", "ע��",
							JOptionPane.WARNING_MESSAGE);
					menunames.requestFocus();
				}else {
					Menu menu = new Menu();
					adminmenuDao adminme = new adminmenuDao();
					menu.setMenu_id(Integer.parseInt(menunos.getText()));
					menu.setMenu_name(menunames.getText());
					menu.setMenu_price(Integer.parseInt(menuprices.getText()));
					
					
					try {
						if(adminme.addmenu(menu)) {
							JOptionPane.showMessageDialog(null, "��¼����ɹ���", "",
									JOptionPane.INFORMATION_MESSAGE);
							menunos.setText(adminme.getMaxCno());
							menunames.setText("");
							menunames.requestFocus();
						}else {
							JOptionPane.showMessageDialog(null, "��¼����ʧ�ܣ�", "",
									JOptionPane.INFORMATION_MESSAGE);
							menunos.setText(adminme.getMaxCno());
							menunames.setText("");
							menunames.requestFocus();
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
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
				addmenInter.this.dispose();
			}
		});
		
		jp.add(menuno);
		jp.add(menunos);
		jp.add(menuname);
		jp.add(menunames);
		jp.add(menuprice);
		jp.add(menuprices);
		jp.add(tianjia);
		jp.add(cancelb);
		
		this.add(jp);

		this.setVisible(true);

	
	
		}
}
