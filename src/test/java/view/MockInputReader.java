package view;

import util.InputReader;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class MockInputReader implements InputReader {
    private final Iterator<String> mockValues;

    public MockInputReader(String... mockValues) {
        this.mockValues = Arrays.stream(mockValues)
                .collect(Collectors.toList())
                .iterator();
    }

    @Override
    public String readInput() {
        if (mockValues.hasNext()) {
            return mockValues.next();
        }
        throw new ArrayIndexOutOfBoundsException("더이상 주입할 수 있는 모킹 값이 없습니다.");
    }
}
