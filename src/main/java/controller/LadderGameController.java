package controller;

import domain.LadderGame;
import domain.LadderHeight;
import domain.ParticipantName;
import domain.Participants;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

	public void run() {
		LadderGame ladderGame = setUpLadderGame();
		OutputView.printResult(
				ladderGame.getParticipantsNames(),
				ladderGame.getLadderPoints()
		);
	}

	public LadderGame setUpLadderGame() {
		Participants participants = retrieveParticipants();
		LadderHeight ladderHeight = new LadderHeight(retrieveLadderHeight());
		return new LadderGame(participants, ladderHeight);
	}


	private Participants retrieveParticipants() {
		List<ParticipantName> names = retrieveParticipantsNames();
		Participants participants = new Participants();
		for (ParticipantName name : names) {
			participants.add(name);
		}
		return participants;
	}

	private List<ParticipantName> retrieveParticipantsNames() {
		try {
			List<String> names = InputView.readParticipantsNames();
			return names.stream().map(ParticipantName::new).collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveParticipantsNames();
		}
	}

	private int retrieveLadderHeight() {
		try{
			return InputView.readHeight();
		} catch (IllegalArgumentException e){
			OutputView.printError(e.getMessage());
			return retrieveLadderHeight();
		}
	}

}
