import javax.swing.*;
import java.awt.*;

public class  SwingDemo2 extends JFrame
{
	JTextField txt;
	JLabel lbl;
	JButton bt;

	public SwingDemo2(){
		
		txt = new JTextField(15);
		lbl = new JLabel("Name");
		bt = new JButton("Ok");

		
		setLayout(new FlowLayout());

		add(lbl);
		add(txt);
		add(bt);

		setSize(400,100);
		setTitle("Swing Demo Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new SwingDemo2();
			}
		});

		//new SwingDemo2();
	}
}
