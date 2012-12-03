import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import visual.dynamic.described.*;
import visual.statik.TransformableContent;

public class Bernstein extends AbstractSprite
{
	private ArrayList<Action> actions;
	private double 					maxX,
										maxY,
										x,
										y, 
										newX,
										newY;
	private Random 						rng;
	int									count;
	boolean								lr;
	private TransformableContent 		content;
	private String						image;
	private Stage						stage;
	public Bernstein(){
		this.image = "bern.png";
	}
	
	public Bernstein(Stage stage, TransformableContent content, double width, double height)
	{
		super();
		this.stage = stage;
		this.image = "bern.png";
		this.content = content;

		maxX = width - 100;
		maxY = height - 150;
		rng = new Random();
		x = getRandomNumber(width);
		y = getRandomNumber(height);

		this.actions = new ArrayList<Action>();
		setVisible(true);
		this.count = 25;
		lr = false;
		newX = getRandomNumber(width);
		newY = getRandomNumber(height);
		stage.add(this);
	}
	
	public TransformableContent getContent()
	{
		return content;
	}
	
	private int getRandomNumber(double range){
		return (0 + (int)(Math.random() * ((range - 0) + 1)));
	}
	
	public void handleTick(int time)
	{

		if (newX != x){
			if (newX < x){
				newX+=1;
			} else{
				newX-=1;
			}
		} else {
			x = getRandomNumber(maxX);
		}
		
		
		if (newY != y){
			if (newY < y){
				newY+=1;
			} else {
				newY-=1;
			}
		} else {
			y = getRandomNumber(maxY);
		}
			setLocation(newX,newY);
		
	}
	
	public String getImage(){
		return this.image;
	}
	
	public ArrayList<Action> getActions(){
		return this.actions;
	}
	
	public void setActions(){
		Action a = new Eat();
		this.actions.add(a);
	}	
}

