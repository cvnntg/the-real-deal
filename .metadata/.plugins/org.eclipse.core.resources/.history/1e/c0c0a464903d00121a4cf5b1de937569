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
		headShape.moveTo(15, 0);
		headShape.lineTo(85, 0);
		headShape.lineTo(85, 80);
		headShape.lineTo(15, 80);
		headShape.lineTo(15, 0);
		headShape.closePath();
				
		return headShape;
	}
	
	
	public Shape getNeck()
	{
		Path2D.Float frontNeck = new Path2D.Float();
		
		frontNeck.moveTo(35, 100);
		frontNeck.lineTo(65, 100);
		frontNeck.lineTo(65, 80);
		frontNeck.lineTo(35, 80);
		frontNeck.lineTo(35, 100);
		frontNeck.closePath();
		
		return frontNeck;
	}
	
	
	public Shape getTorso()
	{
		Path2D.Float frontTorso = new Path2D.Float();
		
		frontTorso.moveTo(0, 100);
		frontTorso.lineTo(100, 100);
		frontTorso.lineTo(100, 250);
		frontTorso.lineTo(0, 250);
		frontTorso.lineTo(0, 100);
		frontTorso.closePath();
		
		return frontTorso;
	}
		
	public Shape getWheel()
	{
		return new Arc2D.Float(30, 215, 35, 90, 2, 360, Arc2D.OPEN);
	}
}
