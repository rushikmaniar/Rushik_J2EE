import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
<applet code="JComboBoxDemo" width=300 height=100>
</applet>
*/

public class JComboBoxDemo extends JApplet implements ItemListener {
	JLabel jl,j2;
	JComboBox jc;

	public void init() {
		setLayout(new FlowLayout());
		jc = new JComboBox();
		jc.addItem("France");
		jc.addItem("Germany");
		jc.addItem("Italy");
		jc.addItem("Japan");
		jc.addItemListener(this);
		add(jc);

		jl = new JLabel("");
		add(jl);

		j2 = new JLabel("");
		add(j2);
	}

	public void itemStateChanged(ItemEvent ie) {
		String s = (String)ie.getItem();
		jl.setText(s);
		j2.setText((String)jc.getSelectedItem());
	}
}