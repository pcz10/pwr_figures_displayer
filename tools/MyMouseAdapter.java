package tools;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import figury.Frame;

public class MyMouseAdapter extends JPanel
{
	private BindMouseMove movingAdpapt = new BindMouseMove();
	private Frame frame;
	public MyMouseAdapter(Frame frame)
	{
		this.frame = frame;
		addMouseListener(movingAdpapt);
		addMouseMotionListener(movingAdpapt);
	}
	class BindMouseMove extends MouseAdapter
	{
		private int preX;
		private int preY;
		@Override
		public void mousePressed(MouseEvent e)
		{
			  preX = e.getX();
			  preY = e.getY();
			  System.out.println("pressed X,Y: {"+preX+","+preY+"}");
		}
		@Override 
		public void mouseDragged(MouseEvent e)
		{
			frame.repaint();
			int dx = e.getX() - preX;
			int dy = e.getY() - preY;
			System.out.println("e.getX,Y()  :  X,Y = (" +e.getX()+" , "+e.getY()+" )");
			if(frame.getFigure(preX,preY) != null)
			{
				frame.repaint(0, preX, preY, dx, dy);
				frame.getFigure(preX,preY).moveObject(dx,dy);
			}
			preX += dx;
		    preY += dy;
		}
	}
}