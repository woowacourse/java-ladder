package domain.model.participant;

import java.util.List;

public class People {
    private static final int SIZE_LIMIT = 2;
    private final List<Person> participants;

    public People(List<String> names) {
        validate(names);
        this.participants = names.stream()
                .map(Person::new)
                .toList();
    }

    public List<Person> getParticipants() {
        return participants;
    }

    public int getNumberOfParticipants() {
        return participants.size();
    }

    private void validate(List<String> inputNames) {
        validateSize(inputNames);
        validateDuplicateNames(inputNames);
    }

    private void validateSize(List<String> inputNames) {
        int size = inputNames.size();
        if (size < SIZE_LIMIT) {
            throw new IllegalArgumentException("참가인원은 2명 이상이어야 합니다.");
        }
    }

    private void validateDuplicateNames(List<String> inputNames) {
        int numberOfOrigin = inputNames.size();
        int numberOfDistinct = (int) inputNames.stream()
                .distinct()
                .count();

        if (numberOfOrigin != numberOfDistinct) {
            throw new IllegalStateException("중복된 이름은 허용하지 않습니다.");
        }
    }

    public Person getNameByOrder(int order) {
        return participants.get(order);
    }

    public String findProperParticipant(String name) {
        if (name.equals("all") || participants.contains(new Person(name))) {
            return name;
        }
        throw new IllegalArgumentException("존재하지 않는 참가자 입니다.");
    }

}
