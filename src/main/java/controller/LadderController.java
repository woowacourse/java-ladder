package controller;

import java.util.List;
import java.util.Map;

import domain.end.End;
import domain.end.Ends;
import domain.ladder.Ladder;
import domain.ladder.LadderBuilder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderWidth;
import domain.user.User;
import domain.user.Users;
import domain.util.IndexMover;
import domain.util.RandomPointGenerator;
import domain.util.ResultMapper;
import view.InputView;
import view.OutputView;

public class LadderController {

	public void runLadderGame() {
		Users users = retrieveUsers();
		Ends ends = retrieveEnds(users.getUsersCount());
		Ladder ladder = buildLadder(users);
		OutputView.printLadder(users, ladder, ends);
		Map<User, End> mappedResult = mapResult(ladder, users, ends);
		while (true) {
			printResult(mappedResult);
		}
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
			return new Ends(InputView.readEndNames(), userCount);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveEnds(userCount);
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
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveLadderHeight();
		}
	}

	private LadderWidth changeIntoWidth(final int userCount) {
		return new LadderWidth(userCount - 1);
	}

	private Map<User, End> mapResult(final Ladder ladder, final Users users, final Ends ends) {
		List<Integer> movedIndex = IndexMover.getMovedIndex(ladder);
		return ResultMapper.map(users.getUsers(), ends.getEnds(), movedIndex);
	}

	private void printResult(final Map<User, End> mappedResult) {
		try {
			List<String> names = InputView.readWhomToPrint();
			Map<User, End> result = ResultMapper.toResult(mappedResult, names);
			OutputView.printResult(result);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			printResult(mappedResult);
		}
	}
}
