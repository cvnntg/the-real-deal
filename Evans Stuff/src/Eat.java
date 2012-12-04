import io.ResourceFinder;
import visual.statik.TransformableContent;
import visual.statik.sampled.ContentFactory;


public class Eat implements Action {

	private TransformableContent	content, pcontent;
	private String					image;
	private int						duration;
	private int 					offsetX, offsetY;
	public Eat(TransformableContent pcontent, int duration){
		ContentFactory						factory;
		ResourceFinder						finder;
		
		this.pcontent = pcontent;
		this.image="BernMcDonalds.png";
		this.duration = duration;

		finder = ResourceFinder.createInstance(this);
		factory = new ContentFactory(finder);
		this.content = factory.createContent(this.image, 4, false);
		
		this.offsetX = 100;
		this.offsetY= 100;
	}
	
	@Override
	public TransformableContent act() {
		// TODO Auto-generated method stub

		return this.content;
		// TODO Auto-generated method stub
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "EAT";
	}

	public int checkDuration(){
		if 		(this.duration != 0) this.duration--;
		
		return this.duration;
		
	}
	

	@Override
	public double offsetX() {
		// TODO Auto-generated method stub
		return this.offsetX;
	}

	@Override
	public double offsetY() {
		// TODO Auto-generated method stub
		return this.offsetY;
	}

	@Override
	public void setDuration(int duration) {
		// TODO Auto-generated method stub
		this.duration = duration;
	}

}
