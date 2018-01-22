package robotgame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Button.Button;
import Button.Left;
import Button.Right;
import Button.UP;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class main extends Application{

	public static double WORLD_WIDTH = 1200;
	public static double WORLD_HIGHT = 600;

	public static Group root;
	public static Scene scene;

	private Group mainMenu = new Group();
	public static Scene menu;
	
	public static Stage primaryStage;

	public static Scene lvlComplet;
	
	private static Scene levelSelect;

	public static Font getGameFont(){
		try {
			return Font.loadFont(new FileInputStream(new File("8-BIT.TTF")), 20);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return Font.getDefault();
	}




	@Override
	public void start(Stage primaryStage) throws Exception {

		startGame(primaryStage);

		menu = new Scene(mainMenu,WORLD_WIDTH,WORLD_HIGHT);

		primaryStage.setScene(menu);
		primaryStage.show();


	}

	public void startGame(Stage primaryStage){

		this.primaryStage = primaryStage;
		
		Label start = new Label();
		start.setText("New Game");
		start.setTranslateX(WORLD_WIDTH/30);
		start.setTranslateY(WORLD_HIGHT- WORLD_HIGHT*4/10);
		start.setOnMouseClicked(event->{

			goToLvlSelect();

		});

		Label lvlSelect = new Label();
		lvlSelect.setText("Select Level");
		lvlSelect.setTranslateX(WORLD_WIDTH/30);
		lvlSelect.setTranslateY(WORLD_HIGHT- WORLD_HIGHT*3/10);
		lvlSelect.setOnMouseClicked(event->{

			goToLvlSelect();

		});



		Label quit = new Label();
		quit.setText("Quit");
		quit.setTranslateX(WORLD_WIDTH/30);
		quit.setTranslateY(WORLD_HIGHT- WORLD_HIGHT*2/10);
		quit.setOnMouseClicked(event->{

			System.exit(0);

		});

		start.setFont(getGameFont());
		quit.setFont(getGameFont());
		lvlSelect.setFont(getGameFont());


		mainMenu.getChildren().addAll(start, quit, lvlSelect);
		
		/*--------------------------------------------*/
		
		Group lvlSelectWindow = new SelectLvl(primaryStage);

		levelSelect = new Scene(lvlSelectWindow,WORLD_WIDTH,WORLD_HIGHT);
		
		
		/*--------------------------------------------*/

		Group lvlCompletRoot = new Group();
		
		Text lvlCleared = new Text("LEVEL CLEARD!");
		lvlCleared.setFont(getGameFont());
		lvlCleared.setTranslateX(WORLD_WIDTH/2-lvlCleared.getLayoutBounds().getWidth()/2);
		lvlCleared.setTranslateY(WORLD_HIGHT/10);
		
		Label back = new Label();
		back.setText("Main Menu");
		back.setTranslateX(main.WORLD_WIDTH/30);
		back.setTranslateY(main.WORLD_HIGHT - main.WORLD_HIGHT/10);
		back.setOnMouseClicked(event->{

			primaryStage.setScene(menu);

		});
		
		lvlCompletRoot.getChildren().addAll(lvlCleared, back);

		lvlComplet = new Scene(lvlCompletRoot, WORLD_WIDTH,WORLD_HIGHT);

		
		/*--------------------------------------------*/
		
	}



	public static void createButtens(){

		double BUTTEN_SIZE = (WORLD_WIDTH + WORLD_HIGHT)/36;

		Button up = new UP(BUTTEN_SIZE);
		up.setTranslateX(WORLD_WIDTH-WORLD_WIDTH/8-BUTTEN_SIZE/2);
		up.setTranslateY(WORLD_HIGHT/3);

		Button left = new Left(BUTTEN_SIZE);
		left.setTranslateX(WORLD_WIDTH-WORLD_WIDTH/8	-BUTTEN_SIZE-BUTTEN_SIZE/10);
		left.setTranslateY(WORLD_HIGHT/3+BUTTEN_SIZE+BUTTEN_SIZE/10);

		Button right = new Right(BUTTEN_SIZE);
		right.setTranslateX(WORLD_WIDTH-WORLD_WIDTH/8	+BUTTEN_SIZE/10);
		right.setTranslateY(WORLD_HIGHT/3+BUTTEN_SIZE+BUTTEN_SIZE/10);

		PlayerInputStack p = new PlayerInputStack();

		InLvlMenu options = new InLvlMenu(BUTTEN_SIZE);
		
		
		root.getChildren().addAll(up, left, right, p, options);


	}

	public static void createGame(String s){

		try {
			root = new MapInterpreter("src/Maps/"+s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		scene = new Scene(root,WORLD_WIDTH,WORLD_HIGHT);

		createButtens();

		primaryStage.setScene(scene);

	}
	
	public static void goToLvlSelect(){

		primaryStage.setScene(levelSelect);
		
	}
	
	public static void goToMainMenu(){

		primaryStage.setScene(menu);
		
	}
	

	public static void clearedLvl(){
		
		primaryStage.setScene(lvlComplet);
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
