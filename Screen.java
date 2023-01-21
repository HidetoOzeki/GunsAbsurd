import java.lang.Math;
public class Screen {
	
	int w,h;
	int[] pixels;
	
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
	
	public void render(int x,int y,Bitmap bmp){
		for(int j = 0;j < bmp.h;j++){
			int py = y+j;
			if(py < 0||py >= h)continue;
			for(int i = 0;i < bmp.w;i++){
			int px = x+i;
			if(px < 0||px >= w)continue;
			pixels[px+py*w] = bmp.pixels[i+j*bmp.w];
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
	
		/*
	
	void polygon(Vec v1,Vec v2,Vec v3){
		Vec temp;
		
		if(v1.y > v2.y){
			temp = v2;
			v2 = v1;
			v1 = temp;
		}
		if(v1.y > v3.y){
			temp = v3;
			v3 = v1;
			v1 = temp;
		}
		if(v2.y > v3.y){
			temp = v3;
			v3 = v2;
			v2 = temp;
		}
		
		float xl = v1.x;
		float xr = v1.x;
		
		v1.round();
		v2.round();
		v3.round();
		
		if(v1.y==v2.y)v1.y--;
		
		float y13 = v3.y-v1.y;
		
		float a12 = (v2.x-v1.x)/(v2.y-v1.y);
		float a13 = (v3.x-v1.x)/(v3.y-v1.y);
		float a23 = (v3.x-v2.x)/(v3.y-v2.y);
		
		int color = 0xff00ff;
		
		if(a12 > a13){
			
			for(int y = (int)v1.y;y < (int)v2.y;y++){
				for(int x = (int)xl;x < (int)xr;x++)putf(x,y,color);
				xr+=a12;
				xl+=a13;
			}
			for(int y = (int)v2.y;y < (int)v3.y;y++){
				for(int x = (int)xl;x < (int)xr;x++)putf(x,y,color);
				xr+=a23;
				xl+=a13;
			}
			
			
		}else{
			
			for(int y = (int)v1.y;y < (int)v2.y;y++){
				for(int x = (int)xl;x < (int)xr;x++)putf(x,y,color);
				xl+=a12;
				xr+=a13;
			}
			for(int y = (int)v2.y;y < (int)v3.y;y++){
				for(int x = (int)xl;x < (int)xr;x++)putf(x,y,color);
				xl+=a23;
				xr+=a13;
			}
			
		}
		
		putf(v1.x,v1.y,0xff0000);
		putf(v2.x,v2.y,0x00ff00);
		putf(v3.x,v3.y,0x0000ff);
	}
	
	*/
	
	public int[] getData(){
		return pixels;
	}
}