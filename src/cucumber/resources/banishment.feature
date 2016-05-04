Feature: Banishment
	As a player I want to be able to select cards to banish from the center row 
	or from my hand into the void.

@banishment
Scenario: banish from center row
	
	Given we have a full board
	And we have a player
	And we have a card that can banish
	When we play that card
	Then a card we select from the center is sent to the the void
	And our card is discarded
	
@banishment
Scenario: banish from hand
	
	Given we have a full board
	And we have a player
	And we have a card that can banish
	When we play that card
	Then a card we select from our hand is sent to the the void
	And our card is discarded