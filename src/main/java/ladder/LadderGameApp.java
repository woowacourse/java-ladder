package ladder;

import java.util.List;

import ladder.view.OutputView;

public class LadderGameApp {
	public static void main(String[] args) {
		List<String> names = LadderGame.getPersonNames();
		int ladderHeight = LadderGame.getLadderHeight();

		OutputView.printNames(names);
	}
}
