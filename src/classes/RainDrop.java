package classes;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;

public class RainDrop {
	
	private double size;	//size of the drop
	private double fall;	//used to controll the speed of the drop
	
	private double xPos;
	private double yPos;	//Position of the rain drop
	
	private double height;
	private double width;	//dimensions of the canvas
	
	private Random ran;
	
	private GraphicsContext gc;	//graphic context of the canvas

	public RainDrop(double panelWidth,double panelHeight,GraphicsContext gc) {
		this.height = panelHeight;
		this.width = panelWidth;
		this.gc = gc;
		this.ran = new Random();
		this.xPos = 1 + ran.nextInt(( int )this.width);	//randomize the position where the drop spawns
		this.yPos = -ran.nextInt(20);	//randomize the height
		this.size = 2 + ran.nextInt(8);	//randomize the size of the drop
		this.fall = 2 + ran.nextInt(8);	//randomize the speed of the drop
	}
	
	public void dropFall () {
		yPos+=fall;	//make fall
		if (yPos >= this.height) {
			line(this.height,4,-6);
		    line(this.height,-4,-6);
		    line(this.height,2,-6);	// make object encounter animation
		    yPos = -1 * ( 10 + ran.nextInt(90) );	//new y position
		    xPos = 1 + ran.nextInt( (int) this.width );	//new x position
		}
	}
	
	private void line (double y0,double x, double y1) {	//make a line
		gc.beginPath();
		gc.moveTo(xPos, y0);
		gc.lineTo(xPos + x, y0 + y1);
		gc.stroke();
	}
	
	public void rain() {
		line(yPos,0, size);
	}

}
