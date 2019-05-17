package laddergame.domain.player;

import laddergame.ValidateBuilder;
import laddergame.domain.BuilderObject;
import laddergame.domain.Constant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayersBuilder extends ValidateBuilder {
    private final String names;

    public PlayersBuilder(final String names) {
        this.names = names;
    }

    @Override
    public BuilderObject build() {
        validate(names);
        List<Player> players = Arrays.asList(names.split(Constant.COMMA)).stream()
                .map(String::trim)
                .map(Player::new)
                .collect(Collectors.toList());

        checkDuplication(players);
        return new Players(players);
    }

    private void checkDuplication(List<Player> players) {
        if (new HashSet<>(players).size() != players.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayersBuilder)) return false;
        PlayersBuilder that = (PlayersBuilder) o;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
