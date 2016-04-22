package devops.hw1.core;

import java.util.HashMap;

public class CardCollection {
	
	public static ACard apprentice;
	public static ACard militia;
	public static ACard arhaInitiate; //draw 1
	public static ACard demonSlayer; //power 3
	public static ACard wolfShaman; //1 rune and draw card
	public static ACard flyTrapWitch; //2 honor and draw card
	
	public static final String RUNES = "runes";
	public static final String POWER = "power";
	public static final String DRAW = "draw";
	public static final String HONOR = "honor";
	
	public void makeCard(){
		HashMap<String,Integer> map = new HashMap<>();
		map.put("rune", 1);
		apprentice = ACard.makeCard("cardImages/Standard/Apprentice.png", "Apprentice", "none", "Hero", 0, 0, -1, map);
		
		map.clear();
		
		map.put("power", 1);
		militia = ACard.makeCard("cardImages/Standard/Militia1.png", "Militia", "none", "Hero", 0, 0, -1, map);
		
		map.clear();
		
		map.put("draw", 1);
		arhaInitiate = ACard.makeCard("cardImages/Heroes/Arha-Initiate.png", "Arha Initiate", "Enlightened","Hero",1,1,3,map);
		
		map.clear();
		
		map.put("power", 3);
		demonSlayer = ACard.makeCard("cardImages/Heroes/Demon-Slayer.png", "Demon Slayer", "Void","Hero",4,2,2,map);
		
		map.clear();
		
		map.put("rune", 1);
		map.put("draw", 1);
		wolfShaman = ACard.makeCard("cardImages/Heroes/Wolf-Shaman.png", "Wolf Shaman", "Lifebound","Hero",3,1,3,map);
		
		map.clear();
		
		map.put("honor", 2);
		map.put("draw", 1);
		flyTrapWitch = ACard.makeCard("cardImages/Heroes/Flytrap-Witch.png", "Fly Trap Witch", "Lifebound","Hero",5,2,2,map);
		
	}

}
