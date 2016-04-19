package figury;

import javax.swing.JFrame;

public class Frame extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
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
		creator();
	}
	private void creator()
	{
		rec.drawObject(this);
		circl.drawObject(this);
		trian.drawObject(this);
	}
	public Moveable getFigure(int x, int y)
	{
		if(circl.contains(x, y))
			return circl;
		else if(rec.contains(x, y))
			return rec;
		
		else
			return null;
	}
	
}