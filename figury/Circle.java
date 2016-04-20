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
	private int x;
	private int y;
	private int diameter;
	public Circle(int rangeMin, int rangeMax)
	{
		RandomValues validator = new RandomValues();
		x = validator.randomize(rangeMin, rangeMax);
		y = validator.randomize(rangeMin, rangeMax);
		diameter = validator.randomize(rangeMin, rangeMax);
		System.out.println("I am circle. My coords are x = "+x+" y = "+y+" diameter= "+diameter);
	}
	public Circle()
	{
		RandomValues validator = new RandomValues();
		x = validator.randomize(RANGE_MIN, RANGE_MAX);
		y = validator.randomize(RANGE_MIN, RANGE_MAX);
		diameter = validator.randomize(RANGE_MIN, RANGE_MAX);
		System.out.println("I am circle. My coords are x = "+x+" y = "+y+" diameter= "+diameter);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
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
		frame.repaint();
	}

	public boolean containsFigure(int x,int y)
	{
		if(x > this.x && x < (this.x + this.diameter) && y > this.y && y < (this.y+this.diameter))
			{
				System.out.println("contains Figure, x,y: "+x+", "+y+" and this x,y: "+this.x+","+this.y);
				return true;
			}
		else
			{
				System.out.println("contains figure returns false");
				return false;
			}
	}
	public void moveObject(int dx, int dy)
	{
		System.out.println("moveObject CIRCLE working!");
		repaint(0, 0, this.diameter+1, this.diameter+1);
		this.x += dx;
		this.y += dy;
	}
}