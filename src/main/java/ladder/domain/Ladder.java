package ladder.domain;

import java.util.*;

/**
 * 사다리를 그려주는 클래스
 * <br> 가로, 세로를 넣어준다.
 * <br> Ladder ladder = new Ladder(5,4)
 * <br> ladder.
 *
 * @author heebg, hyojaekim
 * @version 1.0 2019-05-16
 */
public class Ladder {
    private List<LadderLine> ladder;
    private List<Player> players;

    /**
     * 생성자
     *
     * @param players
     * @param depth
     */
    public Ladder(List<Player> players, int depth) {
        this.ladder = getLadderLines(players.size(), depth);
        this.players = players;
        moveResultPosition(depth);
    }

    private List<LadderLine> getLadderLines(int playerSize, int depth) {
        List<LadderLine> ladder = new LinkedList<>();
        for (int i = 0; i < depth; i++) {
            ladder.add(new LadderLine(playerSize));
        }
        return ladder;
    }

    private void moveResultPosition(int depth) {
        for (int i = 0; i < depth; i++) {
            moveOneLinePosition(i);
        }
    }

    private void moveOneLinePosition(int depth) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            ladder.get(depth).movePlayerPosition(player, player.getPosition());
        }
    }

    /**
     * 사다리 모양 반환
     *
     * @return
     */
    public String drawLadderShape() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (LadderLine ladderLine : ladder) {
            stringJoiner.add(ladderLine.toString());
        }
        return stringJoiner.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }
}
