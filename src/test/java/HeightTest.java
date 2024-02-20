import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeightTest {

    @Test
    @DisplayName("숫자를 통해 Height를 생성한다.")
    public void createHeight(){

        Integer value = 5;

        Height height = new Height(value);

        assertEquals(height.getHeight(), value);
    }

}