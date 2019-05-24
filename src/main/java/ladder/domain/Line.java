package ladder.domain;

import java.util.*;

/**
 * @author heebg
 * @version 1.0 2019-05-18
 */
public class Line implements Iterable<Point> {
    private final List<Point> line;
    private static final Point STARTER = Point.STRAIGHT;
    private static final Point END = Point.STRAIGHT;
    private static final PointGenerate pointGenerate = PointGenerateFactory.getInstance().create(PointGenerateStatus.RANDOM);

    private Line(List<Point> line) {
        this.line = line;
    }

    /**
     * 생성자
     *
     * @return
     */
    public static Line newInstance() {
        List<Point> line = new ArrayList<>();
        return new Line(line);
    }

    /**
     * 생성자
     *
     * @param line Position들
     * @return
     */
    public static Line newInstance(List<Point> line) {
        return new Line(line);
    }

    /**
     * 생성자(임의로 생성)
     *
     * @param rowSize 가로 길이
     * @return
     */
    public static Line newInstance(int rowSize) {
        List<Point> line = new ArrayList<>();
        line.add(PointGenerate.generatePoint(STARTER));
        if (rowSize == 1) {
            return new Line(line);
        }
        for (int i = 1; i < rowSize - 1; i++) {
            line.add(PointGenerate.generatePoint(line.get(i - 1)));
        }
        line.add(END);
        return new Line(line);
    }

    /**
     * 첫번째 Position 추가
     *
     * @return Line
     */
    public Line start() {
        List<Point> line = new ArrayList<>();
        line.add(PointGenerate.generatePoint(STARTER));
        return new Line(line);
    }

    /**
     * Position 추가
     *
     * @return Position
     */
    public Line add() {
        Point preStatus = line.get(line.size() - 1);
        line.add(PointGenerate.generatePoint(preStatus));
        return new Line(line);
    }

    /**
     * 마지막 Position 추가
     *
     * @return Position
     */
    public Line end() {
        line.add(END);
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
        for (Point point : line) {
            sb.append(drawPosition(trueShape, falseShape, point));
        }
        return sb.toString();
    }

    private String drawPosition(String trueShape, String falseShape, Point point) {
        if (point.equals(Point.RIGHT)) {
            return trueShape;
        }
        return falseShape;
    }

    /**
     * line 크기 반환
     *
     * @return size
     */
    public int size() {
        return line.size();
    }

    public Point get(int index) {
        return line.get(index);
    }

    @Override
    public Iterator<Point> iterator() {
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
