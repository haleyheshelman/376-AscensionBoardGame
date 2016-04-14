/**
 * 
 */
package devops.hw1.core;

import java.util.HashMap;

/**
 * @author fenogljc
 * 
 */
public abstract class ACard {

	protected int cost;
	protected HashMap<String, Integer> effects = new HashMap<String, Integer>();
	protected String faction;
	protected String name;
	protected int honor;
	protected int rarity;
	protected String image;

	public static ACard makeCard() {
		return new HeroCard();
	}

	public static ACard makeCard(int i) {
		return new HeroCard(i);
	}

	public static ACard makeCard(String image, String name, String faction,
			String type, int cost, int honor, int rarity,
			HashMap<String, Integer> effects) {
		if (type == "Hero"){
			return new HeroCard(image, name, faction, cost, honor, rarity, effects);
		}
		return new HeroCard();
	}

	/**
	 * @return the faction
	 */
	public String getFaction() {
		return faction;
	}

	/**
	 * @param faction
	 *            the faction to set
	 */
	public void setFaction(String faction) {
		this.faction = faction;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the honor
	 */
	public int getHonor() {
		return honor;
	}

	/**
	 * @param honor
	 *            the honor to set
	 */
	public void setHonor(int honor) {
		this.honor = honor;
	}

	/**
	 * @return the rarity
	 */
	public int getRarity() {
		return rarity;
	}

	/**
	 * @param rarity
	 *            the rarity to set
	 */
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @param effects
	 *            the effects to set
	 */
	public void setEffects(HashMap<String, Integer> effects) {
		this.effects = effects;
	}

	/**
	 * Returns that cost of the card.
	 * 
	 * @return
	 */
	public int getCost() {
		return this.cost;
	}

	/**
	 * Sets the cost of the card.
	 * 
	 * @return
	 */
	public void setCost(int i) {
		this.cost = i;
	}

	public HashMap<String, Integer> getEffects() {
		return this.effects;
	}

	public void setEffect(String effect, int value) {
		if (effect == null) {
			return;
		}
		this.effects.put(effect, value);
	}

}
