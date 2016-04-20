package figury;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import tools.RandomValues;

public class Circle extends JComponent implements Figure, Moveable
{
	public Circle(int rangeMin, int rangeMax)
	{
		RandomValues validator = new RandomValues();
		x = validator.randomize(rangeMin, rangeMax);
		y = validator.randomize(rangeMin, rangeMax);
		diameter = validator.randomize(rangeMin, rangeMax);
	}
	
	public Circle()
	{
		RandomValues validator = new RandomValues();
		x = validator.randomize(RANGE_MIN, RANGE_MAX);
		y = validator.randomize(RANGE_MIN, RANGE_MAX);
		diameter = validator.randomize(RANGE_MIN, RANGE_MAX);
	}
	
	public int getX() 
	{
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(new GradientPaint(0,0,Color.gray,20,20,Color.green,true));
		g2.fillOval(0, 0, this.diameter, this.diameter);
		repaint();
	}
	public void drawObject(Frame frame) 
	{
		frame.add(this);
		frame.revalidate();
	}

	public boolean containsFigure(int xCoordinateWhileClicked,int yCoordinateWhileClicked)
	{
		if(xCoordinateWhileClicked > this.x && xCoordinateWhileClicked < (this.x + this.diameter) 
				&& yCoordinateWhileClicked > this.y && yCoordinateWhileClicked < (this.y+this.diameter))
			return true;
		else
			return false;
	}
	
	public void moveObject(int xOffsetValue, int yOffsetValue)
	{
		repaint(0, 0, this.diameter+1, this.diameter+1);
		this.x += xOffsetValue;
		this.y += yOffsetValue;
	}
	
	private int x;
	private int y;
	private int diameter;
}