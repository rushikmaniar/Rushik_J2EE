import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JListCopy extends JFrame implements ActionListener
{
	JList ls1,ls2;
	JButton bt;
	String newData="";
	String[] data;
	int i=0;

	public JListCopy(){
	
		String str[] = {"abc","xyz","pqr"};
		ls1 = new JList(str);
		ls2 = new JList();
		bt = new JButton(">>");
		data = new String[str.length];

		setLayout(new FlowLayout());

		add(ls1);
		add(bt);
		add(ls2);

		bt.addActionListener(this);

		setBounds(0,0,400,400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("JList Copy Demo");
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae){
		newData = (String)ls1.getSelectedValue();
		System.out.println(newData);
		data[i] = newData;
	
		for(int j=0;j<2;j++){
			System.out.println(data[0]);
		}
		ls2.setListData(data);
		i++;
	}

	public static void main(String[] args) 
	{
		new JListCopy();
	}
}
