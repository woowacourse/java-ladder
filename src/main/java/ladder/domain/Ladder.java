package ladder.domain;

import java.util.*;

/**
 * @author heebg
 * @version 1.0 2019-05-18
 */
public class Ladder {
    private final String FALSE_SHAPE = "|     ";
    private final String TRUE_SHAPE = "|-----";

    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    /**
     * 생성자
     *
     * @param rowSize
     * @param depth
     * @return
     */
    public static Ladder newBuilder(int rowSize, int depth) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < depth; i++) {
            ladder.add(Line.newBuilder(rowSize));
        }
        return new Ladder(ladder);
    }

    /**
     * 생성자
     *
     * @param lines
     * @return
     */
    public static Ladder newBuilder(List<Line> lines) {
        return new Ladder(lines);
    }

    /**
     * 모양 반환
     *
     * @return
     */
    public String draw() {
        return draw(TRUE_SHAPE, FALSE_SHAPE);
    }

    /**
     * 모양 반환
     *
     * @param trueString
     * @param falseString
     * @return
     */
    public String draw(String trueString, String falseString) {
        StringJoiner shapes = new StringJoiner("\n");
        for (Line line : ladder) {
            shapes.add(line.draw(trueString, falseString));
        }
        return shapes.toString();
    }

    /**
     * 사다리 결과 반환
     *
     * @return
     */
    public LineResult executeResult() {
        LineResult result = LineResult.newBuilder(ladder.get(0).size());
        for (Line line : ladder) {
            result = result.move(line);
        }
        return result;
    }

    /**
     * 사다리 결과 반환
     *
     * @param players 입력값
     * @param items   결과값
     * @return LadderResult
     */
    public LadderResult makeResult(Players players, Items items) {
        return LadderResult.newBuild(players, items, executeResult());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(this.ladder, ladder.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }
}
