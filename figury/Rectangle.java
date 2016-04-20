package figury;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;

import tools.RandomValues;

public class Rectangle extends JComponent implements Figure, Moveable
{
	public Rectangle(int rangeMin, int rangeMax)
	{
		RandomValues validator = new RandomValues();
		this.x = validator.randomize(rangeMin, rangeMax);
		this.y = validator.randomize(rangeMin, rangeMax);
		this.height = validator.randomize(rangeMin, rangeMax);
		this.width = validator.randomize(rangeMin, rangeMax);
	}
	public Rectangle()
	{
		RandomValues validator = new RandomValues();
		this.x = validator.randomize(RANGE_MIN, RANGE_MAX);
		this.y = validator.randomize(RANGE_MIN, RANGE_MAX);
		int temp = validator.randomize(RANGE_MIN, RANGE_MAX);
		this.width = temp;
		this.height = temp;	
	}
	
	public int getX() {
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
		g2.setPaint(new GradientPaint(0,0,Color.gray,20,20,Color.PINK,true));
		g2.fillRect(0, 0,this.width, this.height);
		repaint();
	}
	
	public void drawObject(Frame frame)
	{
		frame.add(this);
		frame.revalidate();
	}

	public boolean containsFigure(int xCoordinateWhileClicked,int yCoordinateWhileClicked)
	{
		if(xCoordinateWhileClicked > this.x && xCoordinateWhileClicked < (this.x + this.width) 
				&& yCoordinateWhileClicked > this.y && yCoordinateWhileClicked < (this.y+this.height))
			return true;
		else
			return false;
	}
	
	@Override
	public void moveObject(int xOffsetValue, int yOffsetValue) 
	{
		repaint(0,0, this.width + 1, this.height + 1);
		this.x += xOffsetValue;
		this.y += yOffsetValue;
	}
	
	private int x;
	private int y;
	private int height;
	private int width;
}