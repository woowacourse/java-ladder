package ladder.domain;

import java.util.*;

/**
 * Player가 모여있는 객체
 * <br> Players players = Players.newInstance("pobi, crong, name");
 *
 * @author heebg
 * @version 1.0 2019-05-17
 */
public class Players implements Iterable<Player> {
    private static final int CNT_MIN_INPUT_RANGE = 1;
    private static final String EX_INPUT_COUNT = CNT_MIN_INPUT_RANGE + "명 이상 입력해야 합니다.";
    private static final String EX_INPUT_DUPLE = "중복된 이름은 사용할 수 없습니다.";
    private static final String SIGN_SEPARATOR = ",";

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = checkCondition(players);
    }

    /**
     * 생성자
     *
     * @param names 이름들
     * @return Players
     */
    public static Players newInstance(String names) {
        List<Player> ladderPlayers = new ArrayList<>();
        for (String name : names.split(SIGN_SEPARATOR)) {
            ladderPlayers.add(Player.newInstance(name));
        }
        return new Players(ladderPlayers);
    }

    private List<Player> checkCondition(List<Player> players) {
        ThrowException.checkArgument(players.size() < CNT_MIN_INPUT_RANGE, EX_INPUT_COUNT);
        checkInputDuple(players, EX_INPUT_DUPLE);
        return players;
    }

    private void checkInputDuple(List<Player> players, String message) {
        Set<Player> checkDuple = new HashSet<>();
        for (Player player : players) {
            checkDuple.add(player);
        }
        ThrowException.checkArgument(checkDuple.size() != players.size(), message);
    }

    /**
     * Player 추가
     * <br> players.add("name")
     *
     * @param playerName
     * @return Players
     */
    public Players add(String playerName) {
        players.add(Player.newInstance(playerName));
        return new Players(players);
    }

    /**
     * Players 크기
     *
     * @return size
     */
    public int size() {
        return players.size();
    }

    /**
     * Players의 index번 째 Player 반환
     *
     * @param index 위치
     * @return Player
     */
    public Player get(int index) {
        return players.get(index);
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
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
