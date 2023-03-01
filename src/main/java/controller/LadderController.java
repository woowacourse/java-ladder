package controller;

import java.util.List;
import java.util.Map;

import domain.LadderGame;
import domain.Results;
import domain.end.End;
import domain.end.Ends;
import domain.ladder.LadderHeight;
import domain.user.User;
import domain.user.Users;
import domain.ladder.RandomPointGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

	public void runLadderGame() {
		Users users = retrieveUsers();
		Ends ends = retrieveEnds(users.getUsersCount());
		LadderHeight height = retrieveLadderHeight();
		LadderGame ladderGame = LadderGame.create(users, ends, height, new RandomPointGenerator());
		OutputView.printLadder(users, ladderGame.getLadder(), ends);
		Map<User, End> mappedResult = ladderGame.getMappedResult();
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

	private LadderHeight retrieveLadderHeight() {
		try {
			return new LadderHeight(InputView.readHeight());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveLadderHeight();
		}
	}

	private void printResult(final Map<User, End> mappedResult) {
		try {
			List<String> names = InputView.readWhomToPrint();
			Map<User, End> result = Results.of(mappedResult, names).getResults();
			OutputView.printResult(result);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			printResult(mappedResult);
		}
	}
}
