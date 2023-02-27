package domain.Collection;

import java.util.ArrayList;
import java.util.List;

public class Sequence {
    private static final String INDEX_OUT_OF_BOUND_ERROR_MESSAGE = "교환 가능한 인덱스는 순서보다 1 작아야합니다.";
    private final List<Integer> sequence;
    
    private Sequence( List<Integer> numbers ) {
        this.sequence = numbers;
    }
    
    public static Sequence of( List<Integer> numbers ) {
        List<Integer> copiedNumbers = new ArrayList<>(numbers);
        return new Sequence(copiedNumbers);
    }
}