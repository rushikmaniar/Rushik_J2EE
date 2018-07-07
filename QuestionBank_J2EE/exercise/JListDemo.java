import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class JListDemo extends JFrame implements ListSelectionListener
{
	JList ls1;
	JTextField txt;

	public JListDemo(){
	
		String str[] = {"abc","xyz","pqr"};
		ls1 = new JList(str);
		txt = new JTextField(15);
		
		setLayout(new FlowLayout());

		add(ls1);
		add(txt);
		
		ls1.addListSelectionListener(this);

		setBounds(0,0,400,400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("JList Demo");
		setVisible(true);
	}

	public void valueChanged(ListSelectionEvent le){
		txt.setText((String)ls1.getSelectedValue());
	}

	public static void main(String[] args) 
	{
		new JListDemo();
	}
}
