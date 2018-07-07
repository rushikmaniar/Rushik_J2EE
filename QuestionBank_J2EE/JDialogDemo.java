import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JDialogDemo extends JFrame implements ActionListener
{
	JTextField txt;
	JButton bt;
	JDialog jd;
	JLabel lbl;

	public JDialogDemo(){
		
		txt = new JTextField(15);
		bt = new JButton("Ok");
		lbl = new JLabel("");
		jd = new JDialog();

		setLayout(new FlowLayout());
		add(txt);
		add(bt);

		jd.setLayout(new FlowLayout());
		jd.add(lbl);
		jd.setBounds(0,0,100,100);
		jd.setTitle("Name");

		bt.addActionListener(this);

		setTitle("JDialog Demo");
		setBounds(0,0,400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		lbl.setText(txt.getText());
		jd.setVisible(true);
	}

	public static void main(String[] args) 
	{
		new JDialogDemo();
	}
}
