package ladder.domain;

import ladder.view.LadderDepthException;
import ladder.view.PlayerException;
import ladder.view.RewardException;

import java.util.*;

/**
 * 사다리 결과 값을 저장하는 클래스
 * <br> LadderResult radderResult = new RadderResult("pobi, crong, hi", "꽝, 1000, 2000", 5)
 * <br> radderResult.getResultOfName("pobi")
 * <br> radderResult.getResultOfName("all")
 *
 * @author heebg, hyojaekim
 * @version 1.0 2019-05-16
 */
public class LadderResult {
    public static final String LADDERRESULT_GET_RESULT_ALL = "all";
    private static final String NOT_FIND_PLAYER = "존재하지 않는 플레이어 입니다.";

    private Ladder ladder;
    private Map<Player, Item> result;

    /**
     * 생성자
     *
     * @param names
     * @param rewards
     * @param depth
     */
    public LadderResult(String names, String rewards, int depth) {
        PlayerException.playerNames(names);
        RewardException.reward(rewards, names.split(",").length);
        LadderDepthException.ladderMinDepth(depth);
        List<Player> players = getPlayers(names);
        this.ladder = getLadder(players, depth);
        this.result = getResult(players, convertItems(rewards));
    }

    private List<Item> convertItems(String items) {
        items = items.replace(" ", "");
        List<Item> convertItems = new ArrayList<>();
        for (String item : items.split(",")) {
            convertItems.add(new Item(item));
        }
        return convertItems;
    }

    /**
     * 이름의 결과값 반환
     *
     * @param name
     * @return
     */
    public String getResultOfName(String name) {
        if (name.equals(LADDERRESULT_GET_RESULT_ALL)) {
            return getResultOfAllName();
        }
        return matchPlayerItem(name);
    }

    private String matchPlayerItem(String name) {
        try {
            return result.get(new Player(name)).toString();
        } catch (NullPointerException e) {
            throw new NullPointerException(NOT_FIND_PLAYER);
        }
    }

    private String getResultOfAllName() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (Map.Entry<Player, Item> entry : result.entrySet()) {
            stringJoiner.add(entry.getKey() + " : " + entry.getValue());
        }
        return stringJoiner.toString();
    }

    /**
     * 사다리 모양 출력
     *
     * @return
     */
    public String drawLadderShape() {
        return ladder.drawLadderShape();
    }

    private Ladder getLadder(List<Player> players, int depth) {
        return new Ladder(players, depth);
    }

    private List<Player> getPlayers(String playerNames) {
        List<Player> players = new ArrayList<>();
        List<String> names = Arrays.asList(playerNames.replaceAll(" ", "").split(","));
        for (int index = 0; index < names.size(); index++) {
            players.add(new Player(names.get(index), index));
        }
        return players;
    }

    private Map<Player, Item> getResult(List<Player> players, List<Item> items) {
        Map<Player, Item> result = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            result.put(player, player.findItem(items));
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(ladder, that.ladder) &&
                Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder, result);
    }
}
