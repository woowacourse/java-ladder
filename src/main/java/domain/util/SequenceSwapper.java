package domain.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequenceSwapper {
    
    private static final String INDEX_OUT_OF_BOUND_ERROR_MESSAGE = "교환 가능한 인덱스는 순서보다 1 작아야합니다.";
    private final List<Integer> sequence;
    
    private SequenceSwapper( List<Integer> numbers ) {
        this.sequence = new ArrayList<>(numbers);
    }
    
    public static SequenceSwapper initialize( int length ) {
        int[] numbers = IntStream.range(0, length).toArray();
        return SequenceSwapper.of(numbers);
    }
    
    public static SequenceSwapper of( int... numbers ) {
        return new SequenceSwapper(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }
    
    public void swap( int index ) {
        if ( index >= this.sequence.size() - 1 ) {
            throw new IndexOutOfBoundsException(INDEX_OUT_OF_BOUND_ERROR_MESSAGE);
        }
        int temporary = this.sequence.get(index);
        this.sequence.set(index, this.sequence.get(index + 1));
        this.sequence.set(index + 1, temporary);
    }
    
    public List<Integer> getSequence() {
        return Collections.unmodifiableList(this.sequence);
    }
}