package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Destinations {
    public static Destinations of(final List<String> destinations, final int userCount) {
        final int destinationsCount = new ArrayList<>(destinations).size();
        if (destinationsCount != userCount) {
            throw new IllegalArgumentException("실행 결과 수는 사용자 수와 같아야 합니다.");
        }
        return new Destinations();
    }
}
