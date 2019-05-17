package ladder.view;

import ladder.LadderGame;
import ladder.domain.*;

import java.util.List;

public class OutputView {
    public static void printLadderGameBoard(LadderGameBoard board) {
        printLadderValues(board.getNames());
        System.out.println(board.getLadder());
        printLadderValues(board.getResults());
    }

    private static void printLadderValues(List<String> values) {
        for (String value : values) {
            System.out.printf("%-6s", value);
        }
        System.out.println();
    }

	public static void printResult(List<Player> players) {
		System.out.println("실행결과");

		for (Player player : players) {
			String result = LadderGame.getResults().get(player.getPosition());
			System.out.println(player.getName() + " : " + result);
		}
	}
}
