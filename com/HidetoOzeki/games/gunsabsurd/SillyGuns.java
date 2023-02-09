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
	int gamemode_title =0;
	int gamemode_game = 1;
	int gamemode = gamemode_title;
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
	}
	
	public void render(Screen screen){
		if(gamemode==gamemode_game){

		}else if(gamemode==gamemode_title){
		screen.render(x,0,title);

		screen.setDrawColor(0xff00ff);
		screen.setFont("HGSoeiKakupoptai",false,true,16);
		screen.drawtext("日本語テスト",screen.getWidth()/2,32);
		screen.drawtext("閉じる",screen.getWidth()/2,32);
		screen.setDrawColor(0x00ff00);
		screen.setFont("HGSoeiKakupoptai",false,false,16);
		screen.drawtext("日本語テスト",screen.getWidth()/2,32);
		screen.drawtext("閉じる",screen.getWidth()/2,32);
		screen.setDrawColor(0xff00ff);
		screen.setFont("HGSoeiKakupoptai",false,true,16);
		screen.drawtext("日本語テスト",screen.getWidth()/2,screen.getHeight()-40);
		screen.drawtext("閉じる",screen.getWidth()/2,screen.getHeight()-20);
		screen.setDrawColor(0x00ff00);
		screen.setFont("HGSoeiKakupoptai",false,false,16);
		screen.drawtext("日本語テスト",screen.getWidth()/2,screen.getHeight()-40);
		screen.drawtext("閉じる",screen.getWidth()/2,screen.getHeight()-20);
		}
	}
}