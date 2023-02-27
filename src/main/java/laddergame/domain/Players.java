package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {
    private static final int PLAYER_MIN_COUNT = 2;
    private static final int PLAYER_MAX_COUNT = 12;

    private static final String MAX_NAME_LENGTH_STATE_ERROR_MESSAGE = "최대 이름 길이를 찾지 못하였습니다";
    private static final String PLAYER_COUNT_ERROR_MESSAGE = "플레이어 수는 2~12명만 입력 가능합니다.";

    private static final String PLAYER_NAME_DUPLICATE_ERROR_MESSAGE = "플레이어의 이름은 중복이 불가능합니다.";

    private final List<Player> players = new ArrayList<>();

    public Players(List<String> playerNames) {
        checkPlayerCount(playerNames);
        checkDuplicatePlayers(playerNames);
        int position = 0;
        for (String playerName : playerNames) {
            players.add(new Player(playerName, position));
            position++;
        }
    }

    public int getMaxPlayerNameLength() {
        return players.stream()
                .mapToInt(e -> e.getName().length())
                .max()
                .orElseThrow(() -> new IllegalStateException(MAX_NAME_LENGTH_STATE_ERROR_MESSAGE));
    }

    public int getPlayersCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public void rideLadder(List<Line> lines) {
        for (Line line : lines) {
            players.forEach(player -> checkLadderStepAndMove(line, player));
        }
    }

    private static void checkLadderStepAndMove(Line line, Player player) {
        boolean isLeftStep = line.isStep(player.getPosition() - 1);
        boolean isRightStep = line.isStep(player.getPosition());
        player.move(isLeftStep, isRightStep);
    }

    private void checkPlayerCount(List<String> players) {
        if (players.size() < PLAYER_MIN_COUNT || players.size() > PLAYER_MAX_COUNT) {
            throw new IllegalArgumentException(PLAYER_COUNT_ERROR_MESSAGE);
        }
    }

    private void checkDuplicatePlayers(List<String> players) {
        if (players.stream()
                .distinct()
                .count() != players.size()) {
            throw new IllegalArgumentException(PLAYER_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
