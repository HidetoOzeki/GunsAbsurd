package com.HidetoOzeki.games.gunsabsurd.gfx;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


public class Bitmap{
	int[] pixels;
	int w,h;
	public Bitmap(String filename){
		
		BufferedImage image;
		
		try {
			image = ImageIO.read(new File(filename));
			w = image.getWidth();
			h = image.getHeight();
			pixels = image.getRGB(0,0,w,h,null,0,w);
		} catch(IOException e) {
			
		}
	}
	
	public Bitmap(int w,int h){
		pixels = new int[w*h];
		this.w = w;
		this.h = h;
	}
	
	public void fill(int col){
		for(int i = 0;i < w*h;i++){
			pixels[i] = col;
		}
	}
	
	public void GenerateGrid(int xs,int ys,int gridcol){
		for(int y = 0;y < h;y+=ys){
			for(int x = 0;x < w;x++){
				pixels[x+y*w] = gridcol;
			}
		}
		for(int x = 0;x < w;x+=xs){
			for(int y = 0;y < h;y++){
				pixels[x+y*w] = gridcol;
			}
		}
	}
	
	public void saveBitmap(String filename,String ext){
		try {
		File out = new File(filename+"."+ext);
		BufferedImage image = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		image.setRGB(0,0,w,h,pixels,0,w);
		ImageIO.write(image,ext,out);
		} catch(IOException e) {
		}
	}
}