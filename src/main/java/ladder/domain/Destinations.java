package ladder.domain;

import java.util.List;

public class Destinations {
    public static Destinations of(final List<String> destinations, final int userCount) {
        validateDestinationsCount(destinations, userCount);
        return new Destinations();
    }

    private static void validateDestinationsCount(final List<String> destinations, final int userCount) {
        if (destinations.size() != userCount) {
            throw new IllegalArgumentException("실행 결과 수는 사용자 수와 같아야 합니다.");
        }
    }
}
