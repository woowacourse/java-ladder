package ladder;

import java.util.List;

import ladder.domain.LadderGameBoard;
import ladder.domain.Player;
import ladder.view.OutputView;

public class LadderGameApp {
	public static void main(String[] args) {
        LadderGameBoard board = LadderGame.generateGameBoard();
		OutputView.printLadderGameBoard(board);

		LadderGame.executeLadderGame();

		List<Player> foundPlayers = LadderGame.lookUpResult();
		OutputView.printResult(foundPlayers);
	}
}

