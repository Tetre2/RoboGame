package blocks;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import robotgame.main;
/**
 * Its a collectable point
 * @author Mattias
 */
public class Point extends Block implements Collectible{

	public Point(double square_size) {
		super(square_size);

		Circle c = new Circle(square_size/2, square_size/2, square_size/4);
		c.setFill(Color.YELLOW);
		c.setStroke(Color.BLACK);
		c.setStrokeWidth(square_size/15);
		
		Text t = new Text("$");
		t.setFont(main.getGameFont((int) square_size/4));
		t.setTranslateX(square_size/2 - t.getLayoutBounds().getWidth()/2);
		t.setTranslateY(square_size/2 + t.getLayoutBounds().getHeight()/3);
		this.getChildren().addAll(c,t);
		
		
	}

}
