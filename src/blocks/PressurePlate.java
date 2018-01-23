package blocks;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import robotgame.main;
/**
 * When pressed door is opened
 * @author Mattias
 */
public class PressurePlate extends Block implements NotCollidable{

	public static boolean isPressed = false;

	public PressurePlate(double square_size) {
		super(square_size);

		Rectangle r = new Rectangle(square_size-square_size/10,square_size-square_size/10);
		r.setTranslateX(square_size/20);
		r.setTranslateY(square_size/20);
		r.setArcHeight(square_size/3);
		r.setArcWidth(square_size/3);
		r.setFill(Color.BLUEVIOLET);

		Circle c = new Circle(square_size/4);
		c.setTranslateX(square_size/2);
		c.setTranslateY(square_size/2);
		c.setFill(Color.SPRINGGREEN);


		this.getChildren().addAll(r,c);
		
		AnimationTimer at = new AnimationTimer() {
			Long Time = (long) 0; 
			
			@Override
			public void handle(long now) {

				if(now - Time >= 1000000){
					Time = now;
					updateCheckCollision();
				}
				
			}
		};
		
		at.start();
	}
	
	public void updateCheckCollision(){
		
		if(checkCollision(main.root)){
			
			isPressed = true;
			Door.openDoor();
			
		}else{
			isPressed = false;
			Door.closeDoor();
		}
	}

	private boolean checkCollision(Node n){

		if (n == null || n.equals(this)) {
			return false; // Ignore n
		}

		else if(!n.equals(main.root)){

			double totPosX = n.getTranslateX();
			double totPosY = n.getTranslateY();
			Parent p = n.getParent();


			while(p.getParent() != null){

				totPosX += p.getTranslateX();
				totPosY += p.getTranslateY();

				p = p.getParent();

			}

			double width = n.getBoundsInLocal().getWidth();
			double height = n.getBoundsInLocal().getHeight();

			Rectangle r1 = new Rectangle(this.getXPos(), this.getYPos(), this.getSize(), this.getSize());

			if(r1.intersects(totPosX+1, totPosY+1, width-2, height-2)){
			
				return true;
			}

		}


		else if (n instanceof Parent) {

			for (Node childNode : ((Parent) n).getChildrenUnmodifiable()) {

				if (checkCollision(childNode)){

					return true;

				}

			}
		}


		return false;



	}

}
