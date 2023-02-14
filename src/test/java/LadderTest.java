import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {0,11})
    @DisplayName("사다리 높이가 1~10을 벗어나면 예외가 발생한다.")
    void LadderHeightTest(int height){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> new Ladder(height));
    }
}
