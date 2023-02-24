package ladder.domain.item;

import static ladder.domain.ladder.Position.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ItemTest {

    @Test
    void 실행결과가_정상적으로_생성된다() {
        final Item item = new Item("name", valueOf(0));

        assertThat(item.getName()).isEqualTo("name");
    }

    @ParameterizedTest(name = "입력받은 위치와 같은 위치인지 확인한다. 위치: {0}, 결과 {1}")
    @CsvSource({"0,true", "1,false"})
    void 입력받은_위치와_같은_위치인지_확인한다(final int position, final boolean result) {
        final Item item = new Item("item", valueOf(0));

        assertThat(item.isSamePosition(valueOf(position))).isEqualTo(result);
    }
}
