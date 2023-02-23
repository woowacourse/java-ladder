package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    public static final String PLAYER_COUNT_ERROR_MESSAGE = "플레이어 수는 2~12명만 입력 가능합니다.";
    private static final int PLAYER_MIN_COUNT = 2;
    private static final int PLAYER_MAX_COUNT = 12;
    private static final int PLAYER_NAME_MAX_SIZE = 5;
    private static final String BLANK = " ";
    private static final String NON_BLANK = "";
    private static final String PLAYER_NAME_LENGTH_ERROR_MESSAGE = "플레이어 이름음 1~5글자만 가능합니다.";
    private static final String PLAYER_NAME_DUPLICATE_ERROR_MESSAGE = "플레이어의 이름은 중복이 불가능합니다.";

    private final List<Player> players = new ArrayList<>();

    public Players(List<String> playerNames) {
        checkPlayerCount(playerNames);
        checkPlayerNameLength(playerNames);
        checkDuplicatePlayers(playerNames);
        int position = 0;
        for (String playerName : playerNames) {
            players.add(new Player(playerName, position));
            position++;
        }
    }

    public int getMaxPlayerNameLength() {
        return players.stream().mapToInt(e -> e.getName().length()).max().orElse(0);
    }

    public int getPlayersCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getTargetPlayer(String name) {
        return players.stream()
                .filter(player -> player.isTarget(name))
                .findAny()
                .orElseThrow(()->new IllegalStateException("일치하는 플레이어가 없습니다"));
    }

    private void checkPlayerCount(List<String> players) {
        if (players.size() < PLAYER_MIN_COUNT || players.size() > PLAYER_MAX_COUNT) {
            throw new IllegalArgumentException(PLAYER_COUNT_ERROR_MESSAGE);
        }
    }

    private void checkPlayerNameLength(List<String> players) {
        if (players.stream()
                .anyMatch(player -> player.length() >
                        PLAYER_NAME_MAX_SIZE || player.replaceAll(BLANK, NON_BLANK).isEmpty())) {
            throw new IllegalArgumentException(PLAYER_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void checkDuplicatePlayers(List<String> players) {
        if (players.stream().distinct().count() != players.size()) {
            throw new IllegalArgumentException(PLAYER_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
