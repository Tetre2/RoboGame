package robotgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Button.Direction;
import blocks.BackgroundBlock;
import blocks.Block;
import blocks.BlockMovable;
import blocks.Door;
import blocks.Goal;
import blocks.Point;
import blocks.PressurePlate;
import blocks.WallBlock;
import javafx.scene.Group;

/**
 * Reads txt files to maps
 * @author Mattias :P
 */
public class MapInterpreter extends Group {
	
	public static final double SQUARE_SIZE = (main.WORLD_WIDTH+main.WORLD_HIGHT)/50;
	
	public static Robot r;
	public static ArrayList<Robot> allRobots = new ArrayList<>();
	private ArrayList<Integer> temp = new ArrayList<>();

	public MapInterpreter(String path) throws FileNotFoundException {
		

		Scanner fileReader = new Scanner(new File(path));

		int y = -1;
		ArrayList<Integer> robotCoords = new ArrayList<Integer>();

		while (fileReader.hasNextLine()) {
			y++;
			String line = fileReader.nextLine();
			char[] blocks = line.toCharArray();

			for (int x = 0; x < blocks.length; x++) {
				char block = blocks[x];
				Block b = null;
				switch (block) {

				case '#':
					b = new WallBlock(SQUARE_SIZE);
					break;
					
				case 'M':
//					b = new BlockMovable(SQUARE_SIZE);
					temp.add(x);
					temp.add(y);
					break;

				case 'P':
					b = new Point(SQUARE_SIZE);
					break;

				case 'X':
					b = new Goal(SQUARE_SIZE);
					break;

				case 'B':
					b = new PressurePlate(SQUARE_SIZE);
					break;
					
				case 'D':
					b = new Door(SQUARE_SIZE);
					break;

				case 'R': // ROBOT
					robotCoords.add(x);
					robotCoords.add(y);
					break;

				case ' ':
					b = null;
					break;

				default:
					b =null;
					break;

				}

				if (b != null) {
					b.setTranslateX(x * SQUARE_SIZE - 1);
					b.setTranslateY(y * SQUARE_SIZE - 1);
					this.getChildren().add(b);
				}

			}

		}
		allRobots.clear();
		for (int i = 0; i < robotCoords.size(); i += 2) {
			r= new Robot(SQUARE_SIZE);
			r.setTranslateX(robotCoords.get(i) * SQUARE_SIZE);
			r.setTranslateY(robotCoords.get(i + 1) * SQUARE_SIZE);
			this.getChildren().add(r);
			allRobots.add(r);
		}
		
		for (int i = 0; i < temp.size(); i += 2) {
			Block b = new BlockMovable(SQUARE_SIZE);
			b.setTranslateX(temp.get(i) * SQUARE_SIZE-1);
			b.setTranslateY(temp.get(i + 1) * SQUARE_SIZE-1);
			this.getChildren().add(b);
		}
		temp.clear();

	}
	
	public static void moveRobot(Direction d){
		
		switch (d) {
		case LEFT:
			allRobots.get(0).rotateRight();
			break;
			
		case RIGHT:
			allRobots.get(0).rotateLeft();
			break;
			
		case UP:
			allRobots.get(0).moveForward();
			break;

		default:
			break;
		}
		
	}
	

}
