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
    private List<Integer> result;

    /**
     * 생성자
     *
     * @param playerSize
     * @param depth
     */
    public Ladder(int playerSize, int depth) {
        this.ladder = getLadderLines(playerSize, depth);
        this.result = getResultLine(playerSize, depth);
    }

    private List<LadderLine> getLadderLines(int playerSize, int depth) {
        List<LadderLine> ladder = new LinkedList<>();
        for (int i = 0; i < depth; i++) {
            ladder.add(new LadderLine(playerSize));
        }
        return ladder;
    }

    private List<Integer> getResultLine(int playerSize, int depth) {
        List<Integer> moveLine = resetResultLines(playerSize);
        for (int i = 0; i < depth; i++) {
            moveLine = moveRadderLIne(i, moveLine);
        }
        return moveLine;
    }

    private List<Integer> resetResultLines(int playerSize) {
        List<Integer> line = new ArrayList<>();
        for (int i = 0; i < playerSize; i++) {
            line.add(i);
        }
        return line;
    }

    private List<Integer> moveRadderLIne(int depth, List<Integer> moveLine) {
        for (int i = 0; i < moveLine.size(); i++) {
            int nowPosition = moveLine.get(i);
            moveLine.set(i, nowPosition + ladder.get(depth).getNextPosition(nowPosition));
        }
        return moveLine;
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

    /**
     * 사다리 결과값 반환.
     *
     * @return
     */
    public List<Integer> getResult() {
        return this.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(this.ladder, ladder.ladder) &&
                Objects.equals(result, ladder.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder, result);
    }
}
