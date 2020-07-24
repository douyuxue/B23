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
		
		JLabel  menuno = new JLabel ("添加菜单号：");
		final JTextField menunos = new JTextField(12);
		
		JLabel  menuname = new JLabel ("添加菜单名：");
		final JTextField menunames = new JTextField(12);
		
		JLabel  menuprice = new JLabel ("添加菜单价格：");
		final JTextField menuprices = new JTextField(12);
		
		Button tianjia  = new Button("确定");
		
		tianjia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(menunos.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "菜单号不能为空！", "注意",
							JOptionPane.WARNING_MESSAGE);
					menunos.requestFocus();
			}else {
				if(menunames.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "菜单名不能为空不能为空！", "注意",
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
							JOptionPane.showMessageDialog(null, "记录插入成功！", "",
									JOptionPane.INFORMATION_MESSAGE);
							menunos.setText(adminme.getMaxCno());
							menunames.setText("");
							menunames.requestFocus();
						}else {
							JOptionPane.showMessageDialog(null, "记录插入失败！", "",
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
		
		JButton cancelb = new JButton("取消");
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
