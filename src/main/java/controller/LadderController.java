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
	public void makeLadder() {
		Participants participants = retrieveParticipants();
		Ladder ladder = buildLadder(participants);
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

	private Ladder buildLadder(Participants participants) {
		LadderHeight height = retrieveLadderHeight();
		LadderWidth width = changeIntoWidth(participants.getParticipantsNum());
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

	private LadderWidth changeIntoWidth(final int participantsNum) {
		return new LadderWidth( participantsNum - 1);
	}
}
