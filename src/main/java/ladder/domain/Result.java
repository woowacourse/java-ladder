package ladder.domain;

import ladder.util.InputHelper;

import java.util.List;

public class Result {
    private static final String EXCEPTION_MESSAGE = "양식에 맞게 입력해 주세요.";
    private static final String NOT_EQUAL_COUNT_MESSAGE = "결과의 개수는 %d개가 필요합니다.";
    private static final String BLANK_RESULT_MESSAGE = "결과를 꼭 모두 입력해주세요.";
    private static final int RESULT_MAX_LIMIT = 5;
    private final List<String> results;

    public Result(String results, Person person) {
        this.results = checkResult(results, person.getCountOfPerson());
    }

    private List<String> checkResult(String inputs, int countOfPerson) {
        isEmpty(inputs);
        hasSpace(inputs);
        checkLastIndex(inputs);
        List<String> results = InputHelper.splitNames(inputs);
        isSameLength(countOfPerson, results);
        for (String result : results) {
            isOverMaxInputLimit(result);
        }
        return results;
    }

    private void isEmpty(String inputs) {
        if (inputs == null || inputs.length() == 0) {
            throw new IllegalArgumentException(BLANK_RESULT_MESSAGE);
        }
    }

    private void checkLastIndex(String inputs) {
        if (inputs.lastIndexOf(",") == inputs.length() - 1) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private void hasSpace(String inputs) {
        if (inputs.contains(" ")) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private void isOverMaxInputLimit(String input) {
        if (input.length() > RESULT_MAX_LIMIT) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    private void isSameLength(int countOfPerson, List<String> results) {
        if (countOfPerson != results.size()) {
            throw new IllegalArgumentException(String.format(NOT_EQUAL_COUNT_MESSAGE, countOfPerson));
        }
    }

    public List<String> getResults() {
        return results;
    }

    String getResult(int index) {
        return results.get(index);
    }

}
