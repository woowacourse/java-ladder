package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Destinations {
    private final List<Destination> destinations;

    private Destinations(final List<Destination> destinations) {
        this.destinations = destinations;
    }

    public static Destinations of(final List<String> destinations, final int userCount) {
        validateDestinationsCount(destinations, userCount);
        List<String> copiedDestinations = new ArrayList<>(destinations);
        return copiedDestinations.stream()
                .map(Destination::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Destinations::new));
    }

    private static void validateDestinationsCount(final List<String> destinations, final int userCount) {
        if (destinations.size() != userCount) {
            throw new IllegalArgumentException("실행 결과 수는 사용자 수와 같아야 합니다.");
        }
    }

    public List<String> getDestinations() {
        return destinations.stream()
                .map(Destination::value)
                .toList();
    }
}
