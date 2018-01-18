package blocks;

import javafx.scene.paint.Color;

public class Goal extends Block implements Win{

	public Goal(double square_size) {
		super(square_size);
		getBackground().setFill(Color.LIME);
	}

}
