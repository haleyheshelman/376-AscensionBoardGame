package devops.hw1.core;

public class DrawCard extends ACard {
	
	private DrawCard(){
		this.setCost(1);
	}
	
	private DrawCard(int i){
		this.setCost(i);
	}

	@Override
	public void effect() {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public ACard makeCard() {
		return new DrawCard();
	}

	public ACard makeCard(int i) {
		return new DrawCard(i);
	}
	

}
