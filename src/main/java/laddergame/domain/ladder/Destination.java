package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import laddergame.domain.util.IndexValidator;

public class Destination {

    private final List<String> destination;

    public Destination(List<String> destination) {
        this.destination = destination;
    }

    public int size() {
        return destination.size();
    }

    public String get(int index) {
        IndexValidator.validateBounds(index, destination.size(), "주어진 위치가 종착지 정보의 개수보다 큽니다.");
        return destination.get(index);
    }

    public List<String> results() {
        return new ArrayList<>(destination);
    }
}
