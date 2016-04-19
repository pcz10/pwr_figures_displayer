package figury;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import tools.RandomValues;

public class Circle extends JComponent implements Figure, Moveable
{
	private int x;
	private int y;
	private int radius;
	private int diameter = 2*radius;
	public Circle()
	{
		RandomValues validator = new RandomValues();
		x = validator.randomize(rangeMin, rangeMax);
		y = validator.randomize(rangeMin, rangeMax);
		radius = validator.randomize(rangeMin, rangeMax);
		System.out.println("I am circle. My coords are x = "+x+" y = "+y+" diameter= "+2*radius);
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(new GradientPaint(0,0,Color.gray,20,20,Color.green,true));
		drawCircle(g2);
	}
	private void drawCircle(Graphics c)
	{
		int diameter = 2*radius;
		c.drawOval(x, y, diameter, diameter);
		c.fillOval(x, y, diameter, diameter);
	}
	public void drawObject(Frame frame) 
	{
		frame.add(this);
		frame.revalidate();
		frame.repaint();
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
	public boolean contains(int x_, int y_)
	{
		if (x_ < (this.x + this.diameter) && x_ > this.x && y_ < this.y && y_ > (this.y - this.diameter))
			return true;
		return false;
	}
	public void moveObject(int dx, int dy)
	{
		System.out.println("moveObject TRIANGLE working!");
		this.x += dx;
		this.y += dy;
		repaint();
	}
}