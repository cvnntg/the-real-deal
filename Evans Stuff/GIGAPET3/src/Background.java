import io.ResourceFinder;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import visual.dynamic.described.AbstractSprite;
import visual.statik.TransformableContent;

/*
 * 
 * 
 * 
 * 
 */
public class Background extends AbstractSprite {

	private String  		image;
	
	public Background(){
		this.image = "bikinibottom.png";
	}
	

	
	public Background(TransformableContent content, double width, double height) {
		// TODO Auto-generated constructor stub
	}



	public String getImage(){
		return this.image;
	}

	@Override
	protected TransformableContent getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleTick(int arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
