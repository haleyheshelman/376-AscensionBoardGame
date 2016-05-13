/**
 * 
 */
package devops.hw1.core;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author fenogljc
 *
 */
public class Dummy {

	Board board;
	
	@Given("^we have a full board$")
	public void we_have_a_full_board() throws Throwable {
		board = new Board();
		
	}

	Player player;
	@Given("^we have a player$")
	public void we_have_a_player() throws Throwable {
	    player = Player.makePlayer();
	}

	ACard bcard;
	@Given("^we have a card that can banish from the center$")
	public void we_have_a_card_that_can_banish_center() throws Throwable {
		bcard = CardCollection.seerOfTheForkedPath;
		player.addCardToHand(bcard);
	}
	
	@Given("^we have a card that can banish from the hand$")
	public void we_have_a_card_that_can_banish_hand() throws Throwable {
		bcard = CardCollection.shadeOfTheBlackWatch;
		player.addCardToHand(bcard);
	}

	@When("^we play that card$")
	public void we_play_that_card() throws Throwable {
		player.doCard(bcard, board);
//		player.playCard(bcard);
	}

	@Then("^a card we select from the center is sent to the the void$")
	public void a_card_we_select_from_the_center_is_sent_to_the_the_void() throws Throwable {
		Assert.assertFalse(board.getVoid().isEmpty());
	}

	@Then("^our card is discarded$")
	public void our_card_is_discarded() throws Throwable {
		Assert.assertFalse(player.getHand().contains(bcard));
	}

	@Then("^a card we select from our hand is sent to the the void$")
	public void a_card_we_select_from_our_hand_is_sent_to_the_the_void() throws Throwable {
	    Assert.assertEquals(2, board.getVoid().size());
	}
	
	@Given("^the player has a Construct in hand$")	//Start of the Playing a Construct (from the hand) Scenario
	public void the_player_has_a_Construct_in_hand() throws Throwable {
	    bcard = CardCollection.snapdragon;
		player.addCardToHand(bcard);
	}

	@When("^the player plays the Construct$")
	public void the_player_plays_the_Construct() throws Throwable {
	    player.playCard(bcard);
	}

	@Then("^the Construct leaves the player's hand$")
	public void the_Construct_leaves_the_player_s_hand() throws Throwable {
	    Assert.assertFalse(player.getHand().contains(bcard));
	}

	@Then("^the Construct stays in play$")
	public void the_Construct_stays_in_play() throws Throwable {
	    Assert.assertTrue(player.getConstructs().contains(bcard));
	}

	@Then("^the Construct is not in the discard$")
	public void the_Construct_is_not_in_the_discard() throws Throwable {
	    Assert.assertFalse(player.getDiscardPile().contains(bcard));
	}
	
	@Given("^the player has a Construct in play$")	//Start of the Activating a Construct's Effect Scenario
	public void the_player_has_a_Construct_in_play() throws Throwable {
		bcard = CardCollection.muramasa;	//gain 3 power every turn
		player.addConstruct(bcard);
	}

	@Given("^the Construct's effect has not yet been activated$")
	public void the_Construct_s_effect_has_not_yet_been_activated() throws Throwable {
	    Assert.assertEquals(0, player.getConstructs().get(0).getTimesActivated());
	}

	@When("^the player activates the Construct's effect$")
	public void the_player_activates_the_Construct_s_effect() throws Throwable {
		player.applyEffects(bcard);
	}

	@Then("^the corresponding effect takes place$")
	public void the_corresponding_effect_takes_place() throws Throwable {
	    Assert.assertEquals(3, player.getPower());
	}

	@Then("^the Construct's effect cannot be activated again this turn$")
	public void the_Construct_s_effect_cannot_be_activated_again_this_turn() throws Throwable {
	    player.getConstructs().get(0).setTimesActivated(1);
	}
	
	@When("^a card's effect destroys a Construct$")		//for "destroying" a construct
	public void a_card_s_effect_destroys_a_Construct() throws Throwable {
	    ACard card = CardCollection.corrosiveWidow;
	    player.doCard(card, board);
	    player.discardConstruct(bcard);
	}

	@Then("^the Construct is in the player's discard pile$")
	public void the_Construct_is_in_the_player_s_discard_pile() throws Throwable {
	    Assert.assertTrue(player.getDiscardPile().contains(bcard));
	}

	@Then("^the Construct is no longer in play$")
	public void the_Construct_is_no_longer_in_play() throws Throwable {
	    Assert.assertFalse(player.getConstructs().contains(bcard));
	}	
}
