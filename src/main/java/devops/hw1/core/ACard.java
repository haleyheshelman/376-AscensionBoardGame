/**
 * 
 */
package devops.hw1.core;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
	protected BufferedImage image;

	/**
	 * This returns a card with zero cost and no other special attributes.
	 * 
	 * @return
	 */

	public static ACard makeCard() {
		return new HeroCard();
	}

	/**
	 * This returns a card with cost equal to the input with no other special
	 * attributes.
	 * 
	 * @param i
	 * @return
	 */

	public static ACard makeCard(int i) {
		return new HeroCard(i);
	}

	/**
	 * This returns a card with the given information.
	 * 
	 * @param image
	 *            the image of the card (as .png file)
	 * @param name
	 *            the name of the card (i.e. "Cultist")
	 * @param faction
	 *            the card's faction (i.e. "Lifebound")
	 * @param type
	 *            the card's type (i.e. Hero, Monster, etc.)
	 * @param cost
	 *            the amount paid to obtain the card (in runes or power)
	 * @param honor
	 *            the amount of honor that the card is worth
	 * @param rarity
	 *            the number of occurrences of the card in the game
	 * @param effects
	 *            a HashMap of the card's effect(s)
	 * @return
	 */
	public static ACard makeCard(BufferedImage image, String name,
			String faction, String type, int cost, int honor, int rarity,
			HashMap<String, Integer> effects) {
		// array list of accepted card types (all in lower case, for
		// consistency)
		ArrayList<String> acceptedTypes = new ArrayList<String>();
		acceptedTypes.add("hero");
		acceptedTypes.add("monster");
		acceptedTypes.add("construct");
		acceptedTypes.add("standard");

		// before returning the card, need to do input validation
		if (name == null || type == null) {
			throw new NullPointerException(
					"The following values can not be null for a card: "
							+ "name, type, cost, honor, rarity, and effect.");
		} else if (effects.keySet().contains(null)) {
			throw new NullPointerException(
					"The following values can not be null for a card: "
							+ "name, type, cost, honor, rarity, and effect.");
		} else if (effects.keySet().contains("")
				|| effects.values().contains(0)) {
			throw new IllegalArgumentException(
					"One or more of the arguments given for the card "
							+ "were not correct.");
		} else if (!(acceptedTypes.contains(type.toLowerCase()))) {
			throw new IllegalArgumentException(
					"One or more of the arguments given for the card "
							+ "were not correct.");
		}

		// TODO: Make this not only be able to return hero cards

		return new HeroCard(image, name, faction, cost, honor, rarity, effects);
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
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(BufferedImage image) {
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

	/**
	 * Returns the hashmap of effects the card has.
	 * 
	 * @return
	 */
	public HashMap<String, Integer> getEffects() {
		return this.effects;
	}

	/**
	 * Puts an effect string and integer value pair into the hashmap of effects
	 * for the card.
	 * 
	 * @param effect
	 * @param value
	 */
	public void setEffect(String effect, int value) {
		if (effect == null) {
			return;
		}
		this.effects.put(effect, value);
	}

	public int getStrength() {
		return this.cost;
	}

}
