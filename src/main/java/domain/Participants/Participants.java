package domain.Participants;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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
            throw new IllegalArgumentException("[ERROR] 참가자는 " + MIN_OF_PARTICIPANTS_COUNT + "명 이상 "
                    + MAX_OF_PARTICIPANTS_COUNT + "명 이하여야 합니다.");
        }
    }

    private void validateDuplicate(List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException("[ERROR] 참가자 이름은 중복될 수 없습니다.");
        }
    }

    public boolean isMatchCount(int expectedSize) {
        return expectedSize == names.size();
    }

    public boolean hasParticipated(String comparisonName) {
        return names.stream()
                .anyMatch(participantsName -> participantsName.equals(new Name(comparisonName)));
    }

    public int checkParticipantOrder(String name) {
        return IntStream.range(0, names.size())
                .filter(i -> names.get(i).equals(new Name(name)))
                .findFirst()
                .getAsInt();
    }

    public List<Name> getParticipantsName() {
        return Collections.unmodifiableList(names);
    }

    public int getParticipantsCount() {
        return names.size();
    }
}
