package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class NamesTest {

    @Nested
    class 생성자_테스트 {

        @Test
        void 인자로_3_이상의_names를_전달하면_Names를_생성한다() {
            assertThatCode(() -> new Names(List.of(new Name("a"), new Name("b"))))
                    .doesNotThrowAnyException();
        }

        @Test
        void 인자로_2_이하의_names를_전달하면_예외가_발생한다() {
            assertThatThrownBy(() -> new Names(List.of(new Name("a"))))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("최소 2명의 이름을 입력해주세요.");
        }
    }

    @Nested
    class findNameByIndex_메소드_테스트 {

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2})
        void findNameByIndex_메소드는_index를_전달하면_index의_이름을_반환한다(int index) {
            List<String> inputNames = List.of("a", "b", "c");
            Names names = new Names(inputNames.stream().map(Name::new).collect(Collectors.toList()));

            assertThat(names.findNameByIndex(index)).isEqualTo(inputNames.get(index));
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, 3})
        void findNameByIndex_메소드는_names_컬렉션의_index를_벗어난_index면_예외가_발생한다(int index) {
            List<String> inputNames = List.of("a", "b", "c");
            Names names = new Names(inputNames.stream().map(Name::new).collect(Collectors.toList()));

            assertThatThrownBy(() -> names.findNameByIndex(index))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("관리하고 있는 names의 index 범위를 벗어났습니다.");
        }
    }

    @Nested
    class findIndexByName_메소드_테스트 {

        @Test
        void findIndexByName_메소드는_없는_이름이_주어지면_예외가_발생한다() {
            Names names = new Names(List.of(new Name("a"), new Name("b")));

            assertThatThrownBy(() -> names.findIndexByName("c"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력한 이름의 참가자가 없습니다.");
        }

        @ParameterizedTest
        @CsvSource(value = {"a:0", "b:1"}, delimiter = ':')
        void findIndexByName_메소드는_이름이_주어지면_이름의_인덱스를_반환한다(String name, int expected) {
            Names names = new Names(List.of(new Name("a"), new Name("b")));

            int actual = names.findIndexByName(name);

            assertThat(actual).isSameAs(expected);
        }
    }

    @Test
    void getTotalParticipantSize_메소드는_호출하면_names의_크기를_반환한다() {
        List<String> inputNames = List.of("a", "b", "c");
        Names names = new Names(inputNames.stream().map(Name::new).collect(Collectors.toList()));

        assertThat(names.getTotalParticipantSize()).isSameAs(3);
    }
}
