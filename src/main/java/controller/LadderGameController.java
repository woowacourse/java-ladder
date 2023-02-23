package controller;

import domain.*;
import domain.util.PointGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {

	private final LadderGame ladderGame;

	public LadderGameController() {
		Participants participants = retrieveParticipants();
		Results results = retrieveResults();
		LadderHeight ladderHeight = retrieveHeight();
		LadderWidth ladderWidth = new LadderWidth(participants.getParticipantsNum() - 1);
		Ladder ladder = Ladder.create(ladderHeight, ladderWidth, PointGenerator.getInstance(true));
		this.ladderGame = new LadderGame(participants, results, ladder);
	}

	public void runGame() {
		OutputView.printLadder(ladderGame.getParticipants(), ladderGame.getLadder(), ladderGame.getResults());
		ladderGame.run();
		String name = retrieveNameToFind();
		while (!name.equals("all")) {
			printResult(name);
			name = retrieveNameToFind();
		}
		printAllResult();
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

	private Results retrieveResults() {
		try {
			String[] results = InputView.readResults();
			return Results.of(results);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveResults();
		}
	}

	// TODO: LadderHeight, LadderWidth -> Singleton
	private LadderHeight retrieveHeight() {
		try {
			int height = InputView.readHeight();
			return new LadderHeight(height);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveHeight();
		}
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

	private void printAllResult() {
		OutputView.printAllResult(ladderGame.getParticipants(), ladderGame.getAllGameResult());
	}

	private void printResult(String name) {
		Participant participant = Participant.from(name);
		Result result = ladderGame.getResultFrom(participant);
		OutputView.printParticipantResult(result);
	}
}
