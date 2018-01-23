package robotgame;

import Button.Button;
import Button.Direction;
import javafx.scene.Group;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
/**
 * The Bar where the button pressed is visualy stored
 * @author Mattias :P
 */
public class PlayerInputStack extends Group{

	public static Button[] playerInputStackButtons = new Button[10];
	private static Group lockalGroup = new Group();

	public PlayerInputStack() {

		

		Rectangle bg = new Rectangle(10*(Button.BUTTON_SIZE + 2*Button.BUTTON_SIZE/5) + 2*Button.BUTTON_SIZE/5  ,  2* Button.BUTTON_SIZE);
		bg.setTranslateX(main.WORLD_WIDTH/12);
		bg.setTranslateY((main.WORLD_HIGHT - main.WORLD_HIGHT*19/84) - Button.BUTTON_SIZE/2);
		bg.setFill(Color.rgb(136, 143, 233));
		this.getChildren().add(bg);

		newButtonSetUp();
		
		Group exeStack = new Group();
		
		Circle cir = new Circle(Button.BUTTON_SIZE/2);
		cir.setStrokeWidth(Button.BUTTON_SIZE/15);
		cir.setStroke(Color.BLACK);
		cir.setFill(Color.LIME);
		
		Polygon arrow = new Polygon(-Button.BUTTON_SIZE/4,Button.BUTTON_SIZE/4, 0,-Button.BUTTON_SIZE/4, Button.BUTTON_SIZE/4,Button.BUTTON_SIZE/4);
		arrow.setRotate(90);
		
		exeStack.getChildren().addAll(cir, arrow);
		exeStack.setTranslateX(10*(Button.BUTTON_SIZE + 2*Button.BUTTON_SIZE/5) + 2*Button.BUTTON_SIZE/5 + main.WORLD_WIDTH* 1.5/12);
		exeStack.setTranslateY((main.WORLD_HIGHT - main.WORLD_HIGHT*19/84));
		
		exeStack.setOnMouseClicked(event->{
			
			for (int i = 0; i < playerInputStackButtons.length; i++) {
				
				if(!(playerInputStackButtons[i].getDirection() == Direction.NONE)){
					
					MapInterpreter.moveRobot(playerInputStackButtons[i].getDirection());
				
				}
			}
			
			newButtonSetUp();
			
		});
		
		Group cancel = new Group();
		
		Rectangle r = new Rectangle(Button.BUTTON_SIZE, Button.BUTTON_SIZE);
		r.setFill(Color.RED);
		Rectangle inerR = new Rectangle(Button.BUTTON_SIZE-Button.BUTTON_SIZE/3, Button.BUTTON_SIZE-Button.BUTTON_SIZE/3);
		inerR.setTranslateX(Button.BUTTON_SIZE/6);
		inerR.setTranslateY(Button.BUTTON_SIZE/6);
		
		Rectangle x1 = new Rectangle(Button.BUTTON_SIZE/12, Button.BUTTON_SIZE/2);
		x1.setFill(Color.RED);
		x1.setRotate(45);
		x1.setTranslateX(Button.BUTTON_SIZE* 6/12 - Button.BUTTON_SIZE/24);
		x1.setTranslateY(Button.BUTTON_SIZE/4);
		
		Rectangle x2 = new Rectangle(Button.BUTTON_SIZE/12, Button.BUTTON_SIZE/2);
		x2.setFill(Color.RED);
		x2.setRotate(-45);
		x2.setTranslateX(Button.BUTTON_SIZE* 6/12 - Button.BUTTON_SIZE/24);
		x2.setTranslateY(Button.BUTTON_SIZE/4);
		
		
		cancel.getChildren().addAll(r,inerR, x1, x2);
		cancel.setTranslateX(10*(Button.BUTTON_SIZE + 2*Button.BUTTON_SIZE/5) + 2*Button.BUTTON_SIZE/5 + main.WORLD_WIDTH* 1.5/12 - Button.BUTTON_SIZE/2);
		cancel.setTranslateY((main.WORLD_HIGHT - main.WORLD_HIGHT*19/84) + Button.BUTTON_SIZE/2);
		
		cancel.setOnMouseClicked(event->{
			
			for (int i = 0; i < playerInputStackButtons.length; i++) {
				playerInputStackButtons[i].removeButton();
			}
			
			
		});
		
		
		this.getChildren().addAll(lockalGroup, exeStack, cancel);

	}


	
	public void newButtonSetUp(){
		
			lockalGroup.getChildren().clear();
		
			for (int i = 0; i < 10; i++) {

			Button btn = new Button(Button.BUTTON_SIZE) {};
			
			btn.setOnMouseClicked(event->{
				
				if (event.getButton() == MouseButton.SECONDARY) {
					
					btn.removeButton();
				}
			});
			
			playerInputStackButtons[i] = btn;

			btn.setTranslateX(main.WORLD_WIDTH/12 + i*(Button.BUTTON_SIZE + 2*Button.BUTTON_SIZE/5) + 2*Button.BUTTON_SIZE/5);
			btn.setTranslateY(main.WORLD_HIGHT - main.WORLD_HIGHT*19/84);

			lockalGroup.getChildren().add(btn);

		}
		
	}
	
	public static void addToPlayerInputStack(Button button){

		for (int i = 0; i < playerInputStackButtons.length; i++) {

			if(playerInputStackButtons[i].getDirection() == Direction.NONE){

				switch (button.getDirection()) {
				case LEFT:

					playerInputStackButtons[i].setLeft();
					break;

				case RIGHT:

					playerInputStackButtons[i].setRight();
					break;

				case UP:

					playerInputStackButtons[i].setUp();
					break;

				default:
					break;
				}


				break;

			}
		}
	}


}
