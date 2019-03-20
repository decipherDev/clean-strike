package cleanstrike;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import core.Player;
import main.CleanStrike;
import main.PlayCleanStrikeWithTwoPlayers;

public class TestCleanStrike {
	private Player[] players;
	private CleanStrike cleanStrikeWithTwoPlayers;
	
	@Before
	public void setUp() throws Exception {
		cleanStrikeWithTwoPlayers = new PlayCleanStrikeWithTwoPlayers();
	}
	
	@Test
	public void testForDraw() {
		Integer[] inputs = new Integer[] {1, 1, 1, 3, 1, 1, 2, 1, 1};
		players = cleanStrikeWithTwoPlayers.playCleanStrike(inputs);
		assertNull(players);
	}
	
	@Test
	public void testForPlayerOneWin() {
		Integer[] inputs = new Integer[] {1, 6, 1, 6, 1, 6, 1, 6, 1};
		players = cleanStrikeWithTwoPlayers.playCleanStrike(inputs);
		assertTrue(players[0].getScore() == 5);
	}
	
	@Test
	public void testForPlayerTwoWin() {
		Integer[] inputs = new Integer[] {1, 6, 1, 6, 1, 3, 5, 2, 5, 2};
		players = cleanStrikeWithTwoPlayers.playCleanStrike(inputs);
		assertTrue(players[1].getScore() == 5);
	}
}
