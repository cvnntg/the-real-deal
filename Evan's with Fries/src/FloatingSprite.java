import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import visual.dynamic.described.*;
import visual.statik.TransformableContent;

public class FloatingSprite extends AbstractSprite
{
	private ArrayList<Action> actions;
	private double maxX, maxY, x, y;
	private Random rng;

	private TransformableContent content;

	public FloatingSprite(TransformableContent content, double width, double height)
	{
		super();
		this.content = content;
		maxX = width;
		maxY = height;
		rng = new Random();
		x = rng.nextDouble()*maxX;
		y = 0.0;
		setLocation(x, y);
		this.actions = new ArrayList<Action>();
		setVisible(true);
	}
	
	public TransformableContent getContent()
	{
		return content;
	}
	
	public void handleTick(int time)
	{
		double			n;
		n = rng.nextDouble();
		if			(n < 0.80)	y += 2.0;
		else if 	(n > 0.90)	y -= 1.0;
		n = rng.nextDouble();
		if		(n < 0.20) x -= 1.0;
		else if (n > 0.80) x += 1.0;
		// Check if at the bottom
		if (y > maxY)
		{
			y = 0.0;
			x = rng.nextDouble()*maxX;
		}
		
		setLocation(x, y);
	}
	
}

