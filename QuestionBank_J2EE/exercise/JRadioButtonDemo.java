import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
<applet code="JRadioButtonDemo" width=300 height=50>
</applet>
*/

public class JRadioButtonDemo extends JApplet implements ActionListener {
	JTextField tf;
	public void init() {
		setLayout(new FlowLayout());

		JRadioButton b1 = new JRadioButton("A");
		b1.addActionListener(this);
		add(b1);
		
		JRadioButton b2 = new JRadioButton("B");
		b2.addActionListener(this);
		add(b2);

		JRadioButton b3 = new JRadioButton("C");
		b3.addActionListener(this);
		add(b3);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		
		tf = new JTextField(5);
		add(tf);
	}
	
	public void actionPerformed(ActionEvent ae) {
		tf.setText(ae.getActionCommand());
	}
}