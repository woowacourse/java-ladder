package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import ladder.util.ExceptionMessageFormatter;

public class LadderGame {

    private final Players players;

    public LadderGame(List<String> names) {
        validatePlayerCount(names.size());
        List<Player> players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());

        this.players = new Players(players);
    }
    
    private static void validatePlayerCount(int playerCount) {
        if (playerCount < Players.MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.format("참여자가 " + Players.MIN_PLAYER_COUNT + "명 이상이어야 사다리를 만들 수 있습니다.",
                            playerCount));
        }
    }

    public List<Line> play(int height, List<String> results) {
        Ladder ladder = Ladder.of(new LineWidth(players.size()), new LadderHeight(height), results);
        return ladder.toUnModifiableLines();
    }

    public List<String> getPlayerNames() {
        return players.getNames();
    }
}
