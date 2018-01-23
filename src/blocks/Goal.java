package blocks;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 * The Goal block
 * @author Mattias
 */
public class Goal extends Block implements Win{

	public Goal(double square_size) {
		super(square_size);
		getBackground().setFill(Color.WHITE);
		
		double goalWidth = square_size/6;
		
		Rectangle r = new Rectangle(goalWidth/2, goalWidth/2, square_size-goalWidth, square_size-goalWidth);
		r.setFill(Color.TRANSPARENT);
		r.setStroke(Color.BLACK);
		r.setStrokeWidth(square_size/15);
		
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Rectangle r2 = null;
				if(((5*i)+j)%2 == 1){
				r2 = new Rectangle(goalWidth,goalWidth);
				r2.setTranslateX(goalWidth/2 + j*goalWidth);
				r2.setTranslateY(goalWidth/2 + i*goalWidth);
				this.getChildren().add(r2);
				}
			}
			
		}
		
		
		
		
		this.getChildren().add(r);
	}

}
