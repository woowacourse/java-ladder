package controller;

import domain.*;
import domain.util.RandomPointGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

	public void buildLadder() {
		Participants participants = retrieveParticipants();
		LadderHeight height = new LadderHeight(retrieveLadderHeight());
		LadderWidth width = participatnsNum2LadderWidth(participants.getParticipantsNum());
        Ladder ladder = Ladder.build(height, width, new RandomPointGenerator());
		OutputView.printResult(participants.getNames(),ladder.getLadderPoints());
	}

	private LadderWidth participatnsNum2LadderWidth(int participantsNum){
		return new LadderWidth( participantsNum - 1);
	}

	private Participants retrieveParticipants(){
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
