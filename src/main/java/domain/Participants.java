package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
	private static final int MIN_PARTICIPANTS = 2;
	private static final String NAME_NUMBER_ERROR_MSG = "최소 두 명 이상의 참가자 이름을 입력해야 합니다.";
	private final List<ParticipantName> names = new ArrayList<>();

	public Participants(final List<ParticipantName> participantNames) {
		validateNameCount(participantNames);
		addNames(participantNames);
	}

	private void validateNameCount(List<ParticipantName> participantNames) {
		if (participantNames.size() < MIN_PARTICIPANTS) {
			throw new IllegalArgumentException(NAME_NUMBER_ERROR_MSG);
		}
	}

	private void addNames(List<ParticipantName> participantNames) {
		for (ParticipantName name : participantNames) {
			names.add(name);
		}
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

