package admin.table.model;

import java.util.Vector;


import javax.swing.table.AbstractTableModel;

public class Table_model_s  extends AbstractTableModel{
	private Vector content = null;
	private String[] title_name = { "学号", "姓名", "年龄", "电话", "学校" };

	public Table_model_s() {
		content = new Vector();
	}

	public Table_model_s(int count) {
		content = new Vector(count);
	}

	public void addRow(int sno, String sname, int sage, String sphone, String school) {
		Vector v = new Vector(5);
		v.add(0, sno);
		v.add(1, sname);
		v.add(2, new Integer(sage));
		v.add(3, sphone);
		v.add(4, school);
		content.add(v);
	}

	public void removeRow(int row) {
		content.remove(row);
	}

	public void removeRows(int row, int count) {
		for (int i = 0; i < count; i++) {
			if (content.size() > row) {
				content.remove(row);
			}
		}
	}

	public String getColumnName(int col) {
		return title_name[col];
	}

	public int getColumnCount() {
		return title_name.length;
	}

	public int getRowCount() {
		return content.size();
	}

	public Object getValueAt(int row, int col) {
		return ((Vector) content.get(row)).get(col);
	}

}
