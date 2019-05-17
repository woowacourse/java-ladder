package ladder.domain;

import java.util.List;

public class Result {
    private static final int RESULT_MAX_LENGTH = 6;
    private final List<String> results;

    public Result(List<String> results) {
        this.results = results;
    }

    String getResult(int index) {
        return results.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String result : results) {
            sb.append(makeBlank(result));
            sb.append(result);
        }
        return sb.toString();
    }

    private String makeBlank(String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < RESULT_MAX_LENGTH - name.length(); i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
