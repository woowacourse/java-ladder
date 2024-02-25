package ladder.domain;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class Players {
    private final List<Player> players;

    public Players(final List<Player> players) {
        this.players = players;
    }

    public static Players of(final UserNames userNames, final LadderHeight ladderHeight) {
        List<String> userNameValues = userNames.getUserNames();
        return range(0, userNameValues.size())
                .mapToObj(userNameIndex -> Player.of(userNameValues.get(userNameIndex), userNameIndex + 1, ladderHeight.ladderHeight()))
                .collect(collectingAndThen(toList(), Players::new));
    }
}
