package it.unibas.tennisgame;

public class Game {
	
	public Game() {
	}
	
	public void updateGameStatus() {
	}
	
	private boolean isNotAnAdvantageGame() {
		return true;
	}
	
	private boolean isThereAnAdvantagePlayer() {
		return true;
	}
	
	private Player advantagePlayer() {
		return null;
	}
	
	private boolean isDeuce() {
		return true;
	}
	
	private boolean isThereAWinner() {
		return true;
	}
	
	private Player theWinner() {
		return null;
	}
	
	public void incrementPlayerScore(Player player) throws GameHasAlreadyBeWonException {
	}
	
	public String getGameStatus() {
		return null;
	}

	public Player getP1() {
		return null;
	}

	public Player getP2() {
		return null;
	}

}
