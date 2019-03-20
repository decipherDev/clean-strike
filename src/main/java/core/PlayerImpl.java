package core;

public class PlayerImpl implements Player {
	private Integer id;
	private Integer score;
	private Integer foulFlag;
	
	public PlayerImpl(Integer id, Integer score, Integer foulFlag) {
		this.id = id;
		this.score = score;
		this.foulFlag = foulFlag;
	}

	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	public Integer getFoulFlag() {
		return foulFlag;
	}
	
	public void setFoulFlag(Integer foulFlag) {
		this.foulFlag = foulFlag;
	}

	public Integer getId() {
		return id;
	}
}
