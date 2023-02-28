package ladder.domain;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import ladder.util.StringSplitter;

public class Names {

    private static final Pattern NAMES_FORMAT = Pattern.compile("[^,]+(,[^,]+)+");

    private final List<Name> names;

    public Names(String names) {
        validateNames(names);

        this.names = StringSplitter.split(names, ",")
            .stream()
            .map(Name::new)
            .collect(Collectors.toList());
    }

    public Names(String names, int expectedCount) {
        this(names);
        validateNamesCount(expectedCount);
    }

    private void validateNames(String names) {
        validateNull(names);
        validateFormat(names);
    }

    private void validateNull(String names) {
        if (names == null) {
            throw new IllegalArgumentException("아무 값도 입력되지 않았습니다.");
        }
    }

    private void validateFormat(String names) {
        if (!NAMES_FORMAT.matcher(names).matches()) {
            throw new IllegalArgumentException("이름이 형식과 맞지 않습니다");
        }
    }

    private void validateNamesCount(int expectedCount) {
        if (this.names.size() != expectedCount) {
            throw new IllegalArgumentException(
                String.format("입력하는 이름의 개수는 %d와 같아야 합니다.(입력된 이름의 수 : %d)",
                    expectedCount, this.names.size()));
        }
    }

    public int findNamesCount() {
        return names.size();
    }

    public Name findNameByIndex(int index) {
        return names.get(index);
    }

    public Name findName(String rawName) throws IllegalArgumentException {
        final Name name = new Name(rawName);
        if (!names.contains(name)) {
            throw new IllegalArgumentException("찾으려는 이름이 이름 목록에 존재하지 않습니다.");
        }
        return name;
    }

    public List<String> getNames() {
        return names.stream()
            .map(Name::getValue)
            .collect(Collectors.toList());
    }
}
