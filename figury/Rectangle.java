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
	private int x;
	private int y;
	private int height;
	private int width;
	public Rectangle(int rangeMin, int rangeMax)
	{
		RandomValues validator = new RandomValues();
		this.x = validator.randomize(rangeMin, rangeMax);
		this.y = validator.randomize(rangeMin, rangeMax);
		this.height = validator.randomize(rangeMin, rangeMax);
		this.width = validator.randomize(rangeMin, rangeMax);
		System.out.println("I am rectangle. My coords are x = "+x+" y = "+y+" height= "+height+" width = "+width);
	}
	public Rectangle()
	{
		RandomValues validator = new RandomValues();
		this.x = validator.randomize(RANGE_MIN, RANGE_MAX);
		this.y = validator.randomize(RANGE_MIN, RANGE_MAX);
		int temp = validator.randomize(RANGE_MIN, RANGE_MAX);
		this.width = temp;
		this.height = temp;	
		System.out.println("I am rectangle. My coords are x = "+x+" y = "+y+" height= "+height+" width = "+width);
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
		g2.setPaint(new GradientPaint(0,0,Color.gray,20,20,Color.PINK,true));
		g2.fillRect(0, 0,this.width, this.height);
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
		if(x > this.x && x < (this.x + this.width) && y > this.y && y < (this.y+this.height))
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
	@Override
	public void moveObject(int dx, int dy) 
	{
		System.out.println("moveObject RECTANGLE working!");
		repaint(0,0, this.width + 1, this.height + 1);
		this.x += dx;
		this.y += dy;
	}
}