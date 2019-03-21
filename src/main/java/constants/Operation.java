package constants;

import java.util.Arrays;

public enum Operation {
	  STRIKE(1, 1, 1)
	, MULTI_STRIKE(2, 2, 2)
	, RED_STRIKE(3, 3, 255) //255 signifies that it's red coin
	, STRIKER_STRIKE(4, -1, 0)
	, DEFUNCT_COIN(5, -2, -1)
	, NONE(6, 0, 0)
	;
	
	//action performed by the player
	private Integer option;
	
	//points scored
	private Integer points;
	
	//coins pocketed or removed from the board
	private Integer coinRemoved;
	
	private Operation(Integer option, Integer points, Integer coinRemoved) {
		this.option = option;
		this.points = points;
		this.coinRemoved = coinRemoved;
	}
	
	/*
	 * @param operation - action performed by the user
	 * @return Operation constant which gives score and coin to be removed from
	 * the board 
	 */
	public static Operation getOperationByOperationPerformed(int operation) {
		return Arrays.asList(Operation.values())
				     .stream()
					 .filter(choice -> choice.option == operation)
					 .findFirst()
					 .orElse(Operation.NONE);
	}

	public Integer getPoints() {
		return points;
	}

	public Integer getCoinRemoved() {
		return coinRemoved;
	}	
}