package ladder.domain;

import java.util.List;
import ladder.util.ExceptionMessageFormatter;

public class Destination {

    private final List<String> destination;

    public Destination(List<String> destination) {
        this.destination = destination;
    }

    public int size() {
        return destination.size();
    }

    public String get(int index) {
        validateIndex(index);
        return destination.get(index);
    }

    // TODO index 관련 검증 클래스 분리 검토
    private void validateIndex(int index) {
        if (index < -1 || index > destination.size() - 1) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.format("주어진 위치가 종착지 정보의 개수보다 큽니다.", index)
            );
        }
    }
}
