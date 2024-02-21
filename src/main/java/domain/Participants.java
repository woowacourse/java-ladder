package domain;

import java.util.List;

public class Participants {

    public static final int MIN_OF_PARTICIPANTS_COUNT = 2;
    public static final int MAX_OF_PARTICIPANTS_COUNT = 50;
    private final List<Person> participants;

    public Participants(List<String> names) {
        validateCount(names);
        validateDuplicate(names);
        this.participants = names.stream()
                .map(Person::new)
                .toList();
    }

    private void validateCount(List<String> names) {
        if (names.size() < MIN_OF_PARTICIPANTS_COUNT || names.size() > MAX_OF_PARTICIPANTS_COUNT) {
            throw new IllegalArgumentException(
                    "[ERROR] 참가자는 " + MIN_OF_PARTICIPANTS_COUNT + "명 이상 "
                            + MAX_OF_PARTICIPANTS_COUNT + "명 이하여야 합니다.");
        }
    }

    private void validateDuplicate(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException("[ERROR] 참가자 이름은 중복될 수 없습니다.");
        }
    }

    public List<String> getParticipantsName() {
        return participants.stream()
                .map(Person::getName)
                .toList();
    }

    public int getParticipantsCount() {
        return participants.size();
    }
}
