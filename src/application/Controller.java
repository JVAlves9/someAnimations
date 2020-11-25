package application;

import java.net.URL;
import java.util.ResourceBundle;

import classes.RainDrop;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Controller implements Initializable {

    @FXML
    private Canvas canvas;

    @FXML
    private TabPane tabs;
    
    @FXML
    private Tab tab1;

    @FXML
    private Tab tab2;
    
    private GraphicsContext gc;
    
    private RainDrop[] rdArray;
    
    private AnimationTimer ani0;
    
    public void draw() {
    	gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    		for( RainDrop rd : rdArray) {
    			rd.rain();
    			rd.dropFall();
    		}
    }
    
    public void changeTab() {	//stops or starts the animation if tab1 is selected or not
    	if( tab1.isSelected())
    		ani0.start();
    	else
    		ani0.stop();
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gc = canvas.getGraphicsContext2D();
		rdArray = new RainDrop[500];	//all droplets
		for (int i = 0; i < rdArray.length; i ++)
			rdArray[i] = new RainDrop(canvas.getWidth(), canvas.getHeight(), gc);	//populate the array
		ani0 = new Animation();
		ani0.start();
	}
    
	private class Animation extends AnimationTimer{	//animation handler
		private long lastUp = 0;
		

		@Override
		public void handle(long now) {
			if(now - lastUp >= 10_000_000) {	//updates only after 10ms
				doHandle();
				lastUp = now;
			}
		}
		
		private void doHandle() {
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());	//clear the canvas for new drawings
			for(RainDrop rd : rdArray) {
				rd.rain();	//draw droplets
				rd.dropFall();	//add to y to make it closer to the bottom
			}
		}
		
	}

}
