package domain;

import constant.domain.ParticipantsExceptionMessage;

import java.util.List;
import java.util.Objects;

public class Participants {

    public static final int MIN_OF_PARTICIPANTS_COUNT = 2;
    public static final int MAX_OF_PARTICIPANTS_COUNT = 50;

    private final List<Name> names;

    public Participants(List<String> names) {
        validateCount(names);
        validateDuplicate(names);
        this.names = names.stream()
                .map(Name::new)
                .toList();
    }

    private void validateCount(List<String> names) {
        if (names.size() < MIN_OF_PARTICIPANTS_COUNT || MAX_OF_PARTICIPANTS_COUNT < names.size()) {
            throw new IllegalArgumentException(ParticipantsExceptionMessage.OUT_OF_RANGE_PARTICIPANTS_COUNT.getExceptionMessage());
        }
    }

    private void validateDuplicate(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException(ParticipantsExceptionMessage.DUPLICATE_PARTICIPANTS.getExceptionMessage());
        }
    }

    public List<Name> getNames() {
        return names;
    }

    public int getParticipantsCount() {
        return names.size();
    }

    public int getIndexOfName(String inputName) {
        for (int i = 0; i < names.size(); i++) {
            if (Objects.equals(names.get(i).getName(), inputName)) {
                return i;
            }
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 참가자입니다.");
    }
}
