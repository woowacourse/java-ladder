package ladder.domain;

import static java.util.Collections.unmodifiableList;

import java.util.List;
import java.util.stream.IntStream;

public class GameResults {
    private final List<UserDestination> userDestinations;

    public GameResults(
            UserNames userNames,
            List<Integer> stepPositions,
            Destinations destinations) {
        this.userDestinations = generateGameResults(userNames, stepPositions, destinations);
    }

    private List<UserDestination> generateGameResults(
            UserNames userNames,
            final List<Integer> stepPositions,
            Destinations destinations) {
        Destinations swappedDestinations = destinations.swapDestinations(stepPositions);
        return IntStream.range(0, userNames.getUserCount())
                .mapToObj(i -> new UserDestination(userNames.findByOrder(i), swappedDestinations.findByOrder(i)))
                .toList();
    }

    public String findByUserName(final String requestName) {
        UserDestination userDestination = userDestinations.stream()
                .filter(result -> result.isSameName(requestName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참여자입니다."));
        return userDestination.getDestination().value();
    }

    public List<UserDestination> findAll() {
        return unmodifiableList(userDestinations);
    }
}
