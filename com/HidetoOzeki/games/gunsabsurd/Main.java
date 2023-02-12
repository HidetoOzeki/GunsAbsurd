package com.HidetoOzeki.games.gunsabsurd;
import com.HidetoOzeki.games.gunsabsurd.gfx.Screen;
import com.HidetoOzeki.games.gunsabsurd.gfx.Bitmap;
import com.HidetoOzeki.games.gunsabsurd.InputHandler;
import com.HidetoOzeki.games.gunsabsurd.SillyGuns;
import java.io.*;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Thread;
import java.awt.PointerInfo;
import java.awt.MouseInfo;
import java.util.ArrayList;

public class Main implements Runnable {
	
	public static int WIDTH = 320;
	public static int HEIGHT = 240;
	public static int SCALE = 2;
	
	int mouseX,mouseY;
	
	boolean shutdown = false;
	public JFrame window;
	BufferStrategy str;
	BufferedImage image = new BufferedImage(WIDTH,HEIGHT,1);
	InputHandler input = new InputHandler();
	
	int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	Screen screen = new Screen(WIDTH,HEIGHT,image);
	
	SillyGuns game = new SillyGuns();
	
	public Main(){
		window = new JFrame("Guns Absurd");
		window.setSize(WIDTH*SCALE,HEIGHT*SCALE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		window.createBufferStrategy(2);
		window.addKeyListener(input);
		str = window.getBufferStrategy();
	}
	
	void init(){
		game.init();
	}
	
	void tick(){
		
		mouseX = (int)((MouseInfo.getPointerInfo().getLocation().getX()/SCALE)-window.getX()/SCALE);
		mouseY = (int)((MouseInfo.getPointerInfo().getLocation().getY()/SCALE)-window.getY()/SCALE);
		
		game.tick(mouseX,mouseY,input);
		shutdown = game.isShuttingDown();
	}
	
	void render(){
		Graphics g = str.getDrawGraphics();
		
		game.render(screen);
		
		g.drawImage(image,0,0,window.getWidth(),window.getHeight(),null);
		str.show();
		g.dispose();
	}
	
	@Override
	public void run(){
		
		double ms = 1000.0/60.0;
		double delta = 0;
		double last = System.currentTimeMillis();
		int tps = 0;
		int fps = 0;
		long timer = System.currentTimeMillis();
		while(!shutdown){
			double now = System.currentTimeMillis();
			delta += (now-last)/ms;
			last = now;
			if(delta>=1){
				tick();
				tps++;
				delta--;
			}else{
				render();
				fps++;
				try{
				Thread.sleep(2);
				}catch(InterruptedException e){
				}
			}
			if(timer+1000<System.currentTimeMillis()){
				timer+=1000;
				System.out.println("fps : " + fps+" tps : "+tps);
				tps = 0;
				fps = 0;
			}
		}
	}
	public static void main(String[] args){
	Main main = new Main();
	main.init();
	main.run();
	System.exit(0);
	}
}