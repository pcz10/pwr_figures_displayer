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
	}
	
	public boolean contains(int xCoordinateWhileClicked, int yCoordinateWhileClicked)
	{
		if (xCoordinateWhileClicked > this.x[0] && xCoordinateWhileClicked <(this.x[0]+(this.x[2]-this.x[0])) 
				&& yCoordinateWhileClicked > this.y[0] && yCoordinateWhileClicked <(this.y[0]+(this.y[2]-this.y[0])))
			return true;
		else 
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
	
	@Override
	public boolean containsFigure(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private int[] x = new int[3];
	private int[] y = new int[3];
	final static int TRIANGLE = 3;
}