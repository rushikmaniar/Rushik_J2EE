import javax.swing.*;
import java.awt.*;

/*<applet code="JAppletDemo" height=100 width=400>
</applet>
*/

public class JAppletDemo extends JApplet
{
	JLabel lbl;
	JTextField txt;

	public void init(){
		
		lbl = new JLabel("Name:");
		txt = new JTextField(15);
		
		setLayout(new FlowLayout());
		add(lbl);
		add(txt);
	}
}
