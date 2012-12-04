package bot;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import io.*;
import visual.statik.*;

public abstract class AbstractDigiBot extends visual.statik.CompositeContent  
{	
//	private ArrayList<Action> 		actionList;
	
	public AbstractDigiBot(String facePath)
	{
		super();
		
		//actionList = new ArrayList<Action>();
						
		//checks to see if view of bot being constructed has a face
		boolean hasFace = false;
		
		if(facePath != null)
			hasFace = true;
				
		BasicStroke								stroke;
		Color									black, maroon, orange;
		visual.statik.CompositeContent			compositeHead;
		visual.statik.described.Content 		headShape, neckShape, 
													torsoShape, wheelShape;
			
		black	= Color.BLACK; 
		maroon	= new Color(176, 23, 31);
		orange 	= new Color(238, 64, 0);
				
		stroke = new BasicStroke();
				
		headShape = new visual.statik.described.Content(getHead(), maroon, 
															orange, stroke);
		if (hasFace)
		{	
			compositeHead = makeCompositeHead(headShape, facePath);
			add(compositeHead);
		}
		else
			add(headShape);		
		
		neckShape = new visual.statik.described.Content(getNeck(), maroon, orange, stroke);
		add(neckShape);
		
		torsoShape = new visual.statik.described.Content(getTorso(), maroon, orange, stroke);
		add(torsoShape);
		
		wheelShape = new visual.statik.described.Content(getWheel(), maroon, black, stroke);
		add(wheelShape);
			
	}
			
	public CompositeContent makeCompositeHead(visual.statik.described.Content headShape,
												String facePath)
	{		
		ResourceFinder							finder;
		visual.statik.sampled.Content			face;
		visual.statik.sampled.ContentFactory	factory;
		visual.statik.CompositeContent 			compositeHead;
		
		finder = ResourceFinder.createInstance(this);
		factory = new visual.statik.sampled.ContentFactory(finder);
		face = factory.createContent(facePath, 4, true);
		face.setLocation(50, 50);
		
		compositeHead = new CompositeContent();
		
		compositeHead.add(headShape);
		compositeHead.add(face);
		
		
		
		return compositeHead;		
	}	
	
	public abstract Shape getHead();
	public abstract Shape getNeck();
	public abstract Shape getTorso();
	public abstract Shape getWheel();
	
	
	
}
