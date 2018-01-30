package robotgame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import Button.Button;
import Button.Left;
import Button.Right;
import Button.UP;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * The main class
 * @author Mattias :P
 */
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

	private static AnimationTimer gameTimer;

	public static Font getGameFont(){
		try {
			return Font.loadFont(new FileInputStream(new File("8-BIT.TTF")), (WORLD_WIDTH+WORLD_HIGHT)/90);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return Font.getDefault();
	}

	public static Font getGameFont(int i){
		try {
			return Font.loadFont(new FileInputStream(new File("8-BIT.TTF")), i);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return Font.getDefault();
	}




	@Override
	public void start(Stage primaryStage) throws Exception {

		startGame(primaryStage);

		menu = new Scene(mainMenu,WORLD_WIDTH,WORLD_HIGHT);

		primaryStage.setTitle("Robot Game");
		primaryStage.setScene(menu);
		primaryStage.show();

		data();

	}

	public void data() throws IOException{

		try (FileWriter fw = new FileWriter("savedData.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw)){
			
			out.print("dkjfks ");
			
		} catch (IOException e) {
			
//			PrintWriter writer = new PrintWriter("SavedData.txt", "UTF-8");
//			writer.println("The first line");
//			writer.println("The second line");
//			writer.close();
//
//			byte data[] = null;
//			FileOutputStream out = new FileOutputStream("SavedData");
//			out.write(data);
//			out.close();
			System.out.println("jfd");
			
		}
		
		
		
		FileWriter fw = new FileWriter("savedData.txt",true); //the true will append the new data
	    fw.write("add a line\n");//appends the string to the file
	    fw.close();


	}

	private void startGame(Stage pStage){

		primaryStage = pStage;

		mainMenuSetup();

		/*--------------------------------------------*/

		Group lvlSelectWindow = new SelectLvl(primaryStage);

		levelSelect = new Scene(lvlSelectWindow,WORLD_WIDTH,WORLD_HIGHT);


		/*--------------------------------------------*/

		Group lvlCompletRoot = new Group();

		Text lvlCleared = new Text("LEVEL CLEARD!");
		lvlCleared.setFont(getGameFont());
		lvlCleared.setTranslateX(WORLD_WIDTH/2-lvlCleared.getLayoutBounds().getWidth()/2);
		lvlCleared.setTranslateY(WORLD_HIGHT/10);

		Group back = createTextBtn("Main Menu", getGameFont());
		back.setTranslateX(main.WORLD_WIDTH/30);
		back.setTranslateY(main.WORLD_HIGHT - main.WORLD_HIGHT/10);
		back.setOnMouseClicked(event->{

			primaryStage.setScene(menu);

		});

		lvlCompletRoot.getChildren().addAll(lvlCleared, back);

		lvlComplet = new Scene(lvlCompletRoot, WORLD_WIDTH,WORLD_HIGHT);


		/*--------------------------------------------*/

	}


	private void mainMenuSetup(){

		Group start = createTextBtn("New Game", getGameFont());
		start.setTranslateX(WORLD_WIDTH/30);
		start.setTranslateY(WORLD_HIGHT- WORLD_HIGHT*4/10);
		start.setOnMouseClicked(event->{

			goToLvlSelect();

		});

		Group lvlSelect = createTextBtn("Select Level", getGameFont());
		lvlSelect.setTranslateX(WORLD_WIDTH/30);
		lvlSelect.setTranslateY(WORLD_HIGHT- WORLD_HIGHT*3/10);
		lvlSelect.setOnMouseClicked(event->{

			goToLvlSelect();

		});

		Group quit = createTextBtn("Quit", getGameFont());
		quit.setTranslateX(WORLD_WIDTH/30);
		quit.setTranslateY(WORLD_HIGHT- WORLD_HIGHT*2/10);
		quit.setOnMouseClicked(event->{

			System.exit(0);

		});



		createOverSizedRobot();

		Text welcome = new Text("Welcome to the Robot Game");
		welcome.setFont(getGameFont( (int) (WORLD_HIGHT + WORLD_WIDTH)/70));
		welcome.setTranslateX(WORLD_WIDTH/2 - welcome.getLayoutBounds().getWidth()/2);
		welcome.setTranslateY(WORLD_HIGHT/10);

		mainMenu.getChildren().addAll(start, quit, lvlSelect, welcome);

	}


	private void createOverSizedRobot(){

		double SQUARE_SIZE = (WORLD_HIGHT + WORLD_WIDTH)/4;
		final Color GRAY = Color.GRAY;

		final double SIZE = SQUARE_SIZE - 2;
		final double MIDDLE = SIZE / 2;
		final double BODY_RADIUS = (SIZE - SIZE / 4) / 2;
		final double EYE_ANGLE = 20;
		final double BACK_ANGLE = 60;
		final double EYE_RADIUS = SIZE / 15;
		final double WHEEL_SIZE = 0.9 * SIZE;

		Rectangle bg = new Rectangle();
		bg.setWidth(SIZE);
		bg.setHeight(SIZE);
		bg.setFill(Color.TRANSPARENT);

		Arc body = new Arc();
		body.setRadiusX(BODY_RADIUS);
		body.setRadiusY(BODY_RADIUS);
		body.setCenterX(MIDDLE);
		body.setCenterY(MIDDLE);
		body.setStartAngle(-BACK_ANGLE);
		body.setLength(180 + 2 * BACK_ANGLE);
		body.setFill(GRAY);

		Eye leftEye = new Eye();
		leftEye.setRadius(EYE_RADIUS);
		leftEye.setCenterX(MIDDLE - BODY_RADIUS * Math.cos(Math.toRadians(90 - EYE_ANGLE)));
		leftEye.setCenterY(MIDDLE - BODY_RADIUS * Math.sin(Math.toRadians(90 - EYE_ANGLE)));
		leftEye.setFill(Color.LIME);

		Eye rightEye = new Eye();
		rightEye.setRadius(EYE_RADIUS);
		rightEye.setCenterX(MIDDLE + BODY_RADIUS * Math.cos(Math.toRadians(90 - EYE_ANGLE)));
		rightEye.setCenterY(MIDDLE - BODY_RADIUS * Math.sin(Math.toRadians(90 - EYE_ANGLE)));
		rightEye.setFill(Color.LIME);

		Rectangle wheels = new Rectangle();
		wheels.setWidth(WHEEL_SIZE);
		wheels.setHeight(BODY_RADIUS * Math.sin(Math.toRadians(BACK_ANGLE)) * 1.5);
		wheels.setTranslateX((SIZE - WHEEL_SIZE) / 2);
		wheels.setTranslateY(MIDDLE - wheels.getHeight() / 2);
		wheels.setFill(Color.LIME);

		Polygon triangle = new Polygon(MIDDLE + BODY_RADIUS / 2, MIDDLE, MIDDLE - BODY_RADIUS / 2, MIDDLE, MIDDLE,
				MIDDLE - Math.sqrt(3) * (BODY_RADIUS / 2));
		triangle.setTranslateY(Math.sqrt(3) * (BODY_RADIUS / 6));
		triangle.setFill(Color.LIME);

		Group gr = new Group();

		gr.getChildren().addAll(bg, rightEye, leftEye, wheels, body, triangle);
		gr.setTranslateX(WORLD_WIDTH/2);
		gr.setTranslateY(WORLD_HIGHT/3);

		mainMenu.getChildren().add(gr);

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

	public static void createTimer(){
		Rectangle r = new Rectangle(WORLD_WIDTH-WORLD_WIDTH/10-WORLD_WIDTH/50, WORLD_HIGHT-WORLD_HIGHT/8-WORLD_HIGHT/30, WORLD_WIDTH/10, WORLD_HIGHT/8);
		r.setArcHeight(WORLD_WIDTH/10/3);
		r.setArcWidth(WORLD_WIDTH/10/3);
		r.setStrokeWidth(WORLD_WIDTH/10/30);
		r.setStroke(Color.BLACK);
		r.setFill(Color.rgb(136, 143, 233));
		
		Text t = new Text("0");
		t.setFont(getGameFont());
		t.setTranslateX(WORLD_WIDTH-WORLD_WIDTH/10);
		t.setTranslateY(WORLD_HIGHT-WORLD_HIGHT/8+t.getLayoutBounds().getHeight());
		
		
		
		gameTimer = new AnimationTimer() {

			long time = 0;
			int counter = 0;
			@Override
			public void handle(long now) {

				if(now-time >= 1_000_000_000){
					time = now;

					counter++;
					t.setText(counter+"");

				}
			}
		};
		startGameTimer();
		root.getChildren().addAll(r,t);
	}

	public static void startGameTimer(){
		gameTimer.start();
	}

	public static void stopGameTimer(){
		gameTimer.stop();
	}

	public static void createGame(String s){

		try {
			root = new MapInterpreter("src/Maps/"+s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		createTimer();

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

	public static Group createTextBtn(String s, Font f){

		Text t = new Text(s);
		t.setFont(f);

		double textWidth = t.getLayoutBounds().getWidth();
		double textHight = t.getLayoutBounds().getHeight();

		Text x = new Text("x");
		x.setFont(f);
		double wordSpacing = x.getLayoutBounds().getWidth();

		Rectangle r = new Rectangle(textWidth+ wordSpacing*2, textHight+ textHight/2);
		r.setArcHeight(textHight/3);
		r.setArcWidth(textHight/3);
		r.setStrokeWidth(textHight/15);
		r.setStroke(Color.BLACK);
		r.setFill(Color.rgb(204, 204, 255));


		t.setTranslateX(wordSpacing);
		t.setTranslateY(textHight + textHight/8);

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


	public static void main(String[] args) {
		launch(args);
	}

}
