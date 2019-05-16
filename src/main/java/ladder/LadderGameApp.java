package ladder;

import java.util.List;

import ladder.domain.Ladder;
import ladder.view.OutputView;

public class LadderGameApp {
	public static void main(String[] args) {
		List<String> names = LadderGame.getPersonNames();
		int ladderHeight = LadderGame.getLadderHeight();

		Ladder ladder = LadderGame.run(names, ladderHeight);
		OutputView.printNames(names);
		OutputView.printLadder(ladder);
	}
}
