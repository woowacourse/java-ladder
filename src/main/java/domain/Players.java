package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    public static final int MIN_PERSON_COUNT = 2;

    private final List<Player> people;

    public Players(List<String> names) {
        validateDuplicate(names);
        List<Player> people = toList(names);
        validatePersonCount(people);
        this.people = people;
    }

    private void validateDuplicate(List<String> result) {
        if (result.size() != result.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    private List<Player> toList(List<String> names) {
        return names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private void validatePersonCount(List<Player> people) {
        if (people.size() < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException(
                    String.format("사람은 %d명 이상이어야 합니다.", MIN_PERSON_COUNT));
        }
    }

    public Column findColumnByPerson(Player player) {
        int column = IntStream.range(0, people.size())
                .filter(index -> people.get(index).equals(player))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자는 존재하지 않습니다."));
        return Column.of(column);
    }

    public List<Player> getPeople() {
        return people.stream()
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public int getCount() {
        return people.size();
    }
}
