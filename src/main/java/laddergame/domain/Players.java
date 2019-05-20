package laddergame.domain;

import java.lang.reflect.Array;
import java.util.*;

public class Players {
    private List<Player> players = new ArrayList<>();

    public Players(String playersNames) {
        checkNullName(playersNames);
        playersNames = playersNames.replaceAll(" ","");
        checkConditions(playersNames);
        List<String> names = new ArrayList<>(Arrays.asList(playersNames.split(",")));
        for (String name : names) {
            players.add(new Player(name));
        }
    }
    static void checkConditions(String playersNames) {
        List<String> names = new ArrayList<>(Arrays.asList(playersNames.split(",")));
        checkDuplicatedName(names);
    }

    private static void checkDuplicatedName(List<String> names) {
        Set<String> namesWithoutDuplicates = new HashSet<>(names);
        if (names.size() != namesWithoutDuplicates.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.\n다시 입력해주세요.");
        }
    }

    private static void checkNullName(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력하신 이름이 null입니다.\n다시 입력해주세요.");
        }
    }

    public int getPeopleCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Players makeNewPlayers() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(players.get(i).getName().getName());
            names.add(sb.toString());
        }
        String newNames = String.join(",",names);
        return new Players(newNames);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
