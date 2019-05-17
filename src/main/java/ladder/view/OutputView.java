package ladder.view;

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

	public static void printResult(String name, List<Player> players, List<String> result) {
		if(name.equals("all")) {
			for(Player player : players) {
				System.out.println(player.getName() + " : " + result.get(player.getPosition()));
			}
			return;
		}

		for(Player player : players) {
			if(player.matchName(name)) {
				System.out.println("실행결과 \n" + result.get(player.getPosition()));
				break;
			}
		}
	}
}
