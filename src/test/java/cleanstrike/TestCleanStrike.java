package cleanstrike;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.CleanStrike;
import main.PlayCleanStrikeWithTwoPlayers;

public class TestCleanStrike {
	private CleanStrike cleanStrikeWithTwoPlayers;
	
	@Before
	public void setUp() {
		cleanStrikeWithTwoPlayers = new PlayCleanStrikeWithTwoPlayers();
	}
	
	@Test
	public void testForDraw() {
		Integer[] inputs = new Integer[] {1, 1, 1, 3, 1, 1, 2, 1, 1};
		String result = cleanStrikeWithTwoPlayers.playCleanStrike(inputs);
		assertTrue("Draw, score 6-6".equals(result));
	}
	
	@Test
	public void testForPlayerOneWin() {
		Integer[] inputs = new Integer[] {1, 6, 1, 6, 1, 6, 1, 6, 1};
		String result = cleanStrikeWithTwoPlayers.playCleanStrike(inputs);
		assertTrue("Player 1 wins, score 5-0".equals(result));
	}
	
	@Test
	public void testForPlayerTwoWin() {
		Integer[] inputs = new Integer[] {1, 6, 1, 6, 1, 3, 5, 2, 5, 2};
		String result = cleanStrikeWithTwoPlayers.playCleanStrike(inputs);
		assertTrue("Player 2 wins, score 1-5".equals(result));
	}
}
