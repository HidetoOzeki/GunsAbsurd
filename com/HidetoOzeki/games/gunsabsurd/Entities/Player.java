package com.HidetoOzeki.games.gunsabsurd.Entities;
import com.HidetoOzeki.games.gunsabsurd.gfx.Screen;
public class Player extends Mob{
    public Player(){
        super(0,-100);
    }

    public void update(){
        super.update();
    }

    @Override
    public void render(Screen screen){
        super.render(screen);
        screen.setDrawColor(0xffff00);
        screen.rectangle((int)x-5,(int)y-5,10,10);
    }
}