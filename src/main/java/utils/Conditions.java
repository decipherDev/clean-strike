package utils;

import core.Coin;
import core.Player;

public class Conditions {
	public static boolean foulCheck(Player player) {
			return player.getFoulFlag() == 3 ? true : false;
	}
	
	public static boolean wonCheck(Player[] players) {
		if(Math.abs(players[0].getScore() - players[1].getScore()) >= 3 && 
				(players[0].getScore() >= 5 || players[1].getScore() >= 5)) {
			return true;
		}
		return false;
	}
	
	public static boolean areCoinsExhausted(Coin coin) {
		return coin.getRedCoin() == 0 && coin.getBlackCoin() == 0 ? true : false;
	}
}