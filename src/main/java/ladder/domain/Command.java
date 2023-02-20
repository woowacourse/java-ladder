package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Command {
    public static final String EMPTY_RESULT = "꽝";

    private final List<String> names;
    private final List<String> results;
    private final int height;

    // 둘다 list<String>이어서 헷갈릴 여지 있다. 빌더 패턴? 값 포장?
    public Command(List<String> names, List<String> results, int height) {
        this.names = names;
        this.results = fillEmptyResults(names, new ArrayList<>(results));
        this.height = height;
    }

    private List<String> fillEmptyResults(final List<String> names, final List<String> results) {
        validateLength(names, results);

        while (names.size() > results.size()) {
            results.add(EMPTY_RESULT);
        }
        return results;
    }

    private void validateLength(List<String> names, List<String> results) {
        if (names.size() < results.size()) {
            throw new IllegalArgumentException("실행 결과의 개수는 참여자의 개수 이하이어야 합니다.");
       }
    }

    public int getWidth() {
        return names.size();
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(results);
    }

    public int getHeight() {
        return height;
    }
}
