package domain;

import java.util.*;

public class Players {

    private final List<Player> players = new ArrayList<>();

    public Players(List<String> names) {
        validateNamesLength(names);
        validateDuplicatedNames(names);

        makePlayers(names);
    }

    private void validateNamesLength(List<String> names) {
        if (names.size() == 0) {
            throw new IllegalArgumentException("참가자는 한 명 이상 입력해야 합니다.");
        }
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException("참가자의 이름은 중복될 수 없습니다.");
        }
    }

    private void makePlayers(List<String> names) {
        for (String name : names) {
            players.add(new Player(name));
        }
    }

    public Player findPlayersByName(String name) {
        return players.stream()
                .filter(player -> player.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참가자 이름입니다."));
    }

    public Player findPlayersByPosition(int position) {
        return players.get(position);
    }

    public int getPlayersCount() {
        return players.size();
    }
}
