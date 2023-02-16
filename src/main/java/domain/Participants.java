package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

	private final List<ParticipantName> names = new ArrayList<>();

	public void add(final ParticipantName name) {
		names.add(name);
	}

	public int getParticipantsNum() {
		return names.size();
	}

	public List<String> getNames(){
		return names.stream()
			.map(ParticipantName::getName)
			.collect(Collectors.toList());
	}
}

