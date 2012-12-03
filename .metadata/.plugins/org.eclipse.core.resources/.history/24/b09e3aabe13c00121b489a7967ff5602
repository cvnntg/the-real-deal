package bot;

import java.awt.*;
import java.awt.image.BufferedImage;

import io.*;
import visual.statik.*;

public abstract class AbstractDigiBot extends visual.statik.CompositeContent  
{
	public AbstractDigiBot()
	{
		super();
				
		BasicStroke								stroke;
		Color									black, maroon, orange;
		visual.statik.CompositeContent			head;
		visual.statik.described.Content 		neck, torso, wheel;
			
		black	= Color.BLACK; 
		maroon	= new Color(176, 23, 31);
		orange 	= new Color(238, 64, 0);
				
		stroke = new BasicStroke();
				
		head = getHead(maroon, orange, stroke);
		add(head);
		
		neck = new visual.statik.described.Content(getNeck(), maroon, orange, stroke);
		add(neck);
		
		torso = new visual.statik.described.Content(getTorso(), maroon, orange, stroke);
		add(torso);
		
		wheel = new visual.statik.described.Content(getWheel(), maroon, black, stroke);
		add(wheel);
			
	}
			
	public abstract CompositeContent getHead(Color color1, Color color2, Stroke stroke);
	public abstract Shape getNeck();
	public abstract Shape getTorso();
	public abstract Shape getWheel();
	
	
	
}
