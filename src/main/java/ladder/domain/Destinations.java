package ladder.domain;

import static java.util.Collections.replaceAll;
import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<Destination> swapDestinations(final List<Integer> stepPositions) {
        List<Destination> swappedDestinations = new ArrayList<>(destinations);
        for (int position : stepPositions) {
            Collections.swap(swappedDestinations, position, position + 1);
        }
        return swappedDestinations;
    }

    public Destination findByOrder(final int order) {
        if (order < 0 || order >= destinations.size()) {
            throw new IndexOutOfBoundsException("유효하지 않은 값입니다.");
        }
        return destinations.get(order);
    }

    public List<Destination> getDestinations() {
        return unmodifiableList(destinations);
    }
}
