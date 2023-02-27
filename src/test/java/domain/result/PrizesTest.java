package domain.result;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("상품들은")
class PrizesTest {

    @Nested
    @DisplayName("생성될 때")
    class GenerateTest{

        @Test
        @DisplayName("상품의 이름들을 받아 생성된다.")
        void generatePrizesTest(){
            assertDoesNotThrow(()-> new Prizes(List.of("꽝", "5000", "1500")));
        }
    }

}
