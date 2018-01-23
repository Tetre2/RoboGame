package robotgame;

import java.io.File;
import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/**
 * The menu where you select level
 * @author Mattias
 */
public class SelectLvl extends Group{

	private double btnSize = (main.WORLD_WIDTH+ main.WORLD_HIGHT)/20;

	private int hori;
	private int vert;

	public ArrayList<NewLvl> lvlArr = new ArrayList<>();

	public SelectLvl(Stage primaryStage){

		int numberOfLvls = new File("src/Maps").listFiles().length;

		boolean stop = false;

		for (vert = 0; vert < 4; vert++) {

			for (hori = 0; hori < 4; hori++) {

				if(  (vert*4 + hori < numberOfLvls)){

					String[] s = new File("src/Maps").list();

					NewLvl newLvl = new NewLvl(btnSize, s[vert*4 + hori]);
					newLvl.setTranslateX(hori * main.WORLD_WIDTH/5 + main.WORLD_WIDTH/6);
					newLvl.setTranslateY(vert * main.WORLD_HIGHT/5+ main.WORLD_HIGHT/8);
					lvlArr.add(newLvl);
					newLvl.setOnMouseClicked(event->{

						main.createGame(newLvl.getName());

					});

					this.getChildren().add(newLvl);

				}else{
					stop = true;
					break;
				}
			}

			if(stop){
				break;
			}

		}


		Label back = new Label();
		back.setText("Back");
		back.setTranslateX(main.WORLD_WIDTH/30);
		back.setTranslateY(main.WORLD_HIGHT - main.WORLD_HIGHT/10);
		back.setOnMouseClicked(event->{

			primaryStage.setScene(main.menu);

		});


		back.setFont(main.getGameFont());
		this.getChildren().add(back);



	}

}
