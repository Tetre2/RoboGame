package robotgame;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class InLvlMenu extends Group{
	
	public InLvlMenu(double BUTTEN_SIZE) {
		
		Rectangle optionsBtn = new Rectangle(BUTTEN_SIZE, BUTTEN_SIZE);
		optionsBtn.setFill(Color.TRANSPARENT);
		optionsBtn.setStroke(Color.BLACK);
		optionsBtn.setArcHeight(BUTTEN_SIZE/3);
		optionsBtn.setArcWidth(BUTTEN_SIZE/3);
		
		this.getChildren().add(optionsBtn);
		
	}
	
	
}
