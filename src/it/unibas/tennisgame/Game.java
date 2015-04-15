package it.unibas.tennisgame;

public class Game {
	
	private static final String ADVANTAGE = "Advantage";
	private static final String DEUCE = "Deuce";
	private static final String SPACE = " ";
	private static final String DASH = "-";
	private static final String WINS = "wins";
	
	private Player p1;
	private Player p2;
	private String gameStatus;
	
	public Game() {
		p1 = new Player("name1", 0);
		p2 = new Player("name2", 0);
		updateGameStatus();
	}
	
	
	public void updateGameStatus() {
		StringBuilder result = new StringBuilder();
		if (isNotAnAdvantageGame()) {
			result.append(p1.getName()).append(SPACE).append(p1.getScoreAsString());
			result.append(SPACE).append(DASH).append(SPACE);
			result.append(p2.getName()).append(SPACE).append(p2.getScoreAsString());
		} else if (isDeuce()) result.append(DEUCE);
		else if (isThereAnAdvantagePlayer()) result.append(ADVANTAGE).append(SPACE).append(advantagePlayer().getName());
		else if (isThereAWinner()) result.append(theWinner().getName()).append(SPACE).append(WINS);
		this.gameStatus = result.toString();
	}
	
	private boolean isNotAnAdvantageGame() {
		return p1.hasLessThenFortyPoints() && p2.hasLessThenFortyPoints();
	}
	
	private boolean isThereAnAdvantagePlayer() {
		return advantagePlayer() != null;
	}
	
	private Player advantagePlayer() {
		Player result = null;
		if (p2.hasAtLeastFortyPoints() && p1.hasAtLeastFortyPoints()) {
			if (p1.hasOnePointAdvantageOn(p2))
				result = p1;
			else if (p2.hasOnePointAdvantageOn(p1))
				result = p2;
		}
		return result;
	}
	
	private boolean isDeuce() {
		return p1.isTieWith(p2) && p1.hasAtLeastFortyPoints();
	}
	
	private boolean isThereAWinner() {
		return theWinner() != null;
	}
	
	private Player theWinner() {
		Player theWinner = null;
		if (p1.hasMoreThanFourtyPoints() && p1.hasAtLeastTwoPointsAdvantageOn(p2)) theWinner = p1;
		else if (p2.hasMoreThanFourtyPoints() && p2.hasAtLeastTwoPointsAdvantageOn(p1)) theWinner = p2;
		return theWinner;
	}
	
	public void incrementPlayerScore(Player player) throws GameHasAlreadyBeWonException {
		if (!isThereAWinner()) {
			if (player.equals(p1)) {
				p1.incrementScore();
			} else if (player.equals(p2)) {
				p2.incrementScore();
			}
			updateGameStatus();
		} else
			throw new GameHasAlreadyBeWonException();
	}
	
	public String getGameStatus() {
		return this.gameStatus;
	}

	public Player getP1() {
		return p1;
	}

	public Player getP2() {
		return p2;
	}

}
