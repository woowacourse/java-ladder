package ladder.domain.ladder;

import ladder.util.StringSplitter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Results {
    private static final Pattern CHARACTER_SET_BETWEEN_1_AND_5_WITH_COMMA = Pattern.compile("(^.{1,5})(,[^.]{1,5})*");

    private final List<String> results;

    public Results(String results, int peopleSize) {
        this.results = split(results, peopleSize);
    }

    public List<String> getResults() {
        return this.results;
    }

    private List<String> split(String results, int peopleSize) {
        validateNamesInputForm(results);
        List<String> splitResults = StringSplitter.splitString(results);
        validateRange(splitResults.size(), peopleSize);
        return splitResults;
    }

    private void validateRange(int resultSize, int peopleSize) {
        if (resultSize != peopleSize) {
            throw new IllegalArgumentException("사람 수와 결과의 개수가 같아야 합니다.");
        }
    }

    private void validateNamesInputForm(String names) {
        Matcher matcher = CHARACTER_SET_BETWEEN_1_AND_5_WITH_COMMA.matcher(names);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력된 실행결과의 형식이 올바르지 않습니다.");
        }
    }
}
