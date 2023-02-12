package com.HidetoOzeki.games.gunsabsurd;
import com.HidetoOzeki.games.gunsabsurd.gfx.Bitmap;
import com.HidetoOzeki.games.gunsabsurd.gfx.Screen;
import com.HidetoOzeki.games.gunsabsurd.InputHandler;
import java.awt.event.KeyEvent;
import java.awt.Desktop;
import java.net.URL;
public class SillyGuns{
	boolean exit = false;
	int bgcol = 0x0000ff;
	int x = 0;
	Bitmap title = new Bitmap("res/title.png");
	int gamemode_title =0;
	int gamemode_game = 1;
	int gamemode = gamemode_title;

	String[] options = {"スタート","設定","GitHubページ","閉じる"};
	int index = 0;
	int bet = 16;
	public SillyGuns(){
	}
	
	public void init(){
	}

	public boolean isShuttingDown(){
		return exit;
	}
	
	public void tick(int mouseX,int mouseY,InputHandler input){

		if(input.getkeystate(KeyEvent.VK_ENTER)){
		if(options[index].equals("閉じる")){
			exit = true;
		}else if(options[index].equals("GitHubページ")){
			try {
				Desktop.getDesktop().browse(new URL("https://github.com/HidetoOzeki/GunsAbsurd").toURI());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}

		if(input.getkeystate(KeyEvent.VK_DOWN))index++;
		if(input.getkeystate(KeyEvent.VK_UP))index--;
		input.setkeystate(KeyEvent.VK_UP,false);
		input.setkeystate(KeyEvent.VK_DOWN,false);
		input.setkeystate(KeyEvent.VK_ENTER,false);
		if(index < 0)index = options.length-1;
		if(index > options.length-1)index = 0;
	}
	
	public void render(Screen screen){
		if(gamemode==gamemode_game){

		}else if(gamemode==gamemode_title){
			screen.render(0,-16,title);
			screen.setDrawColor(0xffffff);
			screen.setFont("Meiryo",true,true,12);
			int i = 0;
			for(String o : options){
				if(index==i)o="> "+o+" <";
				screen.drawText(o,screen.getWidth()/2,(screen.getHeight()-options.length*bet)+i*bet);
				i++;
			}
		}
	}
}