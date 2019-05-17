package ladder;

import java.util.List;

import ladder.domain.LadderGameBoard;
import ladder.domain.Player;
import ladder.view.OutputView;

public class LadderGameApp {
	public static void main(String[] args) {
        LadderGameBoard board = LadderGame.generateGameBoard();
		OutputView.printLadderGameBoard(board);

		LadderGame.matchPlayerAndResult(players);

		String name;
		do {
            name = LadderGame.getNameForResult(names);
		} while (!name.equals("all"));
        OutputView.printResult(name, players, gameResults);
	}
}

