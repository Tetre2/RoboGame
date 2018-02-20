package robotgame;

import java.util.ArrayList;
import java.util.Scanner;

public class SavedData {

	public static ArrayList<String> LvlData = new ArrayList<>();
	
	SavedData(){
		
		
		
		Scanner sc = new Scanner("SaveData.txt");
		int hej = 0;
		while(sc.hasNextLine()){
			hej++;
		}
		
		if(LvlData.size() >= hej){
			LvlData.clear();
			while(sc.hasNextLine()){
				LvlData.add(sc.nextLine());
			}
			
		}
		
		
		sc.close();
		
		
//		SelectLvl.lvlArr
		
		
		
		
		
		
		
	}
	
	
	
	
}
