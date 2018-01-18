package Button;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import robotgame.PlayerInputStack;

public abstract class Button extends Group{

	public static double BUTTON_SIZE;
	private Polygon arrow;
	private Rectangle bg;
	public  Direction direction = Direction.NONE;

	ArrayList<Button> numberOfButtons = new ArrayList<>();

	public Button(double buttonSize) {

		BUTTON_SIZE = buttonSize;

		bg = new Rectangle(buttonSize, buttonSize);
		bg.setArcHeight(buttonSize/3);
		bg.setArcWidth(buttonSize/3);
		bg.setFill(Color.rgb(79, 83, 84));
		arrow = new Polygon(buttonSize/3, buttonSize*2/3, buttonSize/2,buttonSize*1/3,  buttonSize*2/3,buttonSize*2/3);
		arrow.setVisible(false);

		this.getChildren().addAll(bg, arrow);

		this.setOnMouseClicked(evetn->{

			PlayerInputStack.addToPlayerInputStack(this);

		});


	}
	
	public Direction getDirection(){
		return direction;
	}
	
	public void setDirection(Direction d){
		this.direction = d;
	}
	
	public void removeButton(){
		arrow.setVisible(false);
		arrow.setRotate(0);
		this.direction = Direction.NONE;
	}

	public void setLeft(){

		getArrow().setRotate(270);
		getArrow().setVisible(true);
		direction = Direction.LEFT;
		
	}

	public void setRight(){

		getArrow().setRotate(90);
		getArrow().setVisible(true);
		direction = Direction.RIGHT;

	}

	public void setUp(){

		getArrow().setVisible(true);
		direction = Direction.UP;

	}


	public Rectangle getBackground(){
		return this.bg;
	}

	public Polygon getArrow(){
		return this.arrow;
	}

	public double getSize(){
		return BUTTON_SIZE;
	}

}
