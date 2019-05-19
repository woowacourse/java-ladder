package ladder.domain;

import java.util.*;

/**
 * @author heebg
 * @version 1.0 2019-05-18
 */
public class Line implements Iterable<Position> {
    private final String EX_POSITION_ROW_TRUE_DUPLE = "사다리 가로 라인은 연속으로 생길 수 없습니다.";
    private final List<Position> line;

    private Line(List<Position> line) {
        this.line = line;
    }

    /**
     * 생성자
     *
     * @return
     */
    public static Line newBuilder() {
        List<Position> line = new ArrayList<>();
        return new Line(line);
    }

    /**
     * 생성자
     *
     * @param line Position들
     * @return
     */
    public static Line newBuilder(List<Position> line) {
        return new Line(line);
    }

    /**
     * 생성자(임의로 생성)
     *
     * @param rowSize 가로 길이
     * @return
     */
    public static Line newBuilder(int rowSize) {
        List<Position> line = new ArrayList<>();
        line.add(Position.start());
        if (rowSize == 1) {
            return new Line(line);
        }
        for (int i = 1; i < rowSize - 1; i++) {
            line.add(Position.add(line.get(i - 1).status()));
        }
        line.add(Position.end(line.get(rowSize - 2).status()));
        return new Line(line);
    }

    /**
     * 첫번째 Position 추가
     *
     * @param currentStatus 현재 Position 상태
     * @return Line
     */
    public Line start(boolean currentStatus) {
        List<Position> line = new ArrayList<>();
        line.add(Position.start(currentStatus));
        return new Line(line);
    }

    /**
     * Position 추가
     *
     * @param currentStatus 현재 Position 상태
     * @return Position
     */
    public Line add(boolean currentStatus) {
        boolean preStatus = line.get(line.size() - 1).status();
        makeThrows(preStatus && currentStatus, EX_POSITION_ROW_TRUE_DUPLE);
        line.add(Position.add(preStatus, currentStatus));
        return new Line(line);
    }

    /**
     * 마지막 Position 추가
     *
     * @return Position
     */
    public Line end() {
        line.add(Position.end(line.get(line.size() - 1).status()));
        return new Line(line);
    }

    /**
     * 라인 모양 반환
     *
     * @param trueShape
     * @param falseShape
     * @return String
     */
    public String draw(String trueShape, String falseShape) {
        StringBuilder sb = new StringBuilder();
        for (Position position : line) {
            sb.append(drawPosition(trueShape, falseShape, position.status()));
        }
        return sb.toString();
    }

    private String drawPosition(String trueShape, String falseShape, boolean status) {
        if (status) {
            return trueShape;
        }
        return falseShape;
    }

    /**
     * 라인 이동 후 결과 반환
     *
     * @return LineResult
     */
    public LineResult move() {
        return LineResult.newBuilder(line.size()).move(this);
    }

    private void makeThrows(boolean state, String message) {
        if (state) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * line 크기 반환
     *
     * @return size
     */
    public int size() {
        return line.size();
    }

    public Position get(int index) {
        return line.get(index);
    }

    @Override
    public Iterator<Position> iterator() {
        return line.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}
