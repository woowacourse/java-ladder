package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PointTest {
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("주어진 Boolean 값에 해당하는 Point를 반환한다.")
    void createPoint(boolean value) {
        Point point = Point.from(value);
        Assertions.assertEquals(point.isConnected(), value);
    }
}
