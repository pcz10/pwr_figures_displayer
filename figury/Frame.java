package figury;
import java.awt.Component;
import java.awt.Point;
import java.awt.Shape;

import tools.MyMouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame
{
	private static final int WIDTH = 1333;
	private static final int HEIGHT = 755;
	private Rectangle rec = new Rectangle();
	private Circle circl = new Circle();
	private Triangle trian = new Triangle();
	
	public Frame()
	{
		super("tytul");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		JLabel label = new JLabel(" Label one ");
		creator();
	}
	private void creator()
	{
		rec.drawObject(this);
		circl.drawObject(this);
		trian.drawObject(this);
	}
	/*public Rectangle getRectangle(int _x,int _y)
	{
		if (rec.contains(_x, _y))
			return rec;
		return null;
	}
	public Rectangle getRectangle()
	{
			return rec;
	}*/
	public Moveable getFigure(int _x_, int _y_)
	{
		if(rec.contains(_x_, _y_))
			return rec;
		else if(circl.contains(_x_, _y_))
			return circl;
		else
			return null;
	}
	
}
