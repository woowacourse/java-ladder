package controller;

import java.util.List;
import java.util.stream.Collectors;

import domain.Ladder;
import domain.LadderBuilder;
import domain.LadderHeight;
import domain.LadderWidth;
import domain.ParticipantName;
import domain.Participants;
import domain.util.RandomPointGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {
	public void buildLadder() {
		Participants participants = retrieveParticipants();
		LadderHeight height = new LadderHeight(retrieveLadderHeight());
		LadderWidth width = getWidthFromParticipantsNum(participants.getParticipantsNum());
		LadderBuilder ladderBuilder = new LadderBuilder();
		Ladder ladder = ladderBuilder.build(height, width, new RandomPointGenerator());
		OutputView.printResult(participants, ladder);
	}

	private Participants retrieveParticipants() {
		try {
			List<ParticipantName> names = retrieveParticipantsNames();
			return new Participants(names);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return retrieveParticipants();
		}
	}

	private List<ParticipantName> retrieveParticipantsNames() {
		List<String> names = InputView.readParticipantsNames();
		return names.stream()
			.map(ParticipantName::new)
			.collect(Collectors.toList());
	}

	private int retrieveLadderHeight() {
		try {
			return InputView.readHeight();
		} catch (IllegalArgumentException e){
			OutputView.printError(e.getMessage());
			return retrieveLadderHeight();
		}
	}

	private LadderWidth getWidthFromParticipantsNum(final int participantsNum) {
		return new LadderWidth( participantsNum - 1);
	}
}
