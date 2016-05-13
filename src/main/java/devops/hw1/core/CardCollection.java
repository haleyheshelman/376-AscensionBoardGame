package devops.hw1.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

/**
 * 
 * Creates the cards and attaches their images to that card
 *
 * @author heshelhj. Created Apr 22, 2016.
 */
public class CardCollection {

	public static ACard apprentice;
	public static ACard militia;
	public static ACard arhaInitiate;
	public static ACard demonSlayer;
	public static ACard wolfShaman;
	public static ACard flyTrapWitch;
	public static ACard asceticOfTheLidlessEye;
	public static ACard emriOneWithTheVoid;
	public static ACard arbiterOfThePrecipice;
	public static ACard arhaTemplar;
	public static ACard avatarGolem;
	public static ACard avatarOfTheFallen;
	public static ACard burrowerMarkII;
	public static ACard cetraWeaverOfStars;
	public static ACard corrosiveWidow;
	public static ACard druidsOfTheStoneCircle;
	public static ACard earthTyrant;
	public static ACard hedronCannon;
	public static ACard hedronLinkDevice;
	public static ACard korTheFerromancer;
	public static ACard landtalker;
	public static ACard lifeboundInitiate;
	public static ACard masterDhartha;
	public static ACard mechanaInitiate;
	public static ACard mephit;
	public static ACard mistakeOfCreation;
	public static ACard muramasa;
	public static ACard oziahThePeerless;
	public static ACard reactorMonk;
	public static ACard rocketCourierX99;
	public static ACard runicLycanthrope;
	public static ACard samaelsTrickster;
	public static ACard seaTyrant;
	public static ACard seerOfTheForkedPath;
	public static ACard shadeOfTheBlackWatch;
	public static ACard shadowStar;
	public static ACard snapdragon;
	public static ACard spikeVixen;
	public static ACard tabletOfTimesDawn;
	public static ACard templeLibrarian;
	public static ACard theAllSeeingEye;
	public static ACard theGrandDesign;
	public static ACard tormentedSoul;
	public static ACard twofoldAskara;
	public static ACard voidInitiate;
	public static ACard voidthirster;
	public static ACard watchmakersAltar;
	public static ACard windTyrant;
	public static ACard xeronDukeOfLies;
	public static ACard yggdrasilStaff;
	public static ACard[] cards;

	public static final String RUNES = "runes";
	public static final String POWER = "power";
	public static final String DRAW = "draw";
	public static final String HONOR = "honor";
	public static final String BANISH = "banish";
	/**
	 * Banish values
	 * 1 = hand
	 * 2 = discard
	 * 3 = center
	 * 4 = center or discard
	 * 5 = hand or discard
	 * 
	 */

	public CardCollection() throws IOException {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		HashMap<String, Integer> map3 = new HashMap<String, Integer>();
		HashMap<String, Integer> map4 = new HashMap<String, Integer>();
		HashMap<String, Integer> map5 = new HashMap<String, Integer>();
		HashMap<String, Integer> map6 = new HashMap<String, Integer>();
		HashMap<String, Integer> map7 = new HashMap<String, Integer>();
		HashMap<String, Integer> map8 = new HashMap<String, Integer>();
		HashMap<String, Integer> map9 = new HashMap<String, Integer>();
		HashMap<String, Integer> map10 = new HashMap<String, Integer>();
		HashMap<String, Integer> map11 = new HashMap<String, Integer>();
		HashMap<String, Integer> map12 = new HashMap<String, Integer>();
		HashMap<String, Integer> map13 = new HashMap<String, Integer>();
		HashMap<String, Integer> map14 = new HashMap<String, Integer>();
		HashMap<String, Integer> map15 = new HashMap<String, Integer>();
		HashMap<String, Integer> map16 = new HashMap<String, Integer>();
		HashMap<String, Integer> map17 = new HashMap<String, Integer>();
		HashMap<String, Integer> map18 = new HashMap<String, Integer>();
		HashMap<String, Integer> map19 = new HashMap<String, Integer>();
		HashMap<String, Integer> map20 = new HashMap<String, Integer>();
		HashMap<String, Integer> map21 = new HashMap<String, Integer>();
		HashMap<String, Integer> map22 = new HashMap<String, Integer>();
		HashMap<String, Integer> map23 = new HashMap<String, Integer>();
		HashMap<String, Integer> map24 = new HashMap<String, Integer>();
		HashMap<String, Integer> map25 = new HashMap<String, Integer>();
		HashMap<String, Integer> map26 = new HashMap<String, Integer>();
		HashMap<String, Integer> map27 = new HashMap<String, Integer>();
		HashMap<String, Integer> map28 = new HashMap<String, Integer>();
		HashMap<String, Integer> map29 = new HashMap<String, Integer>();
		HashMap<String, Integer> map30 = new HashMap<String, Integer>();
		HashMap<String, Integer> map31 = new HashMap<String, Integer>();
		HashMap<String, Integer> map32 = new HashMap<String, Integer>();
		HashMap<String, Integer> map33 = new HashMap<String, Integer>();
		HashMap<String, Integer> map34 = new HashMap<String, Integer>();
		HashMap<String, Integer> map35 = new HashMap<String, Integer>();
		HashMap<String, Integer> map36 = new HashMap<String, Integer>();
		HashMap<String, Integer> map37 = new HashMap<String, Integer>();
		HashMap<String, Integer> map38 = new HashMap<String, Integer>();
		HashMap<String, Integer> map39 = new HashMap<String, Integer>();
		HashMap<String, Integer> map40 = new HashMap<String, Integer>();
		HashMap<String, Integer> map41 = new HashMap<String, Integer>();
		HashMap<String, Integer> map42 = new HashMap<String, Integer>();
		HashMap<String, Integer> map43 = new HashMap<String, Integer>();
		HashMap<String, Integer> map44 = new HashMap<String, Integer>();
		HashMap<String, Integer> map45 = new HashMap<String, Integer>();
		HashMap<String, Integer> map46 = new HashMap<String, Integer>();
		HashMap<String, Integer> map47 = new HashMap<String, Integer>();
		HashMap<String, Integer> map48 = new HashMap<String, Integer>();
		HashMap<String, Integer> map49 = new HashMap<String, Integer>();

		BufferedImage image = null;

		image = ImageIO.read(new File("cardImages/Standard/Apprentice.png"));

		map.put(RUNES, 1);
		apprentice = ACard.makeCard(image, "Apprentice", "none", "Hero", 0, 0,
				-1, map);

		image = ImageIO.read(new File("cardImages/Standard/Militia1.png"));

		map1.put(POWER, 1);
		militia = ACard.makeCard(image, "Militia", "none", "Hero", 0, 0, -1,
				map1);

		image = ImageIO.read(new File("cardImages/Heroes/Arha-Initiate.png"));

		map2.put(DRAW, 1);
		arhaInitiate = ACard.makeCard(image, "Arha Initiate", "Enlightened",
				"Hero", 1, 1, 3, map2);

		image = ImageIO.read(new File("cardImages/Heroes/Demon-Slayer.png"));

		map3.put(POWER, 3);
		demonSlayer = ACard.makeCard(image, "Demon Slayer", "Void", "Hero", 4,
				2, 2, map3);

		image = ImageIO.read(new File("cardImages/Heroes/Wolf-Shaman.png"));

		map4.put(RUNES, 1);
		map4.put(DRAW, 1);
		wolfShaman = ACard.makeCard(image, "Wolf Shaman", "Lifebound", "Hero",
				3, 1, 3, map4);

		image = ImageIO.read(new File("cardImages/Heroes/Flytrap-Witch.png"));

		map5.put(HONOR, 2);
		map5.put(DRAW, 1);
		flyTrapWitch = ACard.makeCard(image, "Fly Trap Witch", "Lifebound",
				"Hero", 5, 2, 2, map5);

		image = ImageIO.read(new File(
				"cardImages/Heroes/Ascetic-of-the-Lidless-Eye.png"));

		map6.put(DRAW, 2);
		asceticOfTheLidlessEye = ACard.makeCard(image,
				"Ascetic of the Lidless Eye", "Enlightened", "Hero", 5, 2, 2,
				map6);

		image = ImageIO.read(new File(
				"cardImages/Heroes/Emri-One-with-the-Void.png"));

		map7.put(POWER, 4);
		emriOneWithTheVoid = ACard.makeCard(image, "Emri, One with the Void",
				"Void", "Hero", 6, 3, 1, map7);

		image = ImageIO.read(new File(
				"cardImages/Heroes/Arbiter-of-the-Precipice.png"));

		// TODO: Add more effects for this card. Banish one from hand
		map8.put(BANISH, 1);
		map8.put(DRAW, 2);
		arbiterOfThePrecipice = ACard.makeCard(image,
				"Arbiter of the Precipice", "Void", "Hero", 4, 1, 2, map8);

		image = ImageIO.read(new File("cardImages/Heroes/Arha-Templar.png"));

		// TODO: Add the effect, Kill one monster with 4 strength or less.

		arhaTemplar = ACard.makeCard(image, "Arha Templar", "Enlightened",
				"Hero", 4, 3, 2, map9);

		image = ImageIO.read(new File("cardImages/Heroes/Avatar-Golem.png"));

		// TODO: Add the effect, gain one honor for each faction construct

		map10.put(POWER, 2);
		avatarGolem = ACard.makeCard(image, "Avatar Golem", "Mechana", "Hero",
				4, 2, 2, map10);

		image = ImageIO.read(new File(
				"cardImages/Monsters/Avatar-of-the-Fallen.png"));

		// TODO: Add the effect, Unbanishable, gain or defeat one card in the
		// center row.
		map11.put(HONOR, 4);
		avatarOfTheFallen = ACard.makeCard(image, "Avatar of the Fallen",
				"Monster", "Monster", 7, 4, 1, map11);

		image = ImageIO.read(new File(
				"cardImages/Constructs/Burrower-Mark-II.png"));

		// TODO: Add the effect, once per turn draw when a mechana construct
		// enters your area.

		burrowerMarkII = ACard.makeCard(image, "Burrower Mark II", "Mechana",
				"Construct", 3, 3, 2, map12);

		image = ImageIO.read(new File(
				"cardImages/Heroes/Cetra-Weaver-of-Stars.png"));

		// TODO: Add the effect, acquire a hero without paying for it.

		cetraWeaverOfStars = ACard.makeCard(image, "Cetra, Weaver of Stars",
				"Lifebound", "Hero", 7, 4, 1, map13);

		image = ImageIO
				.read(new File("cardImages/Monsters/Corrosive-Widow.png"));

		// TODO: Add the effect, choose a player, then destroy (destroy=discard) one construct
		map14.put(HONOR, 3);
		corrosiveWidow = ACard.makeCard(image, "Corrosive Widow", "Monster",
				"Monster", 4, 3, 4, map14);

		image = ImageIO.read(new File(
				"cardImages/Heroes/Druids-of-the-Stone-Circle.png"));

		// TODO: Add the effect, acquire a hero without paying for it that costs
		// three or less.

		druidsOfTheStoneCircle = ACard.makeCard(image,
				"Druids of the Stone Circle", "Lifebound", "Hero", 4, 3, 2,
				map15);

		image = ImageIO.read(new File("cardImages/Monsters/Earth-Tyrant.png"));

		map16.put(DRAW, 2);
		map16.put(HONOR, 5);
		earthTyrant = ACard.makeCard(image, "Earth Tyrant", "Monster",
				"Monster", 6, 5, 2, map16);

		image = ImageIO
				.read(new File("cardImages/Constructs/Hedron-Cannon.png"));

		// TODO: Add the effect, gain one power for each mechana construct.

		hedronCannon = ACard.makeCard(image, "Hedron Cannon", "Mechana",
				"Construct", 8, 8, 1, map17);

		image = ImageIO.read(new File(
				"cardImages/Constructs/Hedron-Link-Device.png"));

		// TODO: Add the effect, you may consider all constructs as mechana
		// constructs

		hedronLinkDevice = ACard.makeCard(image, "Hedron Link Device",
				"Mechana", "Construct", 7, 7, 1, map18);

		image = ImageIO.read(new File(
				"cardImages/Heroes/Kor-the-Ferromancer.png"));

		// TODO: Add the effect, draw a card if you control two or more
		// constructs

		map19.put(POWER, 2);
		korTheFerromancer = ACard.makeCard(image, "Kor, the Ferromancer",
				"Mechana", "Hero", 3, 2, 1, map19);

		image = ImageIO.read(new File("cardImages/Heroes/Landtalker.png"));

		map20.put(RUNES, 3);
		landtalker = ACard.makeCard(image, "Landtalker", "Lifebound", "Hero",
				6, 3, 1, map20);

		image = ImageIO.read(new File(
				"cardImages/Heroes/Lifebound-Initiate.png"));

		map21.put(RUNES, 1);
		map21.put(HONOR, 1);
		lifeboundInitiate = ACard.makeCard(image, "Lifebound Initiate",
				"Lifebound", "Hero", 1, 1, 3, map21);

		image = ImageIO.read(new File("cardImages/Heroes/Master-Dhartha.png"));

		map22.put(DRAW, 3);
		masterDhartha = ACard.makeCard(image, "Master Dhartha", "Enlightened",
				"Hero", 7, 3, 1, map22);

		image = ImageIO
				.read(new File("cardImages/Heroes/Mechana-Initiate.png"));

		// TODO: Add the effect, gain one rune or power

		mechanaInitiate = ACard.makeCard(image, "Mechana Initiate", "Mechana",
				"Hero", 1, 1, 3, map23);

		image = ImageIO.read(new File("cardImages/Monsters/Mephit.png"));

		// TODO: Add the effect, banish a card from the center row
		map24.put(BANISH, 3);
		map24.put(HONOR, 2);
		mephit = ACard.makeCard(image, "Mephit", "Monster", "Monster", 3, 2, 3,
				map24);

		image = ImageIO.read(new File(
				"cardImages/Monsters/Mistake-of-Creation.png"));

		// TODO: Add the effect, banish a card from the center and/or your
		// discard
		map25.put(BANISH, 4);
		map25.put(HONOR, 4);
		mistakeOfCreation = ACard.makeCard(image, "Mistake Of Creation",
				"Monster", "Monster", 4, 4, 4, map25);

		image = ImageIO.read(new File("cardImages/Constructs/Muramasa.png"));

		map26.put(POWER, 3);
		muramasa = ACard.makeCard(image, "Muramasa", "Void", "Construct", 7, 4,
				1, map26);

		image = ImageIO.read(new File(
				"cardImages/Heroes/Oziah-the-Peerless.png"));

		// TODO: Add the effect, defeat a monster with 6 or lower strength

		oziahThePeerless = ACard.makeCard(image, "Oziah the Peerless",
				"Enlightened", "Hero", 6, 3, 1, map27);

		image = ImageIO.read(new File("cardImages/Heroes/Reactor-Monk.png"));

		// TODO: Add the effect, you pay one less for the next mechana construct
		map28.put(RUNES, 2);
		reactorMonk = ACard.makeCard(image, "Reactor Monk", "Mechana", "Hero",
				4, 2, 2, map28);

		image = ImageIO.read(new File(
				"cardImages/Constructs/Rocket-Courier-X-99.png"));

		// TODO: Add the effect, once per turn, play the next mechana construct
		// you acquire.

		rocketCourierX99 = ACard.makeCard(image, "Rocket Courier X-99",
				"Mechana", "Construct", 4, 4, 2, map29);

		image = ImageIO
				.read(new File("cardImages/Heroes/Runic-Lycanthrope.png"));

		// TODO: Add the effect, If you have played a lifebound this turn gain 2
		// power.
		map30.put(RUNES, 2);
		runicLycanthrope = ACard.makeCard(image, "Runic Lycanthrope",
				"Lifebound", "Hero", 3, 1, 2, map30);

		image = ImageIO.read(new File(
				"cardImages/Monsters/Samaels-Trickster.png"));

		map31.put(HONOR, 1);
		map31.put(RUNES, 1);
		samaelsTrickster = ACard.makeCard(image, "Samael's Trickster",
				"Monster", "Monster", 3, 1, 4, map31);
		//
		image = ImageIO.read(new File("cardImages/Monsters/Sea-Tyrant.png"));

		// TODO: Add the effect, all players destroy constructs until they have
		// 1 left
		map32.put(HONOR, 5);
		seaTyrant = ACard.makeCard(image, "Sea Tyrant", "Monster", "Monster",
				5, 5, 3, map32);

		image = ImageIO.read(new File(
				"cardImages/Heroes/Seer-of-the-Forked-Path.png"));

		// TODO: Add the effect, you may banish out of the center row.
		map33.put(BANISH, 3);
		map33.put(DRAW, 1);
		seerOfTheForkedPath = ACard.makeCard(image, "Seer of the Forked Path",
				"Enlightened", "Hero", 2, 1, 3, map33);

		image = ImageIO.read(new File(
				"cardImages/Heroes/Shade-of-the-Black-Watch.png"));

		// TODO: Add the effect, you may banish from hand or discard
		map34.put(BANISH, 5);
		map34.put(POWER, 2);
		shadeOfTheBlackWatch = ACard.makeCard(image,
				"Shade of the Black Watch", "Void", "Hero", 3, 1, 3, map34);

		image = ImageIO.read(new File("cardImages/Constructs/Shadow-Star.png"));

		// TODO: Add the effect, once per turn gain one power.

		shadowStar = ACard.makeCard(image, "Shadow Star", "Void", "Construct",
				3, 2, 2, map35);

		image = ImageIO.read(new File("cardImages/Constructs/Snapdragon.png"));

		// TODO: Add the effect, once per turn gain a rune and the first time
		// you play a lifebound gain one honor
		map36.put(RUNES, 1);
		snapdragon = ACard.makeCard(image, "Snapdragon", "Lifebound",
				"Construct", 5, 2, 2, map36);

		image = ImageIO.read(new File("cardImages/Heroes/Spike-Vixen.png"));

		map37.put(POWER, 1);
		map37.put(DRAW, 1);
		spikeVixen = ACard.makeCard(image, "Spike Vixen", "Void", "Hero", 2, 1,
				2, map37);

		image = ImageIO.read(new File(
				"cardImages/Constructs/Tablet-of-Times-Dawn.png"));

		// TODO: Add the effect, you may banish this construct to take another
		// turn

		tabletOfTimesDawn = ACard.makeCard(image, "Tablet of Time's Dawn",
				"Enlightened", "Construct", 5, 2, 1, map38);

		image = ImageIO
				.read(new File("cardImages/Heroes/Temple-Librarian.png"));

		// TODO: Add the effect, discard one card then draw two

		templeLibrarian = ACard.makeCard(image, "Temple Librarian",
				"Enlightened", "Hero", 2, 1, 3, map39);

		image = ImageIO.read(new File(
				"cardImages/Constructs/The-All-Seeing-Eye.png"));

		// TODO: Add the effect, once per turn you may draw a card

		theAllSeeingEye = ACard.makeCard(image, "The All-Seeing Eye",
				"Enlightened", "Construct", 6, 2, 1, map40);

		image = ImageIO.read(new File(
				"cardImages/Constructs/The-Grand-Design.png"));

		// TODO: Add the effect, gain two runes towards a mechana construct

		theGrandDesign = ACard.makeCard(image, "The Grand Design", "Mechana",
				"Construct", 6, 6, 2, map41);

		image = ImageIO
				.read(new File("cardImages/Monsters/Tormented-Soul.png"));

		map42.put(HONOR, 1);
		map42.put(DRAW, 1);
		tormentedSoul = ACard.makeCard(image, "Tormented Soul", "Monster",
				"Monster", 3, 1, 3, map42);

		image = ImageIO.read(new File("cardImages/Heroes/Twofold-Askara.png"));

		// TODO: Add the effect, copy the effect of a hero played this turn

		twofoldAskara = ACard.makeCard(image, "Twofold Askara", "Enlightened",
				"Hero", 4, 2, 1, map43);

		image = ImageIO.read(new File("cardImages/Heroes/Void-Initiate.png"));

		// TODO: Add the effect, you may banish one from the hand or discard
		map44.put(BANISH, 5);
		map44.put(RUNES, 1);
		voidInitiate = ACard.makeCard(image, "Void Initiate", "Void", "Hero",
				1, 1, 3, map44);

		image = ImageIO
				.read(new File("cardImages/Constructs/Voidthirster.png"));

		// TODO: Add the effect, once per turn gain one power and the first time
		// you kill a monster gain one honor

		voidthirster = ACard.makeCard(image, "Voidthirster", "Void",
				"Construct", 5, 3, 2, map45);

		image = ImageIO.read(new File(
				"cardImages/Constructs/Watchmakers-Altar.png"));

		// TODO: Add the effect, once per turn gain one rune toward a mechana
		// construct

		watchmakersAltar = ACard.makeCard(image, "Watchmaker's Altar",
				"Mechana", "Construct", 5, 5, 2, map46);

		image = ImageIO.read(new File("cardImages/Monsters/Wind-Tyrant.png"));

		map47.put(HONOR, 3);
		map47.put(RUNES, 3);
		windTyrant = ACard.makeCard(image, "Wind Tyrant", "Monster", "Monster",
				5, 3, 3, map47);

		image = ImageIO.read(new File(
				"cardImages/Monsters/Xeron-Duke-of-Lies.png"));

		// TODO: Add the effect, take a card out of each player's hand and add
		// it to your own

		xeronDukeOfLies = ACard.makeCard(image, "Xeron, Duke of Lies",
				"Monster", "Monster", 6, 3, 1, map48);

		image = ImageIO.read(new File(
				"cardImages/Constructs/Yggdrasil-Staff.png"));

		// TODO: Add the effect, once per turn gain one power, you can pay 4
		// runes for 3 honor

		yggdrasilStaff = ACard.makeCard(image, "Yggdrasil Staff", "Lifebound",
				"Construct", 4, 2, 2, map49);

		cards = new ACard[] { yggdrasilStaff, seerOfTheForkedPath, arbiterOfThePrecipice, arhaInitiate, demonSlayer, wolfShaman,
				flyTrapWitch, asceticOfTheLidlessEye, emriOneWithTheVoid,
				arhaTemplar, avatarGolem,
				avatarOfTheFallen, burrowerMarkII, cetraWeaverOfStars,
				corrosiveWidow, druidsOfTheStoneCircle,  templeLibrarian, earthTyrant,
				hedronCannon, hedronLinkDevice, korTheFerromancer, landtalker,
				lifeboundInitiate, watchmakersAltar, masterDhartha, mechanaInitiate, mephit,
				mistakeOfCreation, muramasa, oziahThePeerless, reactorMonk,
				rocketCourierX99, runicLycanthrope, samaelsTrickster,
				seaTyrant,  shadeOfTheBlackWatch,
				shadowStar, snapdragon, spikeVixen, tabletOfTimesDawn,
				 theAllSeeingEye, theGrandDesign,
				tormentedSoul, twofoldAskara, voidInitiate, voidthirster,
				windTyrant, xeronDukeOfLies };
	}

}
