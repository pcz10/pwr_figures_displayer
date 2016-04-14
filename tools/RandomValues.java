package tools;
import java.util.Random;

public class RandomValues 
{
	public int randomize(int rangeMin, int rangeMax)
	{
		Random r = new Random();
	    int randomValue = (int) (rangeMin + (rangeMax - rangeMin) * r.nextDouble());
		return randomValue;
	}
	
}
