package figury;

public interface Moveable 
{
	public boolean containsFigure(int xCoordinateWhileClicked, int yCoordinateWhileClicked);
	void moveObject(int xOffsetValue, int yOffsetValue);
}