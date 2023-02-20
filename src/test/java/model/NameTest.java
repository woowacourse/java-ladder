package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "aaaaa"})
    void 생성자는_전달받은_name의_길이가_1_이상_5_이하라면_Name을_생성한다(String name) {
        assertThatCode(() -> new Name(name)).doesNotThrowAnyException();
    }

    @Test
    void 생성자는_전달받은_name의_길이가_5를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Name("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 최대 5글자까지만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "           "})
    void 생성자는_전달받은_name이_공백이면_예외가_발생한다(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 공백일 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"a:a", "b:b", "c:c"}, delimiter = ':')
    void equals_메소드는_같은_이름을_가진_Name을_전달하면_true를_반환한다(String firstName, String secondName) {
        Name nameA = new Name(firstName);
        Name nameB = new Name(secondName);

        assertThat(nameA.equals(nameB)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"a:b", "b:c", "c:a"}, delimiter = ':')
    void equals_메소드는_다른_이름을_가진_Name을_전달하면_false를_반환한다(String firstName, String secondName) {
        Name nameA = new Name(firstName);
        Name nameB = new Name(secondName);

        assertThat(nameA.equals(nameB)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"a:true", "b:false"}, delimiter = ':')
    void matchesByName_메소드는_이름을_입력하면_이름_일치_여부를_반환한다(String name, boolean expected) {
        Name participant = new Name("a");

        boolean actual = participant.matchesByName(name);

        assertThat(actual).isSameAs(expected);
    }
}
