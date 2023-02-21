package controller;

import domain.end.Ends;
import domain.ladder.Ladder;
import domain.ladder.LadderBuilder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderWidth;
import domain.user.Users;
import domain.util.RandomPointGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {
	private static final String END_NAMES_COUNT_INVALID_ERROR_MSG = "결과의 수가 참여자의 수와 같아야 합니다.";

	public void makeLadder() {
		Users users = retrieveUsers();
		Ends ends = retrieveEnds(users.getUsersCount());
		Ladder ladder = buildLadder(users);
		OutputView.printLadder(users, ladder, ends);
	}

	private Users retrieveUsers() {
		try {
			return new Users(InputView.readUserNames());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveUsers();
		}
	}

	private Ends retrieveEnds(final int userCount) {
		try {
			Ends ends = new Ends(InputView.readEndNames());
			validateEndsCount(ends, userCount);
			return ends;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveEnds(userCount);
		}
	}

	private static void validateEndsCount(final Ends ends, final int expected) {
		if (ends.getEndsCount() != expected) {
			throw new IllegalArgumentException(END_NAMES_COUNT_INVALID_ERROR_MSG);
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
