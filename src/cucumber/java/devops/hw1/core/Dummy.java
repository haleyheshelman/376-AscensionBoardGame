/**
 * 
 */
package devops.hw1.core;

import devops.hw1.core.Board;
import devops.hw1.core.CardCollection;
import devops.hw1.core.Player;
import org.junit.Assert;
import cucumber.api.PendingException;
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
	    Assert.assertEquals(board.getVoid().size(), 2);
	}
	
	@Given("^the player has a Construct in hand$")	//just added
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
}
