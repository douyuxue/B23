package admin.table.model;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class Table_model_a  extends AbstractTableModel {
	private Vector content = null;
	private String[] title_name = { "工号", "姓名", "电话", "工作点" };

	public Table_model_a() {
		content = new Vector();
	}

	public Table_model_a(int count) {
		content = new Vector(count);
	}

	public void addRow(String ano, String aname,  String aphone, String workplace) {
		Vector v = new Vector(5);
		v.add(0, ano);
		v.add(1, aname);
		v.add(2, aphone);
		v.add(3, workplace);
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
