package utils;

import bean.Coin;
import bean.Player;

public class CleanStrikeUtils {
	public static final String WINNER_RESULT = "Player %d wins, score %d-%d";
	public static final String DRAW_RESULT = "Draw, score %d-%d";
	
	private CleanStrikeUtils() {
		//private constructor
	}
	
	public static boolean foulCheck(Player player) {
		return player.getFoulFlag() % 3 == 3;
	}
	
	public static boolean wonCheck(Player[] players) {
		return (Math.abs(players[0].getScore() - players[1].getScore()) >= 3 && 
				(players[0].getScore() >= 5 || players[1].getScore() >= 5));
	}
	
	public static boolean areCoinsExhausted(Coin coin) {
		return coin.getRedCoin() == 0 && coin.getBlackCoin() == 0 ? true : false;
	}
	
	public static String result(Player[] players) {
		
		if(Math.abs(players[0].getScore() - players[1].getScore()) >= 3
	       && (players[0].getScore() > 4 || players[1].getScore() > 4)) {
			 int won = players[0].getScore() > players[1].getScore() ? 0 : 1;
			 return String.format(WINNER_RESULT, won+1, players[0].getScore(), players[1].getScore());                   
		} else {
			return String.format(DRAW_RESULT, players[0].getScore(), players[1].getScore());
		}
	}
}