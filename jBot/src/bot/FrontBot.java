package bot;

import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;


public class FrontBot extends AbstractDigiBot 
{	
	public FrontBot(String facePath)
	{
		super(facePath);
	}
		
	public Shape getHead()
	{
		Path2D.Float headShape; 
						
		headShape = new Path2D.Float();
		headShape.moveTo(0, 0);
		headShape.lineTo(150, 0);
		headShape.lineTo(150, 150);
		headShape.lineTo(0, 150);
		headShape.lineTo(0, 0);
		headShape.closePath();
				
		return headShape;
	}
	
	
	public Shape getNeck()
	{
		Path2D.Float frontNeck = new Path2D.Float();
		
		frontNeck.moveTo(30, 150);
		frontNeck.lineTo(120, 150);
		frontNeck.lineTo(120, 165);
		frontNeck.lineTo(30, 165);
		frontNeck.lineTo(30, 150);
		frontNeck.closePath();
		
		return frontNeck;
	}
	
	
	public Shape getTorso()
	{
		Path2D.Float frontTorso = new Path2D.Float();
		
		frontTorso.moveTo(15, 165);
		frontTorso.lineTo(135, 165);
		frontTorso.lineTo(135, 360);
		frontTorso.lineTo(15, 360);
		frontTorso.lineTo(15, 165);
		frontTorso.closePath();
		
		return frontTorso;
	}
	
	
		
	public Shape getWheel()
	{
		return new Arc2D.Float(55, 305, 45, 120, 2, 360, Arc2D.OPEN);
	}
}
