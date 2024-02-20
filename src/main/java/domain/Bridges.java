package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Bridges {
    private final List<Boolean> brides;

    public Bridges(int height) {
        validate(height);
        brides = IntStream.range(0, height)
                .mapToObj((index) -> Boolean.FALSE)
                .toList();
    }

    private void validate(int height) {
        if(height <= 0){
            throw new IllegalArgumentException("");
            //TODO : 예외 메시지 추가해주기
        }
    }

    public List<Boolean> getBridges() {
        return brides;
    }
}
