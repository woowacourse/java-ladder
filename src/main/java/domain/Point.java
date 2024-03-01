//package domain;
//
//import java.util.List;
//import java.util.Objects;
//
//public class Point {
//    public static final Point FIRST_OPEN = new Point(false, true);
//    public static final Point END_OPEN = new Point(true, false);
//    public static final Point CLOSE = new Point(false, false);
//
//    private final Direction direction;
//
//    public Point(Direction direction) {
//        this.direction = direction;
//    }
//
//
//    public int move() {
//        if (left) {
//            return -1;
//        } else if (right) {
//            return 1;
//        }
//        return 0;
//    }
//
//    public int moveByIndex(final int index) {
//        if (left) {
//            return index - 1;
//        } else if (right) {
//            return index + 1;
//        }
//        return index;
//    }
//
//    @Override
//    public boolean equals(final Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        final Point point = (Point) o;
//        return left == point.left && right == point.right;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(left, right);
//    }
//}
