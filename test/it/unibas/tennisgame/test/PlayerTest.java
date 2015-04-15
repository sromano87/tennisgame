package it.unibas.tennisgame.test;

import it.unibas.tennisgame.Player;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {
	
	@Test
	public void twoPlayersWithSameScoreShouldTie() {
		Player p1 = new Player("p1", 2);
		Player p2 = new Player("p2", 2);
		Assert.assertTrue(p1.isTieWith(p2));
	}
	
	@Test
	public void twoPlayerWithDifferentScoreShouldNotTie() {
		Player p1 = new Player("p1", 2);
		Player p2 = new Player("p2", 3);
		Assert.assertFalse(p1.isTieWith(p2));
	}

	@Test
	public void playerShouldHaveAtLeastFortyPoints() {
		Player p1 = new Player("p1", 3);
		Assert.assertTrue(p1.hasAtLeastFortyPoints());
	}
	
	@Test
	public void playerShouldNotHaveAtLeastFortyPoints() {
		Player p1 = new Player("p1", 2);
		Assert.assertFalse(p1.hasAtLeastFortyPoints());
	}

	@Test
	public void playerShouldHaveLessThenFortyPoints() {
		Player p1 = new Player("p1", 2);
		Assert.assertTrue(p1.hasLessThenFortyPoints());
	}
	
	@Test
	public void playerShouldNotHaveLessThenFortyPoints() {
		Player p1 = new Player("p1", 3);
		Assert.assertFalse(p1.hasLessThenFortyPoints());
	}
	
	@Test
	public void playerShouldHaveMoreThanFourtyPoints() {
		Player p1 = new Player("p1", 4);
		Assert.assertTrue(p1.hasMoreThanFourtyPoints());
	}
	
	@Test
	public void playerShouldHaveNotMoreThanFourtyPoints() {
		Player p1 = new Player("p1", 3);
		Assert.assertFalse(p1.hasMoreThanFourtyPoints());
	}

	@Test
	public void playerShouldHaveOnePointAdvantage() {
		Player p1 = new Player("p1", 2);
		Player p2 = new Player("p2", 1);
		Assert.assertTrue(p1.hasOnePointAdvantageOn(p2));
	}
	
	@Test
	public void playerShouldNotHaveOnePointAdvantage() {
		Player p1 = new Player("p1", 2);
		Player p2 = new Player("p2", 2);
		Assert.assertFalse(p1.hasOnePointAdvantageOn(p2));
	}

	@Test
	public void playerShouldHaveAtLeastTwoPointsAdvantage() {
		Player p1 = new Player("p1", 4);
		Player p2 = new Player("p2", 2);
		Assert.assertTrue(p1.hasAtLeastTwoPointsAdvantageOn(p2));
	}
	
	@Test
	public void playerShouldHaveNotAtLeastTwoPointsAdvantage() {
		Player p1 = new Player("p1", 4);
		Player p2 = new Player("p2", 3);
		Assert.assertFalse(p1.hasAtLeastTwoPointsAdvantageOn(p2));
	}
	
	public void scoresInRangeZeroThreeShouldGetAsString(){
		Player p1 = new Player("p1", 0);
		Assert.assertEquals("Love", p1.getScoreAsString());
	}
	
	public void scoresOutRangeZeroThreeSchouldNotGetAsString(){
		Player p1 = new Player("p1", 4);
		Assert.assertNull(p1.getScoreAsString());
	}

}
