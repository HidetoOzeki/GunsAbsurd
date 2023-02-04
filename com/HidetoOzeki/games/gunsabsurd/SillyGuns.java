package com.HidetoOzeki.games.gunsabsurd;
import com.HidetoOzeki.games.gunsabsurd.gfx.Bitmap;
import com.HidetoOzeki.games.gunsabsurd.gfx.Screen;
import com.HidetoOzeki.games.gunsabsurd.InputHandler;
import java.awt.event.KeyEvent;
public class SillyGuns{
	boolean test = false;
	int bgcol = 0x0000ff;
	int x = 0;
	Bitmap title = new Bitmap("res/title.png");
	public SillyGuns(){
	}
	
	public void init(){
	}
	
	public void tick(int mouseX,int mouseY,InputHandler input){
		if(input.getkeystate(KeyEvent.VK_SPACE)){
			bgcol = test ? 0xff0000 : 0x0000ff;
			test=!test;
		}
		input.setkeystate(KeyEvent.VK_SPACE,false);
		x++;
	}
	
	public void render(Screen screen){
		screen.clear(bgcol);
		screen.render(x,0,title);
	}
}