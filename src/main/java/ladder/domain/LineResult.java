package ladder.domain;

import java.util.*;

/**
 * @author heebg
 * @version 1.0 2019-05-18
 */
public class LineResult implements Iterable<Integer> {
    private List<Integer> result;

    private LineResult(List<Integer> result) {
        this.result = result;
    }

    /**
     * 생성자
     *
     * @param
     * @return
     */
    public static LineResult newInstance(int rowSize) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < rowSize; i++) {
            result.add(i);
        }
        return new LineResult(result);
    }

    /**
     * 생성자
     *
     * @param result
     * @return
     */
    public static LineResult newInstance(List<Integer> result) {
        return new LineResult(result);
    }

    /**
     * 라인 이동 후 결과 반환
     *
     * @param line 이동할 라인
     * @return
     */
    public LineResult move(Line line) {
        for (int i = 0; i < line.size(); i++) {
            Point nowPoint = line.get(result.get(i));
//            Point prePoint = generatePrePoint(line, i);
            result.set(i, nowPoint.move(result.get(i)));
        }
        return new LineResult(result);
    }

//    private Point generatePrePoint(Line line, int i) {
//        if (result.get(i) == 0) {
//            return Point.FALSE;
//        }
//        return line.get(result.get(i)-1);
//    }

    /**
     * 해당 인덱스 값 반환
     *
     * @param index
     * @return
     */
    public int get(int index) {
        return result.get(index);
    }

    @Override
    public Iterator<Integer> iterator() {
        return result.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineResult result1 = (LineResult) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
