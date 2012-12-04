import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.*;
import java.util.*;
import visual.dynamic.described.*;
import visual.statik.TransformableContent;

public class Bernstein extends AbstractSprite
{
	private ArrayList<Action> actions;
	private double 						maxX,
										maxY,
										x,
										y, 
										newX,
										newY;
	private Random 						rng;
	int									count;
	boolean								lr;
	
	//default content
	private TransformableContent 		content;
	
	private String						image;
	private Stage						stage;
	
	//These hold the current Actions content and the current action object
	private TransformableContent		actionContent;
	private Action						cAction;
	
	
	
	private int ACTIONDURATION	= 		45;
	
	public int 							health, healthticker;
	public Bernstein(){
		this.image = "bern.png";
		this.health = 100;
		this.healthticker = 100;
	}
	
	public Bernstein(Stage stage, TransformableContent content, double width, double height)
	{
		super();
		this.cAction = null;
		this.stage = stage;
		this.image = "bern.png";
		this.content = content;
		
		maxX = width - 300;
		maxY = height - 200;
		rng = new Random();
		x = getRandomNumber(maxX);
		y = getRandomNumber(maxY);

		this.actions = new ArrayList<Action>();
		setVisible(true);
		this.count = 25;
		lr = false;
		newX = getRandomNumber(width);
		newY = getRandomNumber(height);
		this.stage.add(this);
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
		Action action;
		int duration = 0;
		double offsetX;
		double offsetY;
		

		
		
		/*for (int jj = 0; jj < this.actions.size(); jj++){
			
			action = this.actions.get(jj);
			offsetX = action.offsetX();
			offsetY = action.offsetY();
			duration = action.checkDuration();
		
			if (duration > 1 && actionContent != null){
				actionContent.setLocation(newX , newY);
			} else if (duration == 1){
				System.out.println("REMOVING THE ACTIONCONTENT");
				this.stage.remove(actionContent);
				actionContent = null;
			} 
		}*/
		
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
			
			if (cAction != null && actionContent != null){
				duration = cAction.checkDuration();
				
				if (duration > 1 && this.actionContent != null){
					setLocation(600,600);
					this.stage.remove(this.actionContent);
					this.actionContent = cAction.act();
					this.actionContent.setLocation(newX, newY);
					this.actionContent.setRotation(100, newX, newY);
					this.stage.add(this.actionContent);
				
				} else if (duration == 1){
					setLocation(newX, newY);
					this.stage.remove(actionContent);
					actionContent =null;
					this.cAction = null;
				}
			} else{
			
			setLocation(newX,newY);
			}
	}
	
	public String getImage(){
		return this.image;
	}
	
	public ArrayList<Action> getActions(){
		return this.actions;
	}
	
	public void setActions(){
		this.actions.add(new Curse(this.content, 0));
		this.actions.add(new Eat(this.content, 0));
		this.actions.add(new Dance(this.content, 0));
	}	
	
	public void handleAction(ActionEvent event){
		
		Action 										action;
				
		if (actionContent!=null){
			setLocation(newX, newY);
			this.stage.remove(this.actionContent);
		}
		
		
		for (int jj = 0 ;jj < this.actions.size(); jj++){
			action = actions.get(jj);
				
			if (action.description() == event.getActionCommand()){
				this.cAction = action;
				this.actionContent = cAction.act();
				cAction.setDuration(ACTIONDURATION);
				actionContent.setLocation(newX, newY);				
				this.stage.add(actionContent);
			}
		}
			
	}
}

