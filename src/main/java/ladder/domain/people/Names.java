package ladder.domain.people;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Names {

    private static final Pattern INPUT_NAMES_PATTERN = Pattern.compile("([a-zA-Z]{1,5})(,[a-zA-Z]{1,5})*");
    private static final int MINIMUM_NAMES_RANGE = 2;
    private static final int MAXIMUM_NAMES_RANGE = 100;

    private final List<String> names;

    public Names(String names) {
        this.names = split(names);
    }

    public List<String> getNames() {
        return this.names;
    }

    private List<String> split(String names) {
        validateNamesInputForm(names);
        List<String> splitNames = namesSplit(names);
        validateRange(splitNames);
        validateDuplicateNames(splitNames);
        return splitNames;
    }

    private void validateRange(List<String> splitNames) {
        if (splitNames.size() < MINIMUM_NAMES_RANGE || splitNames.size() > MAXIMUM_NAMES_RANGE) {
            throw new IllegalArgumentException("이름의 수가 2이상 100이하여야 합니다.");
        }
    }

    private void validateNamesInputForm(String names) {
        Matcher matcher = INPUT_NAMES_PATTERN.matcher(names);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력된 플레이어들의 이름 형식이 올바르지 않습니다.");
        }
    }

    private List<String> namesSplit(String names) {
        return Arrays.stream(names.split(","))
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateDuplicateNames(List<String> splitNames) {
        if (getDistinctNames(splitNames) != splitNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }

    private int getDistinctNames(List<String> splitNames) {
        return (int) splitNames.stream()
                .distinct()
                .count();
    }
}
