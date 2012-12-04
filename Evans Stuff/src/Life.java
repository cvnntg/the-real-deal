import visual.dynamic.described.AbstractSprite;
import visual.statik.TransformableContent;


public class Life extends AbstractSprite{

	private int ticktokill;
	private int tickcount; 
	private int life;
	public Life(int ticktokill){
		this.ticktokill = ticktokill;
		this.tickcount = 0;
		this.life = 100;
	}
	
	
	
	@Override
	protected TransformableContent getContent() {
		// TODO Auto-generated method stub
		return ;
		
	}

	@Override
	public void handleTick(int arg0) {
		// TODO Auto-generated method stub
		
		if (this.tickcount++ == this.ticktokill){
			this.life--;
		}
		
		if (this.life == 0){
			
		}
		
	}

}
