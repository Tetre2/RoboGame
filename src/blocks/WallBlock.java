package blocks;
import javafx.scene.paint.Color;

public class WallBlock extends Block{
	
	public WallBlock(double square_size){
		super(square_size);
		getBackground().setFill(Color.BLACK);
	}
	
}
