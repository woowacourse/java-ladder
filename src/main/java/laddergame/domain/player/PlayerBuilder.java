package laddergame.domain.player;

import laddergame.domain.inputValidator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayerBuilder {
    private final static String COMMA = ",";

    private final String names;

    public PlayerBuilder(final String names) {
        this.names = names;
    }

    public Players buildPlayers() {
        inputValidator.validateInput(names);
        List<Player> players = Arrays.stream(names.split(COMMA))
                .map(String::trim)
                .map(Player::new)
                .collect(Collectors.toList());
        checkDuplication(players);
        return new Players(players);
    }

    private void checkDuplication(List<Player> players) {
        if(new HashSet<>(players).size() != players.size()){
            throw new IllegalArgumentException("중복이 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerBuilder)) return false;
        PlayerBuilder that = (PlayerBuilder) o;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
