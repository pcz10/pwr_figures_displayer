package figury;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

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
		x = validator.randomize(rangeMin, rangeMax);
		y = validator.randomize(rangeMin, rangeMax);
		height = validator.randomize(rangeMin, rangeMax);
		width = validator.randomize(rangeMin, rangeMax);
	}
	public Rectangle()
	{
		RandomValues validator = new RandomValues();
		x = validator.randomize(rangeMin, rangeMax);
		y = validator.randomize(rangeMin, rangeMax);
		int temp = validator.randomize(rangeMin, rangeMax);
		width = temp;
		height = temp;
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
		g2.fillRect(x,y,width,height);
	}
	
	public void drawObject(Frame frame)
	{
		frame.add(new Rectangle());
		frame.revalidate();
		frame.repaint();
	}
	public void drawRectangle(Frame frame)
	{
		frame.getContentPane().add(new Rectangle(1,550));
		frame.pack();
	}
	@Override
	public void moveObject(int dx, int dy) 
	{
		this.x += dx;
		this.y += dy;
		repaint();
	}
	@Override
	public boolean contains(int x_, int y_)
	{
		if (x_ < (this.x + this.width) && x_ > this.x && y_ < this.y && y_ > (this.y - this.height))
			return true;
		return false;
	}
}