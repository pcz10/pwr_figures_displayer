package figury;

import javax.swing.JFrame;

public class Frame extends JFrame
{
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	private Rectangle rec = new Rectangle();
	private Circle circle = new Circle();
	private Triangle triangle = new Triangle();
	public Frame()
	{
		
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		creator();
	}
	public void creator()
	{
		rec.drawObject(this);
		circle.drawObject(this);
		triangle.drawObject(this);
	}
	public Moveable getFigure(int preX,int preY)
	{	
		if(circle.containsFigure(preX, preY))
			return circle;
		else if(rec.containsFigure(preX,preY))
			return rec;
		else if(triangle.contains(preX, preY))
			return triangle;
		else
			return null;
	}
	
}