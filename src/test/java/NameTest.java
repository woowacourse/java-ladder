import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {
    @Test
    @DisplayName("문자열을 통해 이름을 생성한다.")
    public void createName(){
        //Given
        String value = "도비";

        //When
        Name name = new Name(value);

        //Then
        assertInstanceOf(Name.class,name);
        assertEquals(name.getValue(),value);
    }
}
