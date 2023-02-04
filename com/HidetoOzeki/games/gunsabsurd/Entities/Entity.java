package com.HidetoOzeki.games.gunsabsurd.Entity;
public class Entity{
	public double x,y,vx,vy;
	public Entity(){
	}
	
	public Entity(double x,double y){
		this.x = x;
		this.y = y;
	}
	
	public void update(){
		x+=vx;
		y+=vy;
	}
}