package controller;

import domain.Collection.Participant;
import domain.Collection.Participants;
import domain.Collection.Result;
import domain.Collection.Results;
import domain.Ladder.Ladder;
import domain.Ladder.LadderHeight;
import domain.Ladder.LadderWidth;
import domain.LadderGame.LadderGame;
import domain.util.PointGenerator;
import view.*;

public class LadderGameController {

	private final LadderGame ladderGame;

	public LadderGameController(PointGenerator pointGenerator) {
		Participants participants = retrieveParticipants();
		Results results = retrieveResults(participants.getParticipantsNum());
		LadderHeight ladderHeight = retrieveHeight();
		LadderWidth ladderWidth = retrieveWidth(participants);
		Ladder ladder = Ladder.create(ladderHeight, ladderWidth, pointGenerator);
		this.ladderGame = new LadderGame(participants, results, ladder);
	}

	public void runGame() {
		displayLadder();
		ladderGame.run();
		String name = retrieveNameToFind();
		while (!name.equals("all")) {
			displayGameResult(name);
			name = retrieveNameToFind();
		}
		displayAllGameResults();
	}

	private Participants retrieveParticipants() {
		try {
			String[] names = InputView.readNames();
			return Participants.of(names);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveParticipants();
		}
	}

	private Results retrieveResults(int size) {
		try {
			String[] strings = InputView.readResults(size);
			return Results.of(strings);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveResults(size);
		}
	}

	private LadderHeight retrieveHeight() {
		try {
			int height = InputView.readHeight();
			return LadderHeight.from(height);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveHeight();
		}
	}

	private LadderWidth retrieveWidth(Participants participants) {
		return LadderWidth.from(participants.getParticipantsNum() - 1);
	}

	private String retrieveNameToFind() {
		try {
			String name = InputView.readNameToFind();
			if (name.equals("all")) {
				return name;
			}
			Participant.contains(name);
			return name;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveNameToFind();
		}
	}

	private void displayAllGameResults() {
		String allGameResults = GameResultView.formatAllGameResults(ladderGame.getParticipants(), ladderGame.getAllGameResult());
		OutputView.printAllGameResults(allGameResults);
	}

	private void displayGameResult(String name) {
		Participant participant = Participant.from(name);
		Result result = ladderGame.getResultFrom(participant);
		String formattedResult = GameResultView.formatGameResult(result);
		OutputView.printGameResult(formattedResult);
	}

	private void displayLadder() {
		String names = CollectionView.formatParticipants(ladderGame.getParticipants());
		String ladder = LadderView.formatLadder(ladderGame.getLadder());
		String results = CollectionView.formatResults(ladderGame.getResults());
		OutputView.printLadderResult(names, ladder, results);
	}
}
