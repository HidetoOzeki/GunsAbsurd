package com.HidetoOzeki.games.gunsabsurd;
import java.awt.event.KeyEvent.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter.*;
public class InputHandler implements KeyListener{
	
	boolean[] keys = new boolean[256];
	
	public InputHandler(){
		System.out.println("InputHandler Initialized");
	}

	public boolean getkeystate(int kc){
		if(!(kc > 0&&kc < keys.length))return false;
		return keys[kc];
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		setkeystate(e.getKeyCode(),true);
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		setkeystate(e.getKeyCode(),false);
	}

	public void setkeystate(int kc,boolean state){
		if(kc > 0&&kc < keys.length)keys[kc] = state;
	}
	
	@Override
	public void keyTyped(KeyEvent e){
	}
}