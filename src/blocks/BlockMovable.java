package blocks;

import javafx.scene.paint.Color;
/**
 * Its a Movable Block
 * @author Mattias
 */
public class BlockMovable extends Block implements Movable{

	public BlockMovable(double square_size) {
		super(square_size);
		
		getBackground().setFill(Color.RED);
		
		
	}

}
