import java.awt.*;
import javax.swing.*;

/*
<applet code="JTextFieldDemo" width=300 height=50>
</applet>
*/

public class JTextFieldDemo extends JApplet {

	JTextField jtf;
	public void init() {

		setLayout(new FlowLayout());

		jtf = new JTextField("This is sample text",15);
		add(jtf);
	}
}