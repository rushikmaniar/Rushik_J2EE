import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class JPopupMenuDemo extends JFrame implements PopupMenuListener, ActionListener, MouseListener
{
	JPopupMenu m;
	JMenuItem i;

	public JPopupMenuDemo(){
		m = new JPopupMenu();

		m.add("New");
		m.add("Cut");
		m.add("Copy");
		
		m.addSeparator();
		
		m.add(i = new JMenuItem("Undo"));
		i.addActionListener(this);
		m.add(i = new JMenuItem("Redo"));
		i.addActionListener(this);
		m.addPopupMenuListener(this);
		addMouseListener(this);

		setTitle("JPopupMenu Demo");
		setBounds(0,0,400,400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void mousePressed(MouseEvent e) {
      if (e.isPopupTrigger()) {
        m.show(this, e.getX(), e.getY());
      }
    }

    public void mouseClicked(MouseEvent e) {
      if (e.isPopupTrigger()) {
        m.show(this, e.getX(), e.getY());
      }
    }

    public void mouseReleased(MouseEvent e) {
      if (e.isPopupTrigger()) {
        m.show(this, e.getX(), e.getY());
      }
    }
	
	public void mouseExited(MouseEvent e) {
      
    }
	
	public void mouseEntered(MouseEvent e) {
      
    }

	public void actionPerformed(ActionEvent ae){
	
		System.out.println(ae.getActionCommand() + " was selected...!");
	}

	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
      System.out.println("Popup menu will be visible!");
    }

    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
      System.out.println("Popup menu will be invisible!");
    }

    public void popupMenuCanceled(PopupMenuEvent e) {
      System.out.println("Popup menu is hidden!");
    }

	public static void main(String[] args) 
	{
		new JPopupMenuDemo();
	}
}
