import java.awt.*;
import javax.swing.*;

/*
<applet code="JLabelDemo" width=640 height=480>
</applet>
*/

public class JLabelDemo extends JApplet {
	public void init() {
	
		ImageIcon ii = new ImageIcon("demo.png");

		JLabel jl = new JLabel("LabelDemo", ii, JLabel.CENTER);
	
		add(jl);
	}
}