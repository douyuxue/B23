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

import admin.getinfor.mysql.managerStudentDao;
import admin.mybean.model.student;
import admin.table.model.Table_model_s;

public class queryStudentInter extends JInternalFrame {
	
      public queryStudentInter(String title, boolean resizable, boolean closable,
  			boolean maximizable) {

  		super(title, resizable, closable, maximizable);

  		this.setSize(560, 400);
  		
  		JPanel jp = new JPanel();
  		JScrollPane s_pan = null;
  		final Table_model_s model = new Table_model_s(20);
  		final JTable table = new JTable(model);
  		s_pan = new JScrollPane(table);

  		JLabel stuno= new JLabel("学生编号:");
  		final JTextField stunos = new JTextField(10);

  		JLabel stuname = new JLabel("      学生姓名:");
  		final JTextField stunames = new JTextField(10);

  		
  		JButton okb = new JButton("查询");
  		okb.addActionListener(new ActionListener() {

  			public void actionPerformed(ActionEvent e) {

  				model.removeRows(0, model.getRowCount());
  				table.updateUI();

  				List list = null;
  				managerStudentDao studentdao = new managerStudentDao();

  				if (stunos.getText().length() == 0) {
  					if(stunames.getText().length() == 0){
  						try {
							list = studentdao.getAllStudent();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
  					}else if(stunames.getText().length() != 0){
  						try {
							list = studentdao.getMenuByMno(stunames.getText());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
  					}

  				} else {
  					try {
						list = studentdao.getStuByStuname(stunos.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
  				}

  				student stu = null;
  				
  				for (int i = 0; i < list.size(); i++) {
  					stu = (student)list.get(i);
  					model.addRow(stu.getSno(), stu.getSname(), stu.getSage(), stu.getSphone(), stu.getSschool());
  				
  				}
  				
  				
  				table.updateUI();

  				stunos.setText("");
  				stunames.setText("");

  			}

  		}

  		);

  		jp.add(stuno);
  		jp.add(stunos);
  		jp.add(stuname);
  		jp.add(stunames);
  		jp.add(okb);

  		this.getContentPane().add(s_pan, BorderLayout.CENTER);
  		this.getContentPane().add(jp, BorderLayout.NORTH);

  		this.setVisible(true);

  	}
}
