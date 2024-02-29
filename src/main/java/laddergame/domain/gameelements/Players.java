package laddergame.domain.gameelements;

import java.util.Collections;
import java.util.List;

// TODO Players, Prizes 분리하기
public class Players {

    private static final int MIN_PLAYER_NUMBER = 1;
    private static final int MAX_PLAYER_NUMBER = 100;

    private final List<Name> playerNames;

    public Players(List<String> playerNames) {
        validatePlayerNumber(playerNames);
        this.playerNames = playerNames.stream()
                .map(Name::new)
                .toList();
    }

    private void validatePlayerNumber(List<String> elements) {
        if (elements.size() < MIN_PLAYER_NUMBER || elements.size() > MAX_PLAYER_NUMBER) {
            throw new IllegalArgumentException("게임 요소의 수는 1이상 100이하만 가능합니다.");
        }
    }

    //TODO Stream.java의 toList() 살펴보기
    public List<Name> getPlayerNames() {
        return Collections.unmodifiableList(playerNames);
    }
}
