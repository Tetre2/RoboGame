package blocks;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Point extends Block implements Collectible{

	public Point(double square_size) {
		super(square_size);

		Circle c = new Circle(square_size/2, square_size/2, square_size/4);
		c.setFill(Color.YELLOW);
		this.getChildren().add(c);
		
		
	}

}
