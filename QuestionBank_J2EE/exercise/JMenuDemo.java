import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

/*
<applet code="JMenuDemo" height=400 width=400>
</applet>
*/

public class JMenuDemo extends JApplet
{
	JMenuBar mb;
	JMenu file,edit,paste;
	JMenuItem cut,copy,pi1,pi2;

	public void init(){

		setLayout(new FlowLayout());
	
		mb = new JMenuBar();
		file = new JMenu("File");
		edit = new JMenu("Edit");
		paste = new JMenu("Paste");
		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");
		pi1 = new JMenuItem("Paste Item1");
		pi2 = new JMenuItem("Paste Item2");

                       
		edit.add(cut);
		edit.add(copy);
		paste.add(pi1);
		paste.add(pi2);
		edit.add(paste);

		mb.add(file);
		mb.add(edit);
                
        add(mb);
        
	}
        
}

