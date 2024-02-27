package domain;

import domain.player.Player;
import domain.player.Position;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MAX_PLAYER_COUNT = 10;

    private final List<Player> players = new ArrayList<>();

    public Players(final List<String> names) {
        validateNameCount(names.size());

        for (int position = 0; position < names.size(); position++) {
            players.add(new Player(names.get(position), position));
        }
    }

    private void validateNameCount(final int count) {
        if (count < MIN_PLAYER_COUNT || count > MAX_PLAYER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("참가자 수는 %d명 이상 %d명 이하 이어야 합니다.", MIN_PLAYER_COUNT, MAX_PLAYER_COUNT));
        }
    }



    public void setPosition(final int playerIndex, final int resultPosition) {
        final Player player = players.get(playerIndex);
        player.setPosition(resultPosition);
    }

    public Position getPositionBy(final String name) {
        final List<Position> foundPosition = players.stream()
                .filter(player -> Objects.equals(player.getName(), name))
                .map(Player::getPosition)
                .collect(Collectors.toList());

        if (foundPosition.size() != 1) {
            throw new IllegalArgumentException(name + "은/는 참가자가 아닙니다.");
        }

        return foundPosition.get(0);
    }

    public int count() {
        return players.size();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
