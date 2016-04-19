package figury;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import tools.RandomValues;

public class Triangle extends JComponent implements Figure, Moveable
{
	private int[] x = new int[3];
	private int[] y = new int[3];
	final static int TRIANGLE = 3;
	
	public Triangle()
	{
		RandomValues validator = new RandomValues();
		for(int i=0; i<TRIANGLE; i++)
		{
		this.x[i] = validator.randomize(rangeMin, rangeMax);
		this.y[i] = validator.randomize(rangeMin, rangeMax);
		}
		System.out.println("I am triangle. My coords are x0,y0 = ("+x[0]+","+y[0]+") x1,y1 = ("+x[1]+","+y[1]+") x2,y2 = ("+x[2]+","+y[2]+")");
	}
	public void setX(int[] x) {
		this.x = x;
	}
	public void setY(int[] y) {
		this.y = y;
	}
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(new GradientPaint(0,0,Color.gray,20,20,Color.cyan,true));
		drawTriangle(g2);
	}
	private void drawTriangle(Graphics c)
	{
		c.drawPolygon(x, y, TRIANGLE);
		c.fillPolygon(x, y, TRIANGLE);
	}
	public void drawObject(Frame frame) 
	{
		frame.add(new Triangle());
		frame.revalidate();
		frame.repaint();
	}
	@Override
	public boolean contains(int x_, int y_)
	{
		if (x_ < (this.x[0] + this.x[2]) && x_ > this.x[0] && y_ < this.y[0] && y_ > this.y[0]-this.y[2])
			return true;
		return false;
	}
	@Override
	public void moveObject(int dx, int dy) {
		// TODO Auto-generated method stub
		
	}

	
}