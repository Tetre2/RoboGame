package blocks;

import javafx.scene.paint.Color;

public class BackgroundBlock extends Block implements NotCollidable{

	public BackgroundBlock(double square_size) {
		super(square_size);
		
		getBackground().setFill(Color.WHITE);
		
	}

}
