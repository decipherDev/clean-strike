package main;

import constants.Operation;
import core.Coin;
import core.Player;
import core.PlayerImpl;
import utils.Conditions;

public final class PlayCleanStrikeWithTwoPlayers implements CleanStrike {
	
	public Player[] playCleanStrike(Integer[] inputs) {
		return play(createPlayers(), inputs);
	}
	
	public Player[] createPlayers() {
		Player[] players = new Player[2];
		players[0] = new PlayerImpl(1, 0, 0);
		players[1] = new PlayerImpl(2, 0, 0);
		
		return players;
	}
	
	private Player[] play(Player[] players, Integer[] inputs) {
		Coin coin = Coin.getInstance();
		int playerNo;
		
		for (Integer i = 0; i < inputs.length; i++) {
			Operation operation = Operation.getOperationByOperationPerformed(inputs[i]);
			playerNo = i % 2;
			if (operation.getPoints() < 0) {
				players[playerNo].setFoulFlag(players[playerNo].getFoulFlag() + 1);
			}

			players[playerNo].setScore(players[playerNo].getScore() + operation.getPoints());

			if (operation.getCoinRemoved() == 255) {
				coin.setRedCoin(0);
			} else {
				coin.setBlackCoin(coin.getBlackCoin() - operation.getCoinRemoved());
			}
			
			if (Conditions.foulCheck(players[playerNo])) {
				players[playerNo].setScore(players[playerNo].getScore() - 1);
			}

			if (Conditions.wonCheck(players)) {
				return players;
			}


			if (Conditions.areCoinsExhausted(coin)) {
				return null;
			}
		}

		return null;
	}
}