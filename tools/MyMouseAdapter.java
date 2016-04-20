package tools;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import figury.Frame;

public class MyMouseAdapter extends JPanel
{
	public MyMouseAdapter(Frame frame)
	{
		this.frame = frame;
		addMouseListener(movingAdpapt);
		addMouseMotionListener(movingAdpapt);
	}
	
	class BindMouseMove extends MouseAdapter
	{
		private int pressedX;
		private int pressedY;
		
		@Override
		public void mousePressed(MouseEvent e)
		{
			pressedX = e.getX();
			pressedY = e.getY();
		}
		
		@Override 
		public void mouseDragged(MouseEvent e)
		{
			frame.repaint();
			int xOffsetValue = e.getX() - pressedX;
			int yOffsetValue = e.getY() - pressedY;
			System.out.println("current coords  :  X,Y = (" + e.getX() + " , " + e.getY() + " )");
			if(frame.getFigure(pressedX, pressedY) != null)
			{
				frame.repaint(0, pressedX, pressedY, xOffsetValue, yOffsetValue);
				frame.getFigure(pressedX,pressedY).moveObject(xOffsetValue, yOffsetValue);
			}
			pressedX += xOffsetValue;
			pressedY += yOffsetValue;
		}
	}
	
	private BindMouseMove movingAdpapt = new BindMouseMove();
	private Frame frame;
}