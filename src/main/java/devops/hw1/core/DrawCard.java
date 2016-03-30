package devops.hw1.core;

public class DrawCard extends ACard {
	
	public DrawCard(){
		this.effects.put("draw", 1);
		this.setCost(0);
	}
	
	public DrawCard(int i){
		this.effects.put("draw", 1);
		this.setCost(i);
	}

}
