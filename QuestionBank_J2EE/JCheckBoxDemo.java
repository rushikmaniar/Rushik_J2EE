import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
<applet code="JCheckBoxDemo" width=400 height=50>
</applet>
*/

public class JCheckBoxDemo extends JApplet implements ItemListener {
	JTextField jtf;
	public void init() {
		setLayout(new FlowLayout());
		JCheckBox cb = new JCheckBox("C");
		cb.addItemListener(this);
		add(cb);

		cb = new JCheckBox("C++");
		cb.addItemListener(this);
		add(cb);

		cb = new JCheckBox("Java");
		cb.addItemListener(this);
		add(cb);

		jtf = new JTextField(15);
		add(jtf);
	}

	public void itemStateChanged(ItemEvent ie) {
		JCheckBox cb = (JCheckBox)ie.getItem();
		if(cb.isSelected())
			jtf.setText(cb.getText());
		else
			jtf.setText("");
	}
}