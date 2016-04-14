package start;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import figury.*;
import figury.Frame;
import tools.MyMouseAdapter;
public class App extends JApplet
{
	
	public static void main (String[] args)
	{
	SwingUtilities.invokeLater(new Runnable(){
	public void run() 
	{
		Frame frame = new Frame();
		MyMouseAdapter mA = new MyMouseAdapter(frame);
		frame.add(mA);
	}
	});
	}
	
}