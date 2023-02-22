package ladder.domain;

import java.util.List;
import ladder.util.ExceptionMessageFormatter;

public class Destination {

    private final List<String> destination;

    public Destination(List<String> destination) {
        this.destination = destination;
    }

    public String getResult(int index) {
        validateIndex(index);
        return destination.get(index);
    }

    private void validateIndex(int index) {
        if (index > destination.size() - 1) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.format("주어진 위치가 종착지 정보의 개수보다 큽니다.", index)
            );
        }
    }
}
