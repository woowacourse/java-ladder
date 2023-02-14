import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    @DisplayName("Ladder의 라인이 겸치는지 확인하는 기능")
    void continuousLineTest() {
        Line line = new Line();
        Assertions.assertThrows(IllegalArgumentException.class, line::method);
    }
}
