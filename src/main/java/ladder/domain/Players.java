package ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class Players {

    private static final int MIN_PEOPLE_COUNT = 2;

    private final List<Player> people;

    public Players(List<String> names) {
        validate(names);
        people = names.stream()
                .map(Player::new)
                .toList();
    }

    private void validate(List<String> names) {
        validatePeopleCount(names);
        validateDuplicatedName(names);
    }

    private void validatePeopleCount(List<String> names) {
        if (names.size() < MIN_PEOPLE_COUNT) {
            throw new IllegalArgumentException("참여자는 최소 %d명입니다.".formatted(MIN_PEOPLE_COUNT));
        }
    }


    private void validateDuplicatedName(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }

    public int count() {
        return people.size();
    }

    public Stream<Player> stream() {
        return people.stream();
    }
}
