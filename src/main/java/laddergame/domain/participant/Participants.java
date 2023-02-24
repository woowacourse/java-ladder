package laddergame.domain.participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final String DELIMITER = ",";
    private static final int MIN_COUNT = 2;

    private final List<Participant> participants;

    private Participants(final String names) {
        List<String> participantNames = splitNames(names);
        validateParticipantCount(participantNames);
        validateDuplicateName(participantNames);
        participants = makeParticipants(participantNames);
    }

    public static Participants create(final String names) {
        return new Participants(names);
    }

    public int size() {
        return participants.size();
    }

    public boolean contains(final String requestContent) {
        return participants.stream()
                .anyMatch(participant -> participant.isSameName(requestContent));
    }

    public List<Participant> findParticipants(final String requestContent) {
        if (requestContent.equals("all")) {
            return participants;
        }
        return participants.stream()
                .filter(participant -> participant.isSameName(requestContent))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private List<String> splitNames(final String names) {
        return Arrays.asList(names.split(DELIMITER));
    }

    private void validateParticipantCount(List<String> participantNames) {
        if (participantNames.size() < MIN_COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 참여자는 최소 %d 명 이상 입력해야 합니다.", MIN_COUNT));
        }
    }

    private void validateDuplicateName(List<String> participantNames) {
        int uniqueCount = (int) participantNames.stream().distinct().count();
        if (uniqueCount != participantNames.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름을 입력할 수 없습니다.");
        }
    }

    private List<Participant> makeParticipants(final List<String> participantNames) {
        List<Participant> participants = new ArrayList<>();
        for (int index = 0; index < participantNames.size(); index++) {
            String participantName = participantNames.get(index);
            participants.add(Participant.create(participantName, index));
        }
        return List.copyOf(participants);
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
