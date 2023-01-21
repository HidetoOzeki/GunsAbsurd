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
}