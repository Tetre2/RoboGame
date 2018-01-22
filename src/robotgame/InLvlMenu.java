package robotgame;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class InLvlMenu extends Group{

	public InLvlMenu(double BUTTEN_SIZE) {

		Group otionBtn = new Group();
		otionBtn.setTranslateX(main.WORLD_WIDTH-BUTTEN_SIZE- BUTTEN_SIZE/10);
		otionBtn.setTranslateY(BUTTEN_SIZE/10);

		Rectangle oBtn = new Rectangle(BUTTEN_SIZE, BUTTEN_SIZE);
		oBtn.setFill(Color.TRANSPARENT);
		oBtn.setStroke(Color.BLACK);
		oBtn.setStrokeWidth(BUTTEN_SIZE/15);
		oBtn.setArcHeight(BUTTEN_SIZE/3);
		oBtn.setArcWidth(BUTTEN_SIZE/3);

		otionBtn.getChildren().addAll(oBtn);

		for (int i = 1; i <= 3; i++) {

			Rectangle r = new Rectangle(BUTTEN_SIZE/2,BUTTEN_SIZE/10);
			r.setTranslateY(i*BUTTEN_SIZE/4 - BUTTEN_SIZE/20);
			r.setTranslateX(BUTTEN_SIZE/4);
			otionBtn.getChildren().addAll(r);	

		}


		Group g = new Group();
		g.setTranslateX(main.WORLD_WIDTH/2-main.WORLD_WIDTH/4);
		g.setTranslateY(main.WORLD_HIGHT/2- main.WORLD_HIGHT*2/3/2);

		double pauseWindowWidth = main.WORLD_WIDTH/2;
		double pauseWindowHight = main.WORLD_HIGHT*2/3;

		Rectangle bg = new Rectangle(pauseWindowWidth,pauseWindowHight);
		bg.setStrokeWidth(BUTTEN_SIZE/15);
		bg.setStroke(Color.BLACK);
		bg.setArcHeight(BUTTEN_SIZE/3);
		bg.setArcWidth(BUTTEN_SIZE/3);
		bg.setFill(Color.WHITE);

		Rectangle blure = new Rectangle(main.WORLD_WIDTH, main.WORLD_HIGHT);
		blure.setTranslateX(-main.WORLD_WIDTH/2+main.WORLD_WIDTH/4);
		blure.setTranslateY(-main.WORLD_HIGHT/2+main.WORLD_HIGHT*2/3/2);
		blure.setFill(Color.rgb(234, 250, 255, 0.5));


		Group resume = createTextBtn("Resume", main.getGameFont());
		resume.setTranslateX(pauseWindowWidth/2-resume.getBoundsInLocal().getMaxX()/2);
		resume.setTranslateY((pauseWindowHight -resume.getBoundsInLocal().getMaxY())/4);
		resume.setOnMouseClicked(event->{

			g.setVisible(false);

		});



		Group selectLvl = createTextBtn("Select level", main.getGameFont());
		selectLvl.setTranslateX(pauseWindowWidth/2 -selectLvl.getBoundsInLocal().getMaxX()/2);
		selectLvl.setTranslateY((pauseWindowHight -selectLvl.getBoundsInLocal().getMaxY()/2)/2);
		selectLvl.setOnMouseClicked(event->{

			main.goToLvlSelect();

		});



		Group mainMenu = createTextBtn("Main menu", main.getGameFont());
		mainMenu.setTranslateX(pauseWindowWidth/2 -mainMenu.getBoundsInLocal().getMaxX()/2);
		mainMenu.setTranslateY((pauseWindowHight -mainMenu.getBoundsInLocal().getMaxY()/2)*3/4);
		mainMenu.setOnMouseClicked(event->{

			main.goToMainMenu();

		});





		g.getChildren().addAll(blure,bg, resume, selectLvl, mainMenu);
		this.getChildren().addAll(otionBtn, g);



		otionBtn.setOnMouseClicked(event->{

			g.setVisible(true);

		});

		blure.setOnMouseClicked(event->{

			g.setVisible(false);

		});



	}

	private Group createTextBtn(String s, Font f){

		Text t = new Text(s);
		t.setFont(f);

		double textWidth = t.getLayoutBounds().getWidth();
		double textHight = t.getLayoutBounds().getHeight();

		Rectangle r = new Rectangle(-textWidth/8, -textHight-textHight/8, textWidth+ textWidth/4, textHight+ textHight/2);
		r.setArcHeight(textHight/3);
		r.setArcWidth(textHight/3);
		r.setStrokeWidth(textHight/15);
		r.setStroke(Color.BLACK);
		r.setFill(Color.rgb(204, 204, 255));

		Group g = new Group();
		g.getChildren().addAll(r,t);

		
		g.setOnMouseEntered(event->{

			r.setFill(Color.rgb(255, 153, 102));

		});

		g.setOnMouseExited(event->{

			r.setFill(Color.rgb(204, 204, 255));

		});
		
		
		return g;

	}


}
