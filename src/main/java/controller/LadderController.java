package controller;

import domain.Ladder;
import domain.LadderBuilder;
import domain.LadderHeight;
import domain.LadderWidth;
import domain.Users;
import domain.util.RandomPointGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {
	public void makeLadder() {
		Users users = retrieveUsers();
		Ladder ladder = buildLadder(users);
		OutputView.printResult(users, ladder);
	}

	private Users retrieveUsers() {
		try {
			return new Users(InputView.readUserNames());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveUsers();
		}
	}

	private Ladder buildLadder(Users users) {
		LadderHeight height = retrieveLadderHeight();
		LadderWidth width = changeIntoWidth(users.getUsersCount());
		return new LadderBuilder().build(height, width, new RandomPointGenerator());
	}

	private LadderHeight retrieveLadderHeight() {
		try {
			return new LadderHeight(InputView.readHeight());
		} catch (IllegalArgumentException e){
			OutputView.printError(e.getMessage());
			return retrieveLadderHeight();
		}
	}

	private LadderWidth changeIntoWidth(final int userCount) {
		return new LadderWidth( userCount - 1);
	}
}
