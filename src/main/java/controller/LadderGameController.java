package controller;

import domain.LadderGame;
import domain.LadderHeight;
import domain.Participant;
import domain.Participants;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

	public void run() {
		LadderGame ladderGame = setUpLadderGame();
		OutputView.printLadder(
				ladderGame.getParticipants(),
				ladderGame.getLadder()
		);
	}

	// TODO: extract this method to LadderGame.setup()
	public LadderGame setUpLadderGame() {
		Participants participants = retrieveParticipants();
		LadderHeight ladderHeight = new LadderHeight(retrieveLadderHeight());
		return new LadderGame(participants, ladderHeight);
	}

	private Participants retrieveParticipants() {
		List<Participant> names = retrieveParticipantsNames();
		Participants participants = new Participants();
		for (Participant name : names) {
			participants.add(name);
		}
		return participants;
	}

	private List<Participant> retrieveParticipantsNames() {
		try {
			List<String> names = InputView.readParticipantsNames();
			return names.stream().map(Participant::new).collect(Collectors.toList());
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveParticipantsNames();
		}
	}

	// TODO: makes method to return LadderHeight
	private int retrieveLadderHeight() {
		try{
			return InputView.readHeight();
		} catch (IllegalArgumentException e){
			OutputView.printError(e.getMessage());
			return retrieveLadderHeight();
		}
	}

}
