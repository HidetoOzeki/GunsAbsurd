import java.awt.event.KeyEvent.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter.*;
public class InputHandler implements KeyListener{
	
	boolean[] keys = new boolean[256];
	
	public InputHandler(){
		System.out.println("InputHandler Initialized");
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		int kc = e.getKeyCode();
		keys[kc] = true;
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		int kc = e.getKeyCode();
		keys[kc] = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e){
	}
}