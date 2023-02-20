package com.HidetoOzeki.games.gunsabsurd.Entities;
public class Mob extends Entity {
	
	int life = 100;
	
	public Mob(double x,double y){
		super(x,y);
	}
	
	@Override
	public void update(){
		vy+=0.02;
		if(y > 0){
			vy = -1;
		}
		super.update();
	}

	public void move(){

	}
	
}