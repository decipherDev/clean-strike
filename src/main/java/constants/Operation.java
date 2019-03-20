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
	
	private Integer option;
	private Integer points;
	private Integer coinRemoved;
	
	private Operation(Integer option, Integer points, Integer coinRemoved) {
		this.option = option;
		this.points = points;
		this.coinRemoved = coinRemoved;
	}
	
	public static Operation getOperationByOperationPerformed(int operation) {
		return Arrays.asList(Operation.values())
				     .stream()
					 .filter(choice -> choice.option == operation)
					 .findFirst()
					 .get();
	}

	public Integer getPoints() {
		return points;
	}

	public Integer getCoinRemoved() {
		return coinRemoved;
	}	
}