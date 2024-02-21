package domain;

import java.util.Arrays;
import java.util.List;

public class Participants {

    public static final int MIN_OF_PARTICIPANTS_COUNT = 2;
    public static final int MAX_OF_PARTICIPANTS_COUNT = 50;
    private final List<Person> participants;

    public Participants(String[] names) {
        validateCount(names);
        validateDuplicate(names);
        this.participants = Arrays.stream(names)
                .map(Person::new)
                .toList();
    }

    private void validateCount(String[] names) {
        if (names.length < MIN_OF_PARTICIPANTS_COUNT || names.length > MAX_OF_PARTICIPANTS_COUNT) {
            throw new IllegalArgumentException(
                    "[ERROR] 참가자는 " + MIN_OF_PARTICIPANTS_COUNT + "명 이상 "
                            + MAX_OF_PARTICIPANTS_COUNT + "명 이하여야 합니다.");
        }
    }

    private void validateDuplicate(String[] names) {
        if (Arrays.stream(names).distinct().count() != names.length) {
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
