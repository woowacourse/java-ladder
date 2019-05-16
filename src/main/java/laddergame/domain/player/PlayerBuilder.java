package laddergame.domain.player;

import laddergame.domain.Constant;
import laddergame.domain.inputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayerBuilder {
    private final String names;

    public PlayerBuilder(final String names) {
        this.names = names;
    }

    public Players makePlayers() {
        inputValidator.validateInput(names);

        List<Player> players = Arrays.asList(names.split(Constant.COMMA)).stream()
                .map(Player::new)
                .collect(Collectors.toList());

        return new Players(players);
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
