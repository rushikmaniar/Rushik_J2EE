import java.awt.*;
import javax.swing.*;

/*
<applet code="JTableDemo" width=400 height=200>
</applet>
*/

public class JTableDemo extends JApplet {
	public void init() {
	
		setLayout(new BorderLayout());

		final String[] colHeads = { "Name", "surname","mobileno" };

		final Object[][] data = {
		{ "Gail", "madhak", "86823703049" },
		{ "Ken", "mehta", "98989892345" },
		{ "Viviane", "jishi", "5893083020" },
		{ "Melanie", "modi", "9222329203" },
		{ "Anne", "bharad", "3333" },
		{ "John", "mdkda", "3144" },
		{ "Matt", "ksdsk", "2176" },
		{ "Claire", "sdsdms", "4244" },
		{ "Erwin", "sdnsdsk", "5159" },
		{ "Ellen", "mlsfls", "5332" },
		{ "Jennifer", "smlsss", "1212" },
		{ "Ed", "sjsjsd", "9808900808" },
		{ "Helen", "sslffs", "1415" }
		};

		JTable table = new JTable(data, colHeads);

		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(table, v, h);

		add(jsp, BorderLayout.CENTER);
	}
}