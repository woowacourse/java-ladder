package domain;

import java.util.Collections;
import java.util.List;

public class Participants {
	private static final int MIN_PARTICIPANTS = 2;
	private static final String NAME_NUMBER_ERROR_MSG = "최소 두 명 이상의 참가자 이름을 입력해야 합니다.";
	private final List<ParticipantName> names;

	public Participants(final List<ParticipantName> participantNames) {
		validateNameCount(participantNames);
		names = participantNames;
	}

	private void validateNameCount(final List<ParticipantName> participantNames) {
		if (participantNames.size() < MIN_PARTICIPANTS) {
			throw new IllegalArgumentException(NAME_NUMBER_ERROR_MSG);
		}
	}

	public int getParticipantsNum() {
		return names.size();
	}

	public List<ParticipantName> getNames() {
		return Collections.unmodifiableList(names);
	}
}

