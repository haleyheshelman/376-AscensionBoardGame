package devops.hw1.core;

import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * An ACard that is a Hero.
 * 
 * @author bishopcc, fenogljc, gneezyn, heshelhj
 */
public class HeroCard extends ACard {

	public HeroCard() {
		this.cost = 0;
	}

	public HeroCard(int i) {
		this.cost = i;
	}

	/**
	 * Constructs a hero card that has the given information.
	 * 
	 * @param image, the card's image (as a BufferedImage)
	 * @param name, the card's name
	 * @param faction, the card's faction
	 * @param cost, the cost of the card
	 * @param honor, the amount of honor the card is worth
	 * @param rarity, the rarity of the card
	 * @param effects, the card's effect(s)
	 */
	public HeroCard(BufferedImage image, String name, String faction, String type, int cost,
			int honor, int rarity, HashMap<String, Integer> effects) {
		this.image = image;
		this.name = name;
		this.faction = faction;
		this.cost = cost;
		this.honor = honor;
		this.rarity = rarity;
		this.effects = effects;
		this.type = type;
	}

}
