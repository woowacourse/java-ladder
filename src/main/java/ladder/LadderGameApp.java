package ladder;

import java.util.List;

import ladder.domain.LadderGameResult;
import ladder.domain.UserOutput;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameApp {
	public static void main(String[] args) {
		List<String> playerNames = LadderGame.getPersonNames();
		List<String> gameReward = LadderGame.getGameReward();
		int ladderHeight = LadderGame.getLadderHeight();

		OutputView.printPlayerNames(playerNames);
		OutputView.printLadder(LadderGame.generatreLadder(ladderHeight));
		OutputView.printLadderValues(gameReward);

		LadderGameResult ladderGameResult = LadderGame.run(gameReward);

		String name;
		do {
			name = InputView.inputResult();
			OutputView.printResult(ladderGameResult, name);
		}
		while (!name.equals(UserOutput.PRINT_ALL_PLAYER.getOutputMessage()));
	}
}

