package ladder.model;

import ladder.model.objectname.LadderPlayerName;

import java.util.Objects;

public class LadderPlayer {
    private static final String FORMAT_OF_ALIGNED_NAME = "%-" + LadderPlayerName.MAX_LENGTH_OF_PLAYER_NAME + "s";
    private static final String BLANK_FOR_ALIGNMENT_ON_LADDER = " ";
    private final LadderPlayerName playerName;

    public LadderPlayer(final String name) {
        this.playerName = new LadderPlayerName(name);
    }

    public String getPlayerName() {
        return playerName.getName();
    }

    String getAlignedPlayerName() {
        return String.format(FORMAT_OF_ALIGNED_NAME, getPlayerName()) + BLANK_FOR_ALIGNMENT_ON_LADDER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderPlayer that = (LadderPlayer) o;
        return Objects.equals(playerName, that.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }
}
