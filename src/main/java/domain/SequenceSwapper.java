package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequenceSwapper {

    private final static String INDEX_OUT_OF_BOUND_ERROR_MESSAGE = "교환 가능한 인덱스는 순서보다 1 작아야합니다.";
    private final List<Integer> sequence;

    private SequenceSwapper(List<Integer> sequence) {
        this.sequence = new ArrayList<>(sequence);
    }

    public static SequenceSwapper of(List<Integer> sequence) {
        return new SequenceSwapper(sequence);
    }

    public void swap(int index) {
        if (index >= sequence.size() - 1) {
            throw new IndexOutOfBoundsException(INDEX_OUT_OF_BOUND_ERROR_MESSAGE);
        }
        int temporary = sequence.get(index);
        sequence.set(index, sequence.get(index + 1));
        sequence.set(index + 1, temporary);
    }

    public List<Integer> getSequence() {
        return Collections.unmodifiableList(this.sequence);
    }
}