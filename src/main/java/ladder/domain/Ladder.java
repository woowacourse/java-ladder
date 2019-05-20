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
     * @param row
     * @param depth
     */
    public Ladder(int row, int depth) {
        this.ladder = setLadder(row, depth);
        this.result = setResult(row, depth);
    }

    /**
     * 사다리 결과값 반환.
     *
     * @return
     */
    public List<Integer> getResult() {
        return this.result;
    }

    /**
     * 사다리 모양 반환
     *
     * @return
     */
    public String getLadderShape() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (LadderLine ladderLine : ladder) {
            stringJoiner.add(ladderLine.toString());
        }
        return stringJoiner.toString();
    }

    private List<LadderLine> setLadder(int row, int depth) {
        List<LadderLine> ladder = new LinkedList<>();
        for (int i = 0; i < depth; i++) {
            ladder.add(new LadderLine(row));
        }
        return ladder;
    }

    private List<Integer> setResult(int row, int depth) {
        List<Integer> starter = setStater(row);
        for (int i = 0; i < depth; i++) {
            starter = moveRadderLIne(i, starter);
        }
        return starter;
    }

    private List<Integer> setStater(int row) {
        List<Integer> stater = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            stater.add(i);
        }
        return stater;
    }

    private List<Integer> moveRadderLIne(int depth, List<Integer> starter) {
        for (int i = 0; i < starter.size(); i++) {
            int nowPosition = starter.get(i);
            starter.set(i, nowPosition + ladder.get(depth).getNextPosition(nowPosition));
        }
        return starter;
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
