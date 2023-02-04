package com.HidetoOzeki.games.gunsabsurd.gfx;
import java.lang.Math;
public class Screen {
	
	int w,h;
	int[] pixels;
	
	int ignore = 0;
	int xoffset = 0;
	int yoffset = 0;
	
	public Screen(int width,int height,int[] framebuffer){
		w = width;
		h = height;
		pixels = framebuffer;
	}
	
	public void clear(int col){
		for(int i = 0;i < w*h;i++){
			pixels[i] = col;
		}
	}
	
	public void put(int x,int y,int col){
		boolean xout = x < 0||x > w;
		boolean yout = y < 0||y > h;
		if(xout||yout)return;
		pixels[x+y*w] = col;
	}
	
	public void render(int x,int y,int tx,int ty,Bitmap bmp){
		render(x,y,tx,ty,8,8,bmp);
	}
	
	public void render(int x,int y,int tx,int ty,int tw,int th,Bitmap bmp){
		
		x-=xoffset;
		y-=yoffset;
		
		for(int j = 0;j < th;j++){
			int py = y+j;
			if(py < 0||py >= h)continue;
			for(int i = 0;i < tw;i++){
			int px = x+i;
			if(px < 0||px >= w)continue;
			int col = bmp.pixels[(tx+i)+(ty+j)*bmp.w];
			if(col!=ignore)pixels[px+py*w] = col;
			}
		}
	}
	
	public void render(int x,int y,Bitmap bmp){
		for(int j = 0;j < bmp.h;j++){
			int py = y+j;
			if(py < 0||py >= h)continue;
			for(int i = 0;i < bmp.w;i++){
			int px = x+i;
			if(px < 0||px >= w)continue;
			int col = bmp.pixels[i+j*bmp.w];
			if(col!=ignore)pixels[px+py*w] = col;
			}
		}
	}
	
	public void line(float x0,float y0,float x1,float y1,int col){
		float dx = x0-x1;
		float dy = y0-y1;
		float length = (float) Math.sqrt(dx*dx+dy*dy);
		float xstep = dx/length;
		float ystep = dy/length;
		/*
		for(int i = 0;i < length;i++){
			int px = Math.trunc(x0+xstep*i);
			int py = Math.trunc(y0+ystep*i);
			put(px,py,col);
		}*/
	}
}