import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class myTableCellRenderer {
	DefaultTableCellRenderer dtcr =new DefaultTableCellRenderer();

	int row,column;

	Color c;

	public myTableCellRenderer(int row,int column,Color c)

	{

		this.row=row;this.column=column;this.c=c;

	}

	public Component getTableCellRendererComponent(JTable table, Object value,

			boolean isSelected, boolean hasFocus, int row, int column) {

		Component renderer =dtcr.getTableCellRendererComponent(table, value,

				isSelected, hasFocus, row, column);

		if (row==this.row&&column==this.column) 

		{

			renderer.setBackground(c);

		} 

		return renderer;

}
}
