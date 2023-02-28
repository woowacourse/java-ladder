package laddergame.domain.participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final String DELIMITER = ",";
    private static final int MIN_COUNT = 2;
    private static final int MAX_COUNT = 10_000;
    private static final int MINIMUM_COUNT = 1;

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

    public Participant findParticipant(final String requestContent) {
        return participants.stream()
                .filter(participant -> participant.isSameName(requestContent))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("[ERROR] %s은 존재하지 않는 이름입니다.", requestContent)));
    }

    private List<String> splitNames(final String names) {
        return Arrays.asList(names.split(DELIMITER));
    }

    private void validateParticipantCount(List<String> participantNames) {
        if (participantNames.size() < MIN_COUNT || participantNames.size() > MAX_COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 참여자는 최소 %d 명부터 최대 %d 명 입니다. 입력된 참여자 수 : %d", MIN_COUNT, MAX_COUNT, participantNames.size()));
        }
    }

    private void validateDuplicateName(List<String> participantNames) {
        int uniqueCount = (int) participantNames.stream().distinct().count();
        if (uniqueCount != participantNames.size()) {
            String duplicateName = makeDuplicateName(participantNames);
            throw new IllegalArgumentException(String.format("[ERROR] 중복된 이름을 입력할 수 없습니다.%n중복된 이름 : %s%n", duplicateName));
        }
    }

    private String makeDuplicateName(final List<String> participantNames) {
        return participantNames.stream()
                .filter(name -> Collections.frequency(participantNames, name) > MINIMUM_COUNT)
                .distinct()
                .collect(Collectors.joining(DELIMITER));
    }

    private List<Participant> makeParticipants(final List<String> participantNames) {
        List<Participant> participants = new ArrayList<>();
        for (int index = 0; index < participantNames.size(); index++) {
            String participantName = participantNames.get(index);
            participants.add(Participant.create(participantName, index));
        }
        return participants;
    }

    public List<Participant> getParticipants() {
        return List.copyOf(participants);
    }
}
