package start;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;
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