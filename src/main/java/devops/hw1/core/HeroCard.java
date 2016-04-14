package devops.hw1.core;

import java.util.HashMap;

public class HeroCard extends ACard {
	
	public HeroCard(){
		this.cost = 0;
	}
	
	public HeroCard(int i){
		this.cost = i;
	}

	/**
	 * @param image
	 * @param name
	 * @param faction
	 * @param cost
	 * @param honor
	 * @param rarity
	 * @param effects
	 */
	public HeroCard(String image, String name, String faction, int cost,
			int honor, int rarity, HashMap<String, Integer> effects) {
		this.image = image;
		this.name = name;
		this.faction = faction;
		this.cost = cost;
		this.honor = honor;
		this.rarity = rarity;
		this.effects = effects;
	}

}
