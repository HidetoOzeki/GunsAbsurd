public class Mob extends Entity {
	
	int life = 1000;
	
	public Mob(double x,double y){
		super(x,y);
		vx = 3;
		vy = 3;
	}
	
	@Override
	public void update(){
		super.update();
		life--;
	}
	
}