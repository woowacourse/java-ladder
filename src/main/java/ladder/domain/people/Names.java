package ladder.domain.people;

import ladder.util.StringSplitter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Names {
    private static final Pattern CHARACTER_SET_BETWEEN_1_AND_5_WITH_COMMA = Pattern.compile("(^.{1,5})(,[^.]{1,5})*");

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
        List<String> splitNames = StringSplitter.splitString(names);
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
        Matcher matcher = CHARACTER_SET_BETWEEN_1_AND_5_WITH_COMMA.matcher(names);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력된 플레이어들의 이름 형식이 올바르지 않습니다.");
        }
    }

    private static void validateDuplicateNames(List<String> splitNames) {
        if (getDistinctNames(splitNames) != splitNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
    }

    private static int getDistinctNames(List<String> splitNames) {
        Set<String> distinctNames = new HashSet<>(splitNames);
        return distinctNames.size();
    }
}
