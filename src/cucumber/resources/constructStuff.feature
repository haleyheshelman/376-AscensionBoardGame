Feature: Constructing
	Making all of the Constructs work
	
@Constructing
Scenario: playing a Construct from the hand
	
	Given we have a full board
	And we have a player
	And the player has a Construct in hand
	When the player plays the Construct
	Then the Construct leaves the player's hand
	And the Construct stays in play
	And the Construct is not in the discard
	
@Constructing
Scenario: activating the effect of a Construct in play

	Given we have a full board
	And we have a player
	And the player has a Construct in play
	And the Construct's effect has not yet been activated
	When the player activates the Construct's effect
	Then the corresponding effect takes place
	And the Construct's effect cannot be activated again this turn
	