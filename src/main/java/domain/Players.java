package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {

    public static final int MINIMUM_NUMBER_OF_PLAYERS = 2;

    private final List<Player> players;

    public Players(List<Player> players) throws IllegalArgumentException {
        validateMoreThanOnePlayer(players);
        this.players = new ArrayList<>(players);
    }

    private void validateMoreThanOnePlayer(List<Player> players) {
        if (players.size() < MINIMUM_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException("[ERROR] 플레이어는 두 명 이상 입력해야 합니다.");
        }
    }

    public int getNumberOfPlayers() {
        return this.players.size();
    }

    public int findMaxPlayerNameLength() {
        int maxLength = 0;

        for (Player player : getPlayers()) {
            maxLength = Math.max(maxLength, player.getName().length());
        }

        return maxLength;
    }

    public void validateExistPlayer(String playerName) {
        boolean isExist = false;

        if (playerName.equals("all")) {
            return;
        }
        for (Player player : players) {
            isExist = isTherePlayerByName(playerName, player);
            if (isExist) break;
        }
        if (!isExist) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 사람입니다.");
        }
    }

    private boolean isTherePlayerByName(String playerName, Player player) {
        return player.getName().equals(playerName);
    }

    public void changePosition(int index1, int index2) {
        Collections.swap(players, index1, index2);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }
}
