package blocks;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 * Its a door, its activated by presurplate
 * @author Mattias
 */
public class Door extends Block implements isDoor{

	private static Rectangle door;
	
	public Door(double square_size) {
		super(square_size);

		getBackground().setFill(Color.WHITE);

		Rectangle rr = new Rectangle(square_size/10, square_size);
		rr.setFill(Color.BROWN);

		Rectangle rl = new Rectangle(square_size-square_size/10, 0, square_size/10, square_size);
		rl.setFill(Color.BROWN);

		door = new Rectangle(0, square_size*1/5, square_size, square_size*3/5);
		door.setFill(Color.CADETBLUE);

		this.getChildren().addAll(door, rr, rl);
		
	}

	public static void openDoor(){

		door.setVisible(false);
		
	}

	public static void closeDoor(){

		door.setVisible(true);
		
	}

}
