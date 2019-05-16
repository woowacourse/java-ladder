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

		List<Player> player = LadderGame.generatePlayers(names);

		String name;
		do {
			name = InputView.inputResult();
			OutputView.printResult(player, gameResults, name);
		}
		while (!name.equals("all"));
	}
}

