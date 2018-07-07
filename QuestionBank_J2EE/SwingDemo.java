import javax.swing.*;
import java.awt.*;

public class  SwingDemo
{
	JFrame frm;
	JTextField txt;
	JLabel lbl;
	JButton bt;

	public SwingDemo(){
		
		frm = new JFrame("Swing Demo Application");
		txt = new JTextField(15);
		lbl = new JLabel("Name");
		bt = new JButton("Ok");

		
		frm.setLayout(new FlowLayout());

		frm.add(lbl);
		frm.add(txt);
		frm.add(bt);

		frm.setSize(400,100);
		//frm.setBounds(0,0,400,100);
		frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);
		frm.setVisible(true);

	}
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new SwingDemo();
			}
		});
	}
}
