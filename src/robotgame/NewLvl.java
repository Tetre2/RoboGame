package robotgame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class NewLvl extends Group{

	public String Name;
	
	public NewLvl(Double size, String Name){
		
		this.Name = Name;
		
		Rectangle r = new Rectangle(size, size);
		r.setArcHeight(size/3);
		r.setArcWidth(size/3);
		r.setFill(Color.BEIGE);

		String[] s = Name.split("[.]");	
		
		Font f = Font.getDefault();
		
		try {
			f = (Font.loadFont(new FileInputStream(new File("8-BIT.TTF")), size/8));

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
		Text text = new Text(s[0]);
		text.setFont(f);
		text.setTranslateX((size-text.getLayoutBounds().getWidth())/2);
		text.setTranslateY((size-text.getLayoutBounds().getHeight())/2);
		
		this.getChildren().addAll(r, text);
		
	}
	
	public String getName(){
		return this.Name;
	}
	
	
}
