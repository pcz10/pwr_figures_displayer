package figury;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Arrays;

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
		this.x[i] = validator.randomize(RANGE_MIN-55, RANGE_MAX+200);
		this.y[i] = validator.randomize(RANGE_MIN-55, RANGE_MAX+200);
		}
		Arrays.sort(this.x);
		Arrays.sort(this.y);
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
		g2.drawPolygon(x, y, TRIANGLE);
		g2.fillPolygon(x, y, TRIANGLE);
		repaint();
	}
	public void drawObject(Frame frame) 
	{
		frame.add(this);
		frame.revalidate();
		frame.repaint();
	}
	@Override
	public boolean contains(int x, int y)
	{
		if (x > this.x[0] && x <(this.x[0]+(this.x[2]-this.x[0])) && y > this.y[0] && y <(this.y[0]+(this.y[2]-this.y[0])))
			return true;
		return false;
	}
	@Override
	public void moveObject(int dx, int dy) 
	{
		for(int i = 0; i<this.x.length; ++i)
		{
			this.x[i]+=dx;
			this.y[i]+=dy;
		}
	}

	
}