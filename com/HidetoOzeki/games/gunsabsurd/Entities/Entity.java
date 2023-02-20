package com.HidetoOzeki.games.gunsabsurd.Entities;
import com.HidetoOzeki.games.gunsabsurd.gfx.Screen;
public class Entity{
	public double x,y,vx,vy;
	
	public Entity(double x,double y){
		this.x = x;
		this.y = y;
	}
	
	public void update(){
		x+=vx;
		y+=vy;
	}

	public void render(Screen screen){

	}
}