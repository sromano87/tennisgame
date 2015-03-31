package it.unibas.tennisgame;

public class Player {
		
	public Player(String name, int score) {
	}
	
	public String getName() {
		return null;
	}

	public int getScore() {
		return 0;
	}
	
	public void incrementScore(){
	}
	
	public String getScoreAsString(){
		return null;		
	}
	
	public boolean isTieWith(Player opponent) {
		return true;
	}
	
	public boolean hasAtLeastFortyPoints() {
		return true;
	}
	
	public boolean hasLessThenFortyPoints() {
		return true;
	}
	
	public boolean hasMoreThanFourtyPoints() {
		return true;
	}
	
	public  boolean hasOnePointAdvantageOn(Player opponent) {
		return true;
	}
	
	public  boolean hasAtLeastTwoPointsAdvantageOn(Player opponent) {
		return true;
	}

}
