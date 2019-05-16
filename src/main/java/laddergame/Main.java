package laddergame;

import laddergame.domain.Ladder;
import laddergame.domain.LadderHeight;
import laddergame.domain.PlayerMaker;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class Main {

	public static void main(String[] args) {
		PlayerMaker playerMaker = new PlayerMaker(InputView.inputPlayers());
		LadderHeight ladderHeight = new LadderHeight(InputView.inputLadderHeight());
		Ladder ladder = new Ladder(ladderHeight.getLadderHeight(), playerMaker.makePlayers().size());
		ladder.connetBridgesRandomly(ladderHeight.getLadderHeight() * playerMaker.makePlayers().size());
		OutputView.showResult(playerMaker.makePlayers(), ladder);
	}
}
