package ladder;

import ladder.view.OutputView;

public class LadderGameApp {
	public static void main(String[] args) {
		LadderGame ladderGame = new LadderGame();
		OutputView.printLadder(ladderGame.run());
	}
}
