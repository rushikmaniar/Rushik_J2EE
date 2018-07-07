import javax.swing.*;
import java.awt.*;

class JTableDemo2 extends JFrame
{
	JTable t;
	JScrollPane sp;
	public JTableDemo2(){
				
		String dataValues[][] = new String[4][3];
		String columnValues[] = new String[3];

		columnValues[0] = "Name";
		columnValues[1] = "Surname";
		columnValues[2] = "MobileNo";

		dataValues[0][0] = "Savan";
		dataValues[0][1] = "Anjaria";
		dataValues[0][2] = "9925361312";
		
		dataValues[1][0] = "Darshan";
		dataValues[1][1] = "Karia";
		dataValues[1][2] = "9824820108";

		dataValues[2][0] = "Ketan";
		dataValues[2][1] = "Kotak";
		dataValues[2][2] = "9426267689";

		dataValues[3][0] = "Nimish";
		dataValues[3][1] = "Gohel";
		dataValues[3][2] = "9825361312";

		t = new JTable(dataValues,columnValues);
		t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		sp = new JScrollPane(t);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		t.setBounds(0,0,100,100);
		add(sp);
		
		setTitle("Table Demo");
		setBounds(0,0,260,125);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
		JTableDemo2 ob = new JTableDemo2();
		ob.setVisible(true);
	}
}
