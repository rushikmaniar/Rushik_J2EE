import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TableDemo extends JFrame implements ActionListener
{
	JComboBox jcb;
	JList ls;
	JButton bt;
	String str[] = {"1","2","3","4","5"};
	String tab[] = new String[10];
	public TableDemo(){

		jcb = new JComboBox(str);
		ls  = new JList();
		bt = new JButton("0k");

		setLayout(new FlowLayout());
		add(jcb);
		add(bt);
		add(ls);

		bt.addActionListener(this);

		setBounds(0,0,400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae){

		int no = Integer.parseInt((String)jcb.getSelectedItem());

		for(int i=1;i<=10;i++){

			tab[i-1] = Integer.toString(no * i);
		}

		ls.setListData(tab);
	}

	public static void main(String args[]){
		new TableDemo();
	}

}