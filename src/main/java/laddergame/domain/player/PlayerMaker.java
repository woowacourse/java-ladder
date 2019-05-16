package laddergame.domain.player;

import laddergame.domain.Constant;
import laddergame.domain.inputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayerMaker {
    private final String names;

    public PlayerMaker(final String names) {
        this.names = names;
    }

    public List<Player> makePlayers() {
        inputValidator.validateInput(names);

        return Arrays.asList(names.split(Constant.COMMA)).stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerMaker)) return false;
        PlayerMaker that = (PlayerMaker) o;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
