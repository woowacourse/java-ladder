import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeightTest {

    @Test
    @DisplayName("입력된 숫자 문자열을 통해 Height를 생성한다.")
    public void createHeight(){

        String value = "5";

        Height height = new Height(value);

        assertEquals(height.getHeight(), value);
    }

    @Test
    @DisplayName("입력된 문자열이 숫자가 아니면 예외를 발생한다.")
    public void throwExceptionWhenInputStringIsNotNumber(){

        String value = "five";
        
        assertThrows(IllegalArgumentException.class, () -> new Height(value));

    }

}