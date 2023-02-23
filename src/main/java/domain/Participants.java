package domain;

import domain.util.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Participants implements Display {

	private static final String PARTICIPANT_DELIMITER = "";

	private final List<Participant> participants = new ArrayList<>();

	public void add(final Participant name) {
		participants.add(name);
	}

	public int getParticipantsNum() {
		return participants.size();
	}

	public Participant get(int index){
		return participants.get(index);
	}

	@Override
	public String format() {
		String formattedNames = participants.stream()
				.map(Participant::format)
				.collect(Collectors.joining(PARTICIPANT_DELIMITER));
		return formattedNames;
	}
}

