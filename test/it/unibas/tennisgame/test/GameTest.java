package it.unibas.tennisgame.test;

import it.unibas.tennisgame.Game;
import it.unibas.tennisgame.GameHasAlreadyBeWonException;
import it.unibas.tennisgame.Player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	private Player p1;
	private Player p2;
	
	@Before
	public void setUp() throws Exception {
		game = new Game();
		p1 = game.getP1();
		p2 = game.getP2();
	}

	@Test
	public void atTheBeginningBothPlayersShouldHaveScoreEqualsToLove() {
		String actual = game.getGameStatus();
		Assert.assertEquals("name1 Love - name2 Love", actual);
	}
	
	@Test
	public void scoresShouldBeIncreased() throws GameHasAlreadyBeWonException {
		game.incrementPlayerScore(p1);
		String actual = game.getGameStatus();
		Assert.assertEquals("name1 Fifteen - name2 Love", actual);
		
		game.incrementPlayerScore(p2);
		actual = game.getGameStatus();
		Assert.assertEquals("name1 Fifteen - name2 Fifteen", actual);
				
	}

	@Test
	public void scoreShouldBeDuece() throws GameHasAlreadyBeWonException{
		game.incrementPlayerScore(p1);
		game.incrementPlayerScore(p1);
		game.incrementPlayerScore(p1);
		
		game.incrementPlayerScore(p2);
		game.incrementPlayerScore(p2);
		game.incrementPlayerScore(p2);
		
		String actual = game.getGameStatus();	
		Assert.assertEquals("Deuce", actual);
	}
	
	@Test
	public void player2ShouldHaveAdvantage() throws GameHasAlreadyBeWonException{
		game.incrementPlayerScore(p1);
	    game.incrementPlayerScore(p1);
	    game.incrementPlayerScore(p1);
	
	    game.incrementPlayerScore(p2);
	    game.incrementPlayerScore(p2);
	    game.incrementPlayerScore(p2);
	    game.incrementPlayerScore(p2);
	
	    Assert.assertEquals("Advantage name2", game.getGameStatus());
    }
	
	@Test
	public void player1ShouldHaveAdvantage() throws GameHasAlreadyBeWonException{	    
	    game.incrementPlayerScore(p2);
	    game.incrementPlayerScore(p2);
	    game.incrementPlayerScore(p2);
	    
	    game.incrementPlayerScore(p1);
	    game.incrementPlayerScore(p1);
	    game.incrementPlayerScore(p1);
	    game.incrementPlayerScore(p1);
	
	    Assert.assertEquals("Advantage name1", game.getGameStatus());
    }
	
	@Test 
	public void firstPlayerShouldHaveEasyWin() throws GameHasAlreadyBeWonException{	
		game.incrementPlayerScore(p1);
		game.incrementPlayerScore(p1);
		game.incrementPlayerScore(p1);
		game.incrementPlayerScore(p1);
		
		Assert.assertEquals("name1 wins", game.getGameStatus());	
	}
	
	@Test 
	public void secondPlayerShouldHaveEasyWin() throws GameHasAlreadyBeWonException{
		game.incrementPlayerScore(p2);
		game.incrementPlayerScore(p2);
		game.incrementPlayerScore(p2);
		game.incrementPlayerScore(p2);
		
		Assert.assertEquals("name2 wins", game.getGameStatus());	
	}
	
	@Test 
	public void firstPlayerShouldHaveHardWin() throws GameHasAlreadyBeWonException{	
		game.incrementPlayerScore(p2);
		game.incrementPlayerScore(p2);
		
		game.incrementPlayerScore(p1);
		game.incrementPlayerScore(p1);
		game.incrementPlayerScore(p1);		
		game.incrementPlayerScore(p1);
		
		Assert.assertEquals("name1 wins", game.getGameStatus());	
	}
	
	@Test(expected=GameHasAlreadyBeWonException.class)
	public void shoudBeAlreadyWinner() throws GameHasAlreadyBeWonException{
		game.incrementPlayerScore(p2);
		game.incrementPlayerScore(p2);
		game.incrementPlayerScore(p2);
		game.incrementPlayerScore(p2);
		
		game.incrementPlayerScore(p1);
	}
	
	/* 
	// This test is equivalent to the previous test. 
	@Test
	public void shoudBeAlreadyWinner(){
		try {
			game.incrementPlayerScore(p2);
			game.incrementPlayerScore(p2);
			game.incrementPlayerScore(p2);
			game.incrementPlayerScore(p2);
			game.incrementPlayerScore(p1);
			Assert.fail();
		} catch (GameHasAlreadyBeWonException e) {	
		}
	}
	*/
	
	
	
}
