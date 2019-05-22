package laddergame.domain.player;

import laddergame.domain.InputValidator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayerBuilder {
    private final static String COMMA = ",";

    public static Players buildPlayers(String names) {
        InputValidator.validateInput(names);
        List<Player> players = Arrays.stream(names.split(COMMA))
                .map(String::trim)
                .map(Player::new)
                .collect(Collectors.toList());
        checkDuplication(players);
        return new Players(players);
    }

    private static void checkDuplication(List<Player> players) {
        if(new HashSet<>(players).size() != players.size()){
            throw new IllegalArgumentException("중복이 있습니다.");
        }
    }
}
