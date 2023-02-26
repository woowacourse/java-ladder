package laddergame.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import laddergame.domain.ladder.destination.Destination;
import laddergame.domain.ladder.destination.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DestinationTest {

    private final Destination destination = new Destination(
            List.of(new Item("꽝"), new Item("꽝"), new Item("10000")));

    @ParameterizedTest
    @CsvSource(value = {"0:꽝", "1:꽝", "2:10000"}, delimiter = ':')
    @DisplayName("전달받은 위치에 해당하는 결과를 반환한다.")
    void should_ReturnValue_By_Index(int index, String expected) {
        Item item = destination.get(index);

        assertThat(item.getValue()).isEqualTo(expected);
    }
}
