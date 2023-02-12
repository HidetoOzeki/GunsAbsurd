package com.HidetoOzeki.games.gunsabsurd.gfx;
import java.lang.Math;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.GraphicsEnvironment;
public class Screen {
	
	int w,h;

	int[] pixels;
	Graphics context;
	
	int ignore = 0;
	int xoffset = 0;
	int yoffset = 0;

	int drawcolor = 0;
	boolean centertext = false;
	Font font;
	
	public Screen(int width,int height,BufferedImage image){
		w = width;
		h = height;
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		context = image.getGraphics();
	}

	public void setOffset(int x,int y){
		xoffset = x;
		yoffset = y;
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

	public void rectangle(int x,int y,int sx,int sy){
		x-=xoffset;
		y-=yoffset;
		for(int j = 0;j < sy;j++){
			int py = y+j;
			if(py < 0||py >= h)continue;
			for(int i = 0;i < sx;i++){
			int px = x+i;
			if(px < 0||px >= w)continue;
			pixels[px+py*w] = drawcolor;
			}
		}
	}

	public void setDrawColor(int col){
		this.drawcolor = col;
		context.setColor(new Color(col));
	}

	public String[] getAvailableFont(){
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fonts = ge.getAvailableFontFamilyNames();
		return fonts;
	}

	public void setFont(String f,boolean bold,boolean center,int size){
		font = new Font(f,bold ? Font.BOLD : Font.PLAIN,size);
		context.setFont(font);
		centertext = center;
	}

	public void drawText(String text,int x,int y){
		if(centertext){
			FontMetrics fm = context.getFontMetrics(font);
			x-=fm.stringWidth(text)/2;
		}
		context.drawString(text,x,y);
	}

	public int getWidth(){return w;}
	public int getHeight(){return h;}
}