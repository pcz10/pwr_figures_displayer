package tools;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import figury.*;
import javax.swing.JPanel;

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
		}
		@Override 
		public void mouseDragged(MouseEvent e)
		{
			int dx = e.getX() - preX;
			int dy = e.getY() - preY;
			
			if(frame.getFigure(preX,preY) != null)
			{
				frame.getFigure(preX,preY).moveObject(dx,dy);
				
			}
			preX += dx;
			preY += dy;
			
		}
	}
}