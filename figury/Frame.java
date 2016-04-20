package figury;

import javax.swing.JFrame;

public class Frame extends JFrame
{
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	private Rectangle rec = new Rectangle();
	
	public Frame()
	{
		
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(rec);
		rec.repaint();
		setVisible(true);
		//creator();
	}
	//private void creator()
	//{
	//	rec.drawObject(this);
	//	System.out.println(" x: "+rec.getX()+" y: "+rec.getY());
	//	circl.drawObject(this);
	//	System.out.println(" x: "+circl.getX()+" y: "+circl.getY());
	
		//trian.drawObject(this);
//	}
	public Moveable getFigure(int preX,int preY)
	{
		if(rec.containsFigure(preX, preY))
			return rec;
		
		return null;
	}
	
}