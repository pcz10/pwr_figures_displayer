package figury;

import javax.swing.JFrame;

public class Frame extends JFrame
{
	public Frame()
	{
		
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		creator();
	}
	
	private void creator()
	{
		rec.drawObject(this);
		circle.drawObject(this);
		triangle.drawObject(this);
	}
	
	public Moveable getFigure(int xCoordinateWhileClicked,int yCoordinateWhileClicked)
	{	
		if(circle.containsFigure(xCoordinateWhileClicked, yCoordinateWhileClicked))
			return circle;
		else if(rec.containsFigure(xCoordinateWhileClicked, yCoordinateWhileClicked))
			return rec;
		else if(triangle.contains(xCoordinateWhileClicked, yCoordinateWhileClicked))
			return triangle;
		else
			return null;
	}

	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	private Rectangle rec = new Rectangle();
	private Circle circle = new Circle();
	private Triangle triangle = new Triangle();
}