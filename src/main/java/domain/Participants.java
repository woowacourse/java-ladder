package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
	private static final int MIN_PARTICIPANTS = 2;
	private static final String NAME_NUMBER_ERROR_MSG = "최소 두 명 이상의 참가자 이름을 입력해야 합니다.";
	private final List<ParticipantName> names;

	public Participants(final List<String> participantNames) {
		validateNameCount(participantNames);
		names = wrapParticipantNames(participantNames);
	}

	private void validateNameCount(final List<String> participantNames) {
		if (participantNames.size() < MIN_PARTICIPANTS) {
			throw new IllegalArgumentException(NAME_NUMBER_ERROR_MSG);
		}
	}

	private List<ParticipantName> wrapParticipantNames(final List<String> participantNames) {
		return participantNames.stream()
			.map(ParticipantName::new)
			.collect(Collectors.toList());
	}

	public int getParticipantsNum() {
		return names.size();
	}

	public List<ParticipantName> getNames() {
		return Collections.unmodifiableList(names);
	}
}

