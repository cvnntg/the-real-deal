package bot;

import io.ResourceFinder;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;

import visual.statik.CompositeContent;
import visual.statik.described.Content;


public class FrontBot extends AbstractDigiBot 
{
	private String facePath;
	
	public FrontBot(String facePath)
	{
		super();
		this.facePath = facePath;
	}
		
	public CompositeContent getHead(Color color1, Color color2, Stroke stroke)
	{
		CompositeContent 						wholeHead;
		Content									head;
		Path2D.Float 							headShape; 
		ResourceFinder							finder;
		visual.statik.sampled.Content			face;
		visual.statik.sampled.ContentFactory	factory;
		
		headShape = new Path2D.Float();
		headShape.moveTo(15, 0);
		headShape.lineTo(85, 0);
		headShape.lineTo(85, 80);
		headShape.lineTo(15, 80);
		headShape.lineTo(15, 0);
		headShape.closePath();
		
		stroke = new BasicStroke();
		head = new Content(headShape, color1, color2, stroke);
				
		finder = ResourceFinder.createInstance(this);
		factory = new visual.statik.sampled.ContentFactory(finder);
		face = factory.createContent(facePath, 4);
		
		wholeHead = new visual.statik.CompositeContent();
		wholeHead.add(head);
		wholeHead.add(face);
		
		return wholeHead;
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
