package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class ResultIndex {
    final private List<Integer> resultIndex;

    ResultIndex(final List<Integer> resultIndex) {
        validateResultIndex(resultIndex);
        this.resultIndex = Collections.unmodifiableList(resultIndex);
    }

    private static void validateResultIndex(final List<Integer> resultIndex) {
        validateEmpty(resultIndex);
        validateDuplication(resultIndex);
        validateRange(resultIndex);
    }

    static void validateEmpty(List<Integer> resultIndex) {
        if (resultIndex == null || resultIndex.size() == 0)
            throw new IllegalArgumentException("결과값 생성 중 결과가 없습니다");
    }

    static void validateDuplication(List<Integer> resultIndex) {
        if (resultIndex.stream().distinct().collect(Collectors.toList()).size() != resultIndex.size()) {
            throw new IllegalArgumentException("결과값 생성 중 중복된 Index가 있습니다.");
        }
    }

    static void validateRange(List<Integer> resultIndex) {
        if (resultIndex.stream().mapToInt(v -> v).max().getAsInt() >= resultIndex.size()
                || resultIndex.stream().mapToInt(v -> v).min().getAsInt() < 0) {

            throw new IllegalArgumentException("결과값 생성 중 연속되지 않은 Index가 있습니다.");
        }
    }

    List<Integer> getResultIndex() {
        return resultIndex;
    }

    int findIndex(int target) {
        return resultIndex.indexOf(target);
    }
}