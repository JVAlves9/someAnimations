package application;

import java.net.URL;
import java.util.ResourceBundle;

import classes.RainDrop;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TabPane;

public class Controller implements Initializable {

    @FXML
    private Canvas canvas;

    @FXML
    private TabPane tabs;
    
    private GraphicsContext gc;
    
    private RainDrop[] rdArray;
    
    public void draw() {
    	gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    		for( RainDrop rd : rdArray) {
    			rd.rain();
    			rd.dropFall();
    		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gc = canvas.getGraphicsContext2D();
		rdArray = new RainDrop[500];
		for (int i = 0; i < rdArray.length; i ++)
			rdArray[i] = new RainDrop(canvas.getWidth(), canvas.getHeight(), gc);
		AnimationTimer ani = new Animation();
		ani.start();
	}
    
	private class Animation extends AnimationTimer{

		@Override
		public void handle(long now) {
			doHandle();
			
		}
		
		private void doHandle() {
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			for(RainDrop rd : rdArray) {
				rd.rain();
				rd.dropFall();
			}
		}
		
	}

}
