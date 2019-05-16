package ladder;

import java.util.List;

import ladder.domain.Player;
import ladder.domain.Result;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameApp {
	public static void main(String[] args) {
		List<Player> names = LadderGame.getPersonNames();
		List<String> gameReward = LadderGame.getGameReward();
		int ladderHeight = LadderGame.getLadderHeight();

		OutputView.printPlayerNames(names);
		OutputView.printLadder(LadderGame.generatreLadder(ladderHeight));
		OutputView.printLadderValues(gameReward);

		List<Result> result = LadderGame.run(gameReward);

		String name;
		do {
			name = InputView.inputResult();
			OutputView.printResult(result, name);
		}
		while (!name.equals("all"));
	}
}

