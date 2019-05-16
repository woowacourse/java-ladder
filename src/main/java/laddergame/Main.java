package laddergame;

import laddergame.domain.Ladder;
import laddergame.domain.LadderHeight;
import laddergame.domain.player.PlayerBuilder;
import laddergame.domain.player.Players;
import laddergame.domain.result.ResultBuilder;
import laddergame.domain.result.Results;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class Main {

	public static void main(String[] args) {
		Players players= new PlayerBuilder(InputView.inputPlayers()).makePlayers();
		LadderHeight ladderHeight = new LadderHeight(InputView.inputLadderHeight());
		Results results = new ResultBuilder(InputView.inputResults()).makeResults();
		Ladder ladder = new Ladder(ladderHeight.getLadderHeight(), players.getTotalPlayers());
		ladder.connectBridgesRandomly(ladderHeight.getLadderHeight() * players.getTotalPlayers());
		OutputView.showPlayers(players);
		OutputView.showLadder(ladder);
		OutputView.showResult(results);
	}
}
