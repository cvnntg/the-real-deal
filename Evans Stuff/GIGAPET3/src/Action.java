import visual.statik.TransformableContent;


public interface Action {

	public TransformableContent act();
	
	public String description();
	
	public int checkDuration();
	
	public void setDuration(int duration);
	
	public double offsetX();
	
	public double offsetY();
}
