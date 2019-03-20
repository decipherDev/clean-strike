package core;

public class Coin {
	private Integer redCoin;
	private Integer blackCoin;
	
	private Coin() {
		redCoin = 1;
		blackCoin = 9;
	}
	
	private static class CoinsHolder {
		private static Coin coins = new Coin();
	}
	
	public static Coin getInstance() {
		return CoinsHolder.coins;
	}

	public Integer getRedCoin() {
		return redCoin;
	}

	public void setRedCoin(Integer redCoin) {
		this.redCoin = redCoin;
	}

	public Integer getBlackCoin() {
		return blackCoin;
	}

	public void setBlackCoin(Integer blackCoin) {
		this.blackCoin = blackCoin;
	}
}
