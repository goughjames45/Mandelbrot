import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main {
	public static Color color = Color.white;

	public static void main(String[] args) {
		int width = 1000;
		int height = 1000;
		
		JFrame frame = new JFrame();
		BufferedImage panel = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(panel)));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		float x = (float) 4.0 / (width - 1);
		float y = (float) 4.0 / (height - 1);
		
		float cx = (float) 2.0 / (width/2 - 1);
		float cy = (float) 2.0 / (height/2 - 1);
		
		float tempX;
		float tempY;
		System.out.println((color.getRed()-1)+","+ (color.getGreen()-1)+","+ (color.getBlue()-1));
		
		
		for(int i = 0; i < width; i++){
			for(int j =0; j < height; j++){
				tempX = -2 + (i * x);
				tempY = -2 + (j * y);
				//System.out.println(tempX+ ", "+ tempY);
				
				if(isDivergent(tempX, tempY) == false){
					colorBlack(i, j, panel, color.BLACK);
					frame.repaint();
				}
				else{
					colorBlack(i, j, panel, color);
					frame.repaint();
					color = Color.WHITE;
				}
			}
		}
		//frame.repaint();

	}
	
	public static void colorBlack(int x, int y, BufferedImage canvas, Color c){
		int color = c.getRGB();
		canvas.setRGB(x, y, color);
	}
	
	public static boolean isDivergent(float x, float y){
		int r = 0;
		int g = 0;
		int b = 139;
		float zX;
		float zY;
		float xVal = x;
		float yVal = y;
		for(int i = 1; i <= 100; i++){
			zX = ((x*x) - (y*y)) + xVal;
			zY = (2 * x * y) + yVal;
			
			
			//System.out.println(x+", "+y);
			if((zX*zX + zY*zY) >= 4){
				for(int j = 0; j < i; j++){
					if(r + j < 255 ){
						r+=j;
					if(g+j<255){g+=j;}
					if(b+j<255){b+=j;}
						
					}
				}
				color = new Color(r, g, b);
				
				return true;
			}
			x = zX;
			y = zY;
		}
		
		return false;
		
		
	//	System.out.println(x+", "+y);
		/*if(x*x + y*y >= 4){
			return true;
		}
		else if(count == 50){
			return false;
		}
		else{
			return isDivergent((x*x) - (y*y), 2 * x * y, count+1);
		}
		*/
	}

}
