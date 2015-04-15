package it.unibas.tennisgame;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Player {
	
	private static final Map<Integer, String> scoreMapping;
	
	static{
		Map<Integer, String> map = new HashMap<Integer, String>();
		map = new HashMap<Integer, String>(); 
		map.put(0, "Love");
		map.put(1, "Fifteen");
		map.put(2, "Thirty");
		map.put(3, "Forty");
		scoreMapping = Collections.unmodifiableMap(map);
	}
	
	private String name;
	private int score;
	
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	
	public void incrementScore(){
		score++;
	}
	
	public String getScoreAsString(){
		return scoreMapping.get(score);		
	}
	
	public boolean isTieWith(Player opponent) {
		if(score==opponent.getScore()){
			return true;
		}
		return false;
	}
	
	public boolean hasAtLeastFortyPoints() {
		if(score>=3){
			return true;
		}
		return false;
	}
	
	public boolean hasLessThenFortyPoints() {
		if(score<3){
			return true;
		}
		return false;	
	}
	
	public boolean hasMoreThanFourtyPoints() {
		if(score>3){
			return true;
		}
		return false;
	}
	
	public  boolean hasOnePointAdvantageOn(Player opponent) {
		if(score-opponent.getScore()==1){
			return true;
		}
		return false;
	}
	
	public  boolean hasAtLeastTwoPointsAdvantageOn(Player opponent) {
		if(score-opponent.getScore()>=2){
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}

}
