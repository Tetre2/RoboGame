package robotgame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/**
 * Icon for the select level menu
 * @author Mattias
 */
public class NewLvl extends Group{

	public String Name;

	public NewLvl(Double size, String Name){

		this.Name = Name;

		Rectangle r = new Rectangle(size, size);
		r.setArcHeight(size/3);
		r.setArcWidth(size/3);
		r.setStrokeWidth(size/30);
		r.setStroke(Color.BLACK);
		r.setFill(Color.rgb(204, 204, 255));

		String[] s = Name.split("[.]");	

		Font f = Font.getDefault();

		try {
			f = (Font.loadFont(new FileInputStream(new File("8-BIT.TTF")), size/8));

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Text text = new Text(s[0]);
		text.setFont(f);
		text.setTranslateX(size/2-text.getLayoutBounds().getWidth()/2);
		text.setTranslateY(size/2-text.getLayoutBounds().getHeight()/2);

		this.getChildren().addAll(r, text);

		this.setOnMouseEntered(event->{

			r.setFill(Color.rgb(255, 153, 102));


		});

		this.setOnMouseExited(event->{

			r.setFill(Color.rgb(204, 204, 255));

		});



	}

	public String getName(){
		return this.Name;
	}


}
