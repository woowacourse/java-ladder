package domain;

import domain.util.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Participants implements Display {

	private static final String PARTICIPANT_DELIMITER = "";

	private final List<Participant> participants = new ArrayList<>();

	//TODO: SFM 구현 및 List<String>으로부터 참여자 생성하기
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

