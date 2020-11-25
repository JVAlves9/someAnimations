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
		this.yPos = 0.0;
		this.size = 2 + ran.nextInt(8);	//randomize the size of the drop
		this.fall = 2 + ran.nextInt(8);	//randomize the speed of the drop
	}
	
	public void dropFall () {
		yPos+=fall;
		if (yPos > this.height) {
			line(3,-8);
		    line(-3,-8);
		    line(0,-8);
		    yPos = -1 * ( 10 + ran.nextInt(90) );
		    xPos = 1 + ran.nextInt( (int) this.width );
		}
	}
	
	private void line (double x, double y) {
		gc.beginPath();
		gc.moveTo(xPos, yPos);
		gc.lineTo(xPos + x, yPos + y);
	}
	
	public void rain() {
		gc.stroke();
		line(0, size);
	}

}
