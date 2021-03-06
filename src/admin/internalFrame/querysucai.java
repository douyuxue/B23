package admin.internalFrame;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import admin.getinfor.mysql.adminmenuDao;
import admin.mybean.model.Menu;
import admin.table.model.Table_Model_M;
import admin.table.model.Table_sucai_model;

public class querysucai extends JInternalFrame {
	public querysucai(String title, boolean resizable, boolean closable,
			boolean maximizable) {

		super(title, resizable, closable, maximizable);
		this.setSize(500, 300);

		JPanel jp = new JPanel();
		JScrollPane s_pan = null;
		final Table_sucai_model model = new Table_sucai_model(20);
		final JTable table = new JTable(model);
		s_pan = new JScrollPane(table);

		JLabel menuno = new JLabel("�˵���:");
		final JTextField menunos = new JTextField(10);
		
		JLabel menuname = new JLabel("      �˵���:");
		final JTextField menunames = new JTextField(10);
		
		JButton okb = new JButton("��ѯ");
		okb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				model.removeRows(0, model.getRowCount());
				table.updateUI();

				List list = null;
				adminmenuDao menudao = new adminmenuDao();
				if(menunos.getText().length() == 0){
					if(menunames.getText().length() == 0){
						try {
							list = menudao.getAllsucai();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else{
						try {
							list = menudao.getMenuBysucainame(menunames.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}else{
					if(menunames.getText().length() == 0){
						try {
							list = menudao.getMenusucaiByMno(menunos.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				Menu menu = null;
				for (int i = 0; i < list.size(); i++) {
					menu = (Menu) list.get(i);
					model.addRow(String.valueOf(menu.getMenu_id()),menu.getMenu_name(),String.valueOf(menu.getMenu_price()));
				}
				table.updateUI();

				menunos.setText("");
				menunames.setText("");

			}

		}

		);

		jp.add(menuno);
		jp.add(menunos);
		jp.add(menuname);
		jp.add(menunames);
		jp.add(okb);

		this.getContentPane().add(s_pan, BorderLayout.CENTER);
		this.getContentPane().add(jp, BorderLayout.NORTH);

		this.setVisible(true);
		

	}

}
