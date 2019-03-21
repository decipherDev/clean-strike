package main;

import bean.Player;

public interface CleanStrike {
	public String playCleanStrike(Integer[] inputs);

	public Player[] createPlayers();

	public int teamSize();
}
