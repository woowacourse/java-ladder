package ladder.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 참가자의 이름과 위치를 가지고 있는 Player 를 가지고 있는 클래스입니다
 */
public class Players {

    private static final int MINIMUM_PLAYER_COUNT = 2;
    private static final String LESS_THAN_MINIMUM_PLAYER_MESSAGE =
            "참가자는 " + MINIMUM_PLAYER_COUNT + "명 이상이어야 합니다. 현재 : %s";

    private final List<Player> players = new ArrayList<>();

    Players(List<String> playerNames) {
        validatePlayerNames(playerNames);
        for (int i = 0; i < playerNames.size(); i++) {
            players.add(new Player(playerNames.get(i), i));
        }
    }

    private void validatePlayerNames(List<String> playerNames) {
        if (playerNames.size() < MINIMUM_PLAYER_COUNT) {
            throw new IllegalArgumentException(String.format(LESS_THAN_MINIMUM_PLAYER_MESSAGE, playerNames.size()));
        }
    }

    public int size() {
        return players.size();
    }

    List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    Map<String, Position> calculateResult(Ladder ladder) {
        //그냥 바로 collect toMap 만 호출하면 순서가 보장이 되지 않아서 LinkedHashMap 으로 감싸준다
        return players.stream()
                .collect(Collectors.toMap(
                        Player::getName,
                        player -> player.calculateResult(ladder),
                        (x, y) -> y,
                        LinkedHashMap::new)
                );
    }
}
