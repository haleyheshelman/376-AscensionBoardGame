package devops.hw1.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

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
	
	public CardCollection() throws IOException{
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		HashMap<String,Integer> map1 = new HashMap<String, Integer>();
		HashMap<String,Integer> map2 = new HashMap<String, Integer>();
		HashMap<String,Integer> map3 = new HashMap<String, Integer>();
		HashMap<String,Integer> map4 = new HashMap<String, Integer>();
		HashMap<String,Integer> map5 = new HashMap<String, Integer>();

		BufferedImage image = null;
		
		image = ImageIO.read(new File ("cardImages/Standard/Apprentice.png"));
				
		map.put(RUNES, 1);
		apprentice = ACard.makeCard(image, "Apprentice", "none", "Hero", 0, 0, -1, map);
		
		image = ImageIO.read(new File ("cardImages/Standard/Militia1.png"));

		map1.put(POWER, 1);
		militia = ACard.makeCard(image, "Militia", "none", "Hero", 0, 0, -1, map1);
		
		image = ImageIO.read(new File ("cardImages/Heroes/Arha-Initiate.png"));

		
		map2.put(DRAW, 1);
		arhaInitiate = ACard.makeCard(image, "Arha Initiate", "Enlightened","Hero",1,1,3,map2);
		
		image = ImageIO.read(new File ("cardImages/Heroes/Demon-Slayer.png"));

		
		map3.put(POWER, 3);
		demonSlayer = ACard.makeCard(image, "Demon Slayer", "Void","Hero",4,2,2,map3);
		
		image = ImageIO.read(new File ("cardImages/Heroes/Wolf-Shaman.png"));

		
		map4.put(RUNES, 1);
		map4.put(DRAW, 1);
		wolfShaman = ACard.makeCard(image, "Wolf Shaman", "Lifebound","Hero",3,1,3,map4);
		
		
		image = ImageIO.read(new File ("cardImages/Heroes/Flytrap-Witch.png"));

		
		map5.put(HONOR, 2);
		map5.put(DRAW, 1);
		flyTrapWitch = ACard.makeCard(image, "Fly Trap Witch", "Lifebound","Hero",5,2,2,map5);
		
	}

}
