package laddergame.domain;

import java.util.Objects;

//vo 불변객체 현구막 블로그
public class Position {

    private int position;

    private Position(final int position) {
        this.position = position;
    }

    public static Position from(final int position) {
        return new Position(position);
    }

    public void moveRight() {
        position++;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return position;
    }
}
