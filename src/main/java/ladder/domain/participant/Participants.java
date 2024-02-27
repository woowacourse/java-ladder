package ladder.domain.participant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Participants {

    private static final int MAXIMUM_RECEPTION_COUNT = 10;

    private final List<Name> names;

    public Participants(List<String> inputNames) {
        validate(inputNames);
        this.names = inviteParticipants(inputNames);
    }

    public Participants(Collection<Name> participantsName) {
        this.names = new ArrayList<>(participantsName);
    }

    private void validate(List<String> names) {
        validateIsNotOverMaximumReception(names);
        validateHasNotDuplicateName(names);
    }

    private void validateIsNotOverMaximumReception(List<String> names) {
        if (names.size() > MAXIMUM_RECEPTION_COUNT) {
            throw new IllegalArgumentException("참여자 인원은 최대 " + MAXIMUM_RECEPTION_COUNT + "명까지 가능합니다.");
        }
    }

    private void validateHasNotDuplicateName(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);

        if (names.size() != uniqueNames.size()) {
            throw new IllegalArgumentException("참여자 이름은 중복을 허용하지 않습니다");
        }
    }

    private List<Name> inviteParticipants(List<String> names) {
        return names.stream()
                .map(Name::new)
                .toList();
    }

    public int getCount() {
        return names.size();
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }

    public Name getNameByIndex(int index) {
        return names.get(index);
    }
}
