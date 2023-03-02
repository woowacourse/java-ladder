package domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


@DisplayName("상품들은")
class PrizesTest {

    private List<String> prizeNames;

    @BeforeEach
    void setUp() {
        prizeNames = new ArrayList<>(List.of("꽝", "5000", "1500"));
    }

    @Nested
    @DisplayName("생성될 때")
    class GenerateTest {

        @Test
        @DisplayName("상품의 이름들을 받아 생성된다.")
        void generatePrizesTest() {
            assertDoesNotThrow(() -> new Prizes(prizeNames));
        }
    }

    @Nested
    @DisplayName("조회할 때")
    class QueryTest {

        @ParameterizedTest
        @DisplayName("번호를 통해서 조회할 수 있다.")
        @CsvSource(value = {"0:꽝", "1:5000", "2:1500"}, delimiter = ':')
        void queryByIndex(final int index, final String prizeName) {
            //given
            Prizes prizes = new Prizes(prizeNames);

            //when
            Prize prize = prizes.query(index);

            //then
            assertThat(prize.getPrize().equals(prizeName))
                    .isTrue();
        }
    }

}
