package domain;

import domain.util.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Participants implements Display {

	private static final String PARTICIPANT_DELIMITER = "";

	private final List<ParticipantName> names = new ArrayList<>();

	public void add(final ParticipantName name) {
		names.add(name);
	}

	public int getParticipantsNum() {
		return names.size();
	}


	@Override
	public String format() {
		String formattedNames = names.stream()
				.map(ParticipantName::format)
				.collect(Collectors.joining(PARTICIPANT_DELIMITER));
		return formattedNames;
	}
}

