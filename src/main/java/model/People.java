package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class People {
    private final List<Person> participants;

    public People(String names) {
        validate(names);
        this.participants = Arrays.stream(names.split(","))
                .map(Person::new)
                .toList();
    }

    public List<Person> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public int numberOfParticipants() {
        return participants.size();
    }

    private void validate(String inputNames) {
        validateSize(inputNames);
        validateDuplicateNames(inputNames);
    }

    private void validateSize(String inputNames) {
        int size = inputNames.split(",").length;
        if (size < 2) {
            throw new IllegalArgumentException("참가인원은 2명 이상이어야 합니다.");
        }
    }

    private void validateDuplicateNames(String inputNames) {
        int numberOfOrigin = inputNames.split(",").length;
        int numberOfDistinct = (int) Arrays.stream(inputNames.split(","))
                .distinct()
                .count();

        if (numberOfOrigin != numberOfDistinct) {
            throw new IllegalArgumentException("중복된 이름은 허용하지 않습니다.");
        }
    }

}
