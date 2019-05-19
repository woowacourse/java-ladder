package ladder.domain;

import java.util.*;

/**
 * @author heebg
 * @version 1.0 2019-05-18
 */
public class LadderResult {
    private final String SIGN_EX_NAME = "all";

    private final Map<Player, Item> ladderResult;

    private LadderResult(Players players, Items items, LineResult result) {
        Map<Player, Item> ladderResult = new LinkedHashMap<>();
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            Item item = items.get(result.get(i));
            ladderResult.put(player, item);
        }
        this.ladderResult = ladderResult;
    }

    /**
     * 생성자
     *
     * @param players
     * @param items
     * @param result
     * @return
     */
    public static LadderResult newBuild(Players players, Items items, LineResult result) {
        return new LadderResult(players, items, result);
    }

    /**
     * 사다리 결과 반환
     *
     * @return
     */
    public Map<Player, Item> getResult() {
        return ladderResult;
    }

    /**
     * 해당 이름에 해당하는 사다리 결과 반환
     *
     * @param name
     * @return
     */
    public String matchItem(String name) {
        if (name.equals(SIGN_EX_NAME)) {
            return allItem();
        }
        return ladderResult.get(Player.newBuilder(name)).toString();
    }

    /**
     * 모든 결과 반환
     *
     * @return string
     */
    private String allItem() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Map.Entry<Player, Item> playerRewardEntry : ladderResult.entrySet()) {
            stringJoiner.add(playerRewardEntry.getKey() + " : " + playerRewardEntry.getValue());
        }
        return stringJoiner.toString();
    }

    /**
     * 모든 결과 반환
     *
     * @return Map
     */
    public Map allMatchItem() {
        return ladderResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(ladderResult, that.ladderResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResult);
    }
}
