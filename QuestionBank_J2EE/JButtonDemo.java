import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
<applet code="JButtonDemo" width=640 height=480>
</applet>
*/

public class JButtonDemo extends JApplet implements ActionListener {
	JTextField jtf;
	public void init() {

		setLayout(new FlowLayout());

		ImageIcon demo = new ImageIcon("demo.png");
		JButton jb = new JButton("Ok",demo);
		jb.setActionCommand("Demo");
		jb.addActionListener(this);
		add(jb);
		jtf = new JTextField(15);
		add(jtf);
	}

	public void actionPerformed(ActionEvent ae) {
		jtf.setText(ae.getActionCommand());
	}
}