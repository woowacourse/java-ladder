package laddergame.domain.result;

import laddergame.domain.Constant;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Destination {
    private final String destination;

    public Destination(String destination) {
        if (StringUtils.isBlank(destination)) {
            throw new IllegalArgumentException("공백을 입력하였습니다");
        }
        if (destination.length() > Constant.BOUND_OF_NAME_LENGTH) {
            throw new IllegalArgumentException("5자리 이하 결과만 입력 가능합니다.");
        }
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Destination)) return false;
        Destination destination1 = (Destination) o;
        return Objects.equals(destination, destination1.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination);
    }

    @Override
    public String toString() {
        return this.destination;
    }
}
