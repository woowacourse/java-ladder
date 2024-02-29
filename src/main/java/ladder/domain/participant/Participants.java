package ladder.domain.participant;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Participants {

    private static final int MAXIMUM_RECEPTION_COUNT = 10;
    private final List<Name> names;

    public Participants(List<String> inputNames) {
        validate(inputNames);
        this.names = enrollNames(inputNames);
    }

    private void validate(List<String> names) {
        validateParticipantIsNotOverMaximumCount(names);
        validateHasNotDuplicatedName(names);
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }

    public int size() {
        return names.size();
    }

    public int findNamePosition(Name name) {
        int index = names.indexOf(name);

        if (index == -1) {
            throw new IllegalArgumentException("입력한 이름이 존재하지 않습니다.");
        }
        return index;
    }

    private List<Name> enrollNames(List<String> names) {
        return names.stream()
                .map(Name::new)
                .toList();
    }

    private void validateParticipantIsNotOverMaximumCount(List<String> names) {
        if (names.size() > MAXIMUM_RECEPTION_COUNT) {
            throw new IllegalArgumentException("참여자 인원은 최대 " + MAXIMUM_RECEPTION_COUNT + "명까지 가능합니다.");
        }
    }

    private void validateHasNotDuplicatedName(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);

        if (names.size() != uniqueNames.size()) {
            throw new IllegalArgumentException("참여자 이름은 중복을 허용하지 않습니다");
        }
    }
}
