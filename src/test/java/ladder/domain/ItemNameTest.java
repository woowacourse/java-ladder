package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings({"NonAsciiCharacters", "SpellCheckingInspection"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ItemNameTest {

    @Test
    void 이름이_잘_생성됨() {
        assertThatCode(() -> new ItemName("pobi"))
                .doesNotThrowAnyException();
    }

    @Test
    void 이름이_null이면_예외발생() {
        assertThatThrownBy(() -> new ItemName(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1이상 5이하로 입력해주세요. 현재 이름이 null 입니다.");
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"123456"})
    void 이름이_1부터_5글자가_아니라면_예외발생(String name) {
        assertThatThrownBy(() -> new ItemName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1이상 5이하로 입력해주세요. 현재 이름의 길이는 " + name.length() + " 입니다.");
    }

    @Test
    void 이름이_공백으로_이루어지면_예외() {
        assertThatThrownBy(() -> new ItemName("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 공백으로 입력할 수 없습니다.");
    }

    @Test
    void 이름을_반환한다() {
        ItemName itemName = new ItemName("pobi");
        assertThat(itemName.getName())
                .isEqualTo("pobi");
    }
}
