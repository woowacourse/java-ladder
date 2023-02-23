package domain.Collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

	private final List<Participant> participants;

	private Participants(List<Participant> participants) {
		this.participants = participants;
	}

	public static Participants of(String... values) {
		List<Participant> participantList = Arrays.stream(values)
				.map(Participant::from)
				.collect(Collectors.toList());
		return new Participants(participantList);
	}

	public void add(final Participant name) {
		participants.add(name);
	}

	public int getParticipantsNum() {
		return participants.size();
	}

	public Participant get(int index) {
		return participants.get(index);
	}

	public List<Participant> getParticipants() {
		return Collections.unmodifiableList(this.participants);
	}

}

