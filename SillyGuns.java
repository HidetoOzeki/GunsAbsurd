import java.awt.event.KeyEvent;
public class SillyGuns{
	boolean test = false;
	int bgcol = 0x0000ff;
	
	Bitmap title = new Bitmap("res/title.png");
	public SillyGuns(){
	}
	
	public void init(){
	}
	
	public void tick(int mouseX,int mouseY,boolean key[]){
		if(key[KeyEvent.VK_SPACE]){
			bgcol = test ? 0xff0000 : 0x0000ff;
			test=!test;
		}
		key[KeyEvent.VK_SPACE] = false;
	}
	
	public void render(Screen screen){
		screen.clear(bgcol);
		screen.render(0,0,title);
	}
}