package controller;

import java.util.List;

import domain.Ladder;
import domain.LadderBuilder;
import domain.LadderHeight;
import domain.Participants;
import domain.util.RandomPointGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

	public void buildLadder() {
		Participants participants = retrieveParticipants();
		LadderHeight height = new LadderHeight(retrieveLadderHeight());
		int width = participants.getParticipantsNum() - 1;
		LadderBuilder ladderBuilder = new LadderBuilder();
		Ladder ladder = ladderBuilder.build(height, width, new RandomPointGenerator());
		OutputView.printResult(participants.getNames(),ladder.getLadderPoints());
	}

	private Participants retrieveParticipants(){
		List<String> names = retrieveParticipantsNames();
		Participants participants = new Participants();
		for (String name : names) {
			participants.add(name);
		}
		return participants;
	}

	private List<String> retrieveParticipantsNames() {
		try {
			List<String> names = InputView.readParticipantsNames();
			return names;
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
