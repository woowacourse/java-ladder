package model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private static final int MINIMUM_PARTICIPANT_NUM = 2;

    private final Set<Player> players = new LinkedHashSet<>();

    public Players(List<String> input) {
        validateDuplicateName(input);
        validateMinPlayers(input.size());
        for (String name : input) {
            players.add(new Player(name));
        }
    }

    private void validateDuplicateName(List<String> players) {
        long distinct = players.stream().distinct().count();
        if (distinct < players.size()) {
            throw new IllegalArgumentException("이름에 중복이 존재할 수 없습니다");
        }
    }

    private void validateMinPlayers(int playerNum) {
        if (playerNum < MINIMUM_PARTICIPANT_NUM) {
            throw new IllegalArgumentException("최소 두 명의 참가자가 있어야 합니다");
        }
    }

    public int numberOfPlayer() {
        return this.players.size();
    }

    public String findNameByIndex(int index) {
        return getPlayers().get(index).getName();
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public List<String> getPlayersName() {
        return this.players.stream()
            .map(Player::getName)
            .collect(Collectors.toList());
    }
}
