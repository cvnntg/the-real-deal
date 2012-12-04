import io.ResourceFinder;
import visual.statik.TransformableContent;
import visual.statik.sampled.ContentFactory;

public class Dance implements Action{
	private TransformableContent	content, pcontent;
	private String					image;
	private String					imageExtension;
	private int						duration;
	private int 					offsetX, offsetY;
	private int						images;
	private int						cimage;
	public Dance(TransformableContent pcontent, int duration){

		
		this.image="bern";
		this.imageExtension=".png";
		this.duration = duration;
		this.images = 15;

		
		
		this.offsetX = 170;
		this.offsetY= 50;
		this.content = content;
	}
	
	@Override
	public TransformableContent act() {
		// TODO Auto-generated method stub
		ContentFactory						factory;
		ResourceFinder						finder;
		finder = ResourceFinder.createInstance(this);
		factory = new ContentFactory(finder);
		cimage = this.duration%images;
		if (cimage == 0) cimage =15;
		
		try{
		this.content = factory.createContent(this.image + cimage + this.imageExtension, 4, false);
		} catch (Exception e){
			
		}
		return this.content;
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "DANCE";
	}

	@Override
	public int checkDuration() {
		// TODO Auto-generated method stub
		if (this.duration != 0) this.duration--;
		return this.duration;
	}

	@Override
	public void setDuration(int duration) {
		// TODO Auto-generated method stub
		this.duration = duration;
	}

	@Override
	public double offsetX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double offsetY() {
		// TODO Auto-generated method stub
		return 0;
	}

}
