package admin.table.model;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class Table_Model_M extends AbstractTableModel {
	

		private Vector content = null;
		private String[] title_name = { "菜单号", "菜单名","价格"};

		public Table_Model_M() {
			content = new Vector();
		}

		public Table_Model_M(int count) {
			content = new Vector(count);
		}
		public void addRow(String menuid, String menuname,String price) {//添加课程时增加科目编号和课程名
			Vector v = new Vector(4);
			v.add(0, menuid);
			v.add(1, menuname);
			v.add(2,price);
			content.add(v);
		}

		public void removeRow(int row) {//删除课程时
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
