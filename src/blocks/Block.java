package blocks;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * 
 * @author Mattias
 */
public abstract class Block extends Group{
	
	private double SQUARE;
	private Rectangle bg;
	
	public Block(double square_size){
		this.SQUARE = square_size;
		bg = new Rectangle(this.SQUARE,this.SQUARE);
		bg.setFill(Color.TRANSPARENT);
		this.getChildren().add(bg);
	}
	
	public Rectangle getBackground(){
		return this.bg;
	}
	
	public double getSize(){
		return this.SQUARE;
	}

	public double getXPos() {
		double minX = this.getTranslateX();
		Parent parent = this.getParent();
		while ((parent != null)) {
			minX += parent.getTranslateX();
			parent = parent.getParent();
		}
		return minX;
	}

	public double getYPos() {
		double minY = this.getTranslateY();
		Parent parent = this.getParent();
		while ((parent != null)) {
			minY += parent.getTranslateY();
			parent = parent.getParent();
		}
		return minY;
	}

}
