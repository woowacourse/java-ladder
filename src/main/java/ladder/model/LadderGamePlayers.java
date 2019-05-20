package ladder.model;

import ladder.constant.MessageConstant;
import ladder.controller.LadderGameController;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class LadderGamePlayers {
    private final List<LadderPlayer> ladderPlayers;

    public LadderGamePlayers(final List<LadderPlayer> players) {
        this.ladderPlayers = getAccuracyOf(players);
    }

    private List<LadderPlayer> getAccuracyOf(List<LadderPlayer> players) {
        if (isOnePlayer(players)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_LACK_OF_PLAYERS);
        }
        if (isOverlapPlayer(players)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_OVERLAP_PLAYERS);
        }
        checkReservedWords(players);
        return players;
    }

    private boolean isOnePlayer(List<LadderPlayer> players) {
        return players.size() == 1;
    }

    private boolean isOverlapPlayer(List<LadderPlayer> players) {
        Set<LadderPlayer> nonOverlappedPlayers = new HashSet<>(players);
        return nonOverlappedPlayers.size() != players.size();
    }

    private void checkReservedWords(List<LadderPlayer> players) {
        for (LadderPlayer player : players) {
            checkReservedWords(player);
        }
    }

    private void checkReservedWords(LadderPlayer player) {
        String playerName = player.getPlayerName();
        if (playerName.equals(LadderGameController.ALL_RESULTS)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_RESERVED_WORD_ALL);
        }
        if (playerName.equals(LadderGameController.EXIT_PROGRAM)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_RESERVED_WORD_EXIT);
        }
    }

    public List<String> getAllAlignedPlayerNames() {
        return ladderPlayers.stream()
                .map(LadderPlayer::getAlignedPlayerName)
                .collect(toList());
    }

    public int size() {
        return ladderPlayers.size();
    }

    public List<String> getAllPlayerNames() {
        return ladderPlayers.stream()
                .map(LadderPlayer::getPlayerName)
                .collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LadderGamePlayers that = (LadderGamePlayers) o;
        return Objects.equals(ladderPlayers, that.ladderPlayers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderPlayers);
    }
}
