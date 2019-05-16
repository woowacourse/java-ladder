package ladder;

import java.util.List;

import ladder.domain.Player;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameApp {
	public static void main(String[] args) {
		List<String> names = LadderGame.getPersonNames();
		List<String> gameResults = LadderGame.getGameResult(names);
		int ladderHeight = LadderGame.getLadderHeight();

		OutputView.printLadderValues(names);
		OutputView.printLadder(LadderGame.generatreLadder(names, ladderHeight));
		OutputView.printLadderValues(gameResults);

		List<Player> players = LadderGame.generatePlayers(names);

		LadderGame.matchPlayerAndResult(players);

		String name;
		do {
			name = InputView.inputNameForResult();
			OutputView.printResult(name, players, gameResults);
		}
		while (!name.equals("all"));
	}
}

