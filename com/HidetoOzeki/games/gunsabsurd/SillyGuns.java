package com.HidetoOzeki.games.gunsabsurd;
import com.HidetoOzeki.games.gunsabsurd.gfx.Bitmap;
import com.HidetoOzeki.games.gunsabsurd.gfx.Screen;
import com.HidetoOzeki.games.gunsabsurd.InputHandler;
import com.HidetoOzeki.games.gunsabsurd.Entities.Entity;
import com.HidetoOzeki.games.gunsabsurd.Entities.Mob;
import com.HidetoOzeki.games.gunsabsurd.Entities.Player;
import java.awt.event.KeyEvent;
import java.awt.Desktop;
import java.net.URL;
import java.awt.Font;
public class SillyGuns{
	boolean exit = false;
	int bgcol = 0x0000ff;
	int x = 0;
	int gamemode_title =0;
	int gamemode_game = 1;
	int gamemode = gamemode_title;

	String[] options = {"スタート","設定","GitHubページ","閉じる"};
	int index = 0;
	int bet = 16;
	int fontnum = 0;
	String[] availablefonts;
	String titlefont = "";
	String[] titletexts = {"ガンズ\nアブサード","Guns\nAbsurd"};
	String titletext = "";
	boolean dispen = false;
	boolean dispjp = false;
	Player player = new Player();
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
		}else if(options[index].equals("スタート")){
			gamemode=gamemode_game;
		}
		}

		if(input.getkeystate(KeyEvent.VK_DOWN)){index++;fontnum++;}
		if(input.getkeystate(KeyEvent.VK_UP)){index--;fontnum--;}
		input.setkeystate(KeyEvent.VK_UP,false);
		input.setkeystate(KeyEvent.VK_DOWN,false);
		input.setkeystate(KeyEvent.VK_ENTER,false);
		if(index < 0)index = options.length-1;
		if(index > options.length-1)index = 0;
		/*
		if(fontnum < 0)fontnum = availablefonts.length-1;
		if(fontnum > availablefonts.length-1)fontnum = 0;
		titlefont = availablefonts[fontnum];
		*/
		player.update();
	}
	
	public void render(Screen screen){
		
		if(availablefonts==null){
			/*
			availablefonts = screen.getAvailableFont();
			titlefont = availablefonts[fontnum];
			System.out.println("available font updated");
			*/
			titlefont = "";
		}
		if(gamemode==gamemode_game){

			screen.clear(0x9999ff);

			screen.setOffsetCenter((int)player.x,(int)player.y);
			screen.setDrawColor(0x3333ff);
			screen.rectangle(-100,0,100,10);
			screen.setDrawColor(0xff3333);
			screen.rectangle(0,0,100,10);

			screen.drawText(""+(int)player.y,32,32);
			player.render(screen);
		}else if(gamemode==gamemode_title){
			screen.clear(0);
			screen.setDrawColor(0x888888);
			/*
			screen.setFont(titlefont,true,true,48);
			dispen = screen.getFont().canDisplay('A');
			dispjp = screen.getFont().canDisplay('あ');
			titletext = dispjp ? titletexts[0] : titletexts[1];
			if(!dispen&&!dispjp)screen.setFont("",true,true,48);
			*/
			titletext = titletexts[1];
			screen.setFont("Meiryo",true,true,48);
			screen.drawText(titletext,screen.getWidth()/2,screen.getHeight()/3);
			screen.setDrawColor(0xffffff);
			screen.drawText(titletext,-2+screen.getWidth()/2,-2+screen.getHeight()/3);
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