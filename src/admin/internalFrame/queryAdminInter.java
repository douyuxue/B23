package admin.internalFrame;

import java.awt.BorderLayout;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import admin.getinfor.mysql.managerBYadminDao;
import admin.mybean.model.Admin;
import admin.mybean.model.student;
import admin.table.model.Table_Model_M;
import admin.table.model.Table_model_a;

public class queryAdminInter  extends JInternalFrame {
      public queryAdminInter (String title, boolean resizable, boolean closable,
  			boolean maximizable) {
    	  
    	  super(title, resizable, closable, maximizable);
  		this.setSize(560, 400);
    	
  		JPanel	jp = new JPanel();
    	 JScrollPane s_pan = null;
 		final Table_model_a model = new Table_model_a(20);
 		final JTable table = new JTable();
 		//final JTable table = new JTable();
 		s_pan = new JScrollPane(table);
  		
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
  		
  		final JButton shanchu = new JButton("删除");
  		shanchu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				model.removeRows(0, model.getRowCount());
				table.updateUI();

				List list = null;
				final managerBYadminDao dao = new managerBYadminDao();
				if(anos.getText().length() == 0){
					if(anames.getText().length() == 0){
						try {
							list = dao.getAllAdmin();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else{
						try {
							list = dao.getAdminByAdminname(anames.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}else{
					if(anames.getText().length() == 0){
						try {
							list = dao.getAdminByAno(anos.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

				Admin admin = null;
				for (int i = 0; i < list.size(); i++) {
					admin = (Admin)list.get(i);
					model.addRow(admin.getA_no(),admin.getA_name(),admin.getA_phone(),admin.getA_workplace());
				}
				table.updateUI();

				anos.setText("");
				anames.setText("");

			}

		}

		);

		jp.add(ano);
		jp.add(anos);
		jp.add(aname);
		jp.add(anames);
		jp.add(shanchu);

		this.getContentPane().add(s_pan, BorderLayout.CENTER);
		this.getContentPane().add(jp, BorderLayout.NORTH);

		this.setVisible(true);

    	  
    	  
      }
}
