package main;

import bean.Coin;
import bean.Player;
import bean.PlayerImpl;
import constants.Operation;
import utils.CleanStrikeUtils;

public final class PlayCleanStrikeWithTwoPlayers implements CleanStrike {	
	/**
	 * 
	 * @param players -- two players with default scores and coins pocketed 0-0
	 * @param inputs -- input of operations performed by both the players
	 * @return two players with updated scores
	 */
	private Player[] play(Player[] players, Integer[] inputs) {
		Coin coin = Coin.getInstance();
		int playerNo;
		
		for (Integer i = 0; i < inputs.length; i++) {
			Operation operation = Operation.getOperationByOperationPerformed(inputs[i]);
			playerNo = i % teamSize();
			if (operation.getPoints() < 0) {
				players[playerNo].setFoulFlag(players[playerNo].getFoulFlag() + 1);
			}

			players[playerNo].setScore(players[playerNo].getScore() + operation.getPoints());

			if (CleanStrikeUtils.foulCheck(players[playerNo])) {
				players[playerNo].setScore(players[playerNo].getScore() - 1);
			}
			
			if (operation.getCoinRemoved() == 255) {
				coin.setRedCoin(0);
			} else {
				coin.setBlackCoin(coin.getBlackCoin() - operation.getCoinRemoved());
			}
			
			if (CleanStrikeUtils.wonCheck(players) || CleanStrikeUtils.areCoinsExhausted(coin)) {
				return players;
			}
		}

		return players;
	}
	
	/**
	 * 
	 * @param players - takes the players scores to get the decide win or draw
	 * @return String which contains the final decision with scores of both the
	 * players 
	 */
	private String getResult(Player[] players) {
		return CleanStrikeUtils.result(players);
	}
	
	/**
	 * creates two players to play the game
	 */
	public Player[] createPlayers() {
		Player[] players = new Player[2];
		players[0] = new PlayerImpl(1, 0, 0);
		players[1] = new PlayerImpl(2, 0, 0);
		
		return players;
	}
	
	/**
	 * @param inputs - array of integers representing
	 * the operations performed by the user
	 */
	public String playCleanStrike(Integer[] inputs) {
		return getResult(play(createPlayers(), inputs));
	}
	
	/**
	 * returns the team size
	 */
	public int teamSize() {
		return 2;
	}
}