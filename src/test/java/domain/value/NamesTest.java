package domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Names 는")
class NamesTest {

    private final List<Name> nameList1 = List.of(new Name("일"), new Name("말랑"), new Name("둘리"));

    @Test
    void Name_List_를_통해_생성된다() {
        // when & then
        assertDoesNotThrow(() -> new Names(nameList1));
    }

    @ParameterizedTest(name = "이름의 수가 2개 미만인 경우 예외가 발생한다")
    @MethodSource("lessThan2SizeNames")
    void Name_의_수가_2개_미만인_경우_예외가_발생한다(final List<Name> names) {
        // when & then
        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> lessThan2SizeNames() {
        return Stream.of(
                Arguments.of(List.of()),
                Arguments.of(List.of(new Name("1")))
        );
    }

    @ParameterizedTest(name = "첫 이름의 글자 수를 구할 수 있다")
    @CsvSource(value = {
            "산,바다,말랑:1",
            "바다,산,말랑:2",
            "말랑콩떡,산,말랑:4",
    }, delimiter = ':')
    void 첫_이름의_글자_수를_구할_수_있다(final String nameValues, final int actualFirstNameLength) {
        // given
        Names names = new Names(stream(nameValues.split(","))
                .map(Name::new)
                .collect(Collectors.toList())
        );

        // when
        int firstNameLength = names.firstNameLength();

        // then
        assertThat(firstNameLength).isEqualTo(actualFirstNameLength);
    }

    @ParameterizedTest(name = "전체 이름 수를 구할 수 있다")
    @CsvSource(value = {
            "산,바다,말랑:3",
            "바다,산,말랑,토끼:4",
            "안녕하세요,이,글을,보시면,당근을,커멘트로,달아주시면,감사,하겠습니다,잘,부탁드려요:11",
    }, delimiter = ':')
    void 가진_이름의_총_개수를_알_수_있다(final String nameValues, final int actualLength) {
        // given
        Names names = new Names(stream(nameValues.split(","))
                .map(Name::new)
                .collect(Collectors.toList())
        );

        // when
        int size = names.size();

        // then
        assertThat(size).isEqualTo(actualLength);
    }

    @ParameterizedTest(name = "동명이인이_포함된_경우_예외를_발생시킨다.")
    @CsvSource(value = {
            "바다,바다:3",
            "바다,말랑,바다,토끼:4",
    }, delimiter = ':')
    void 동명이인이_포함된_경우_예외를_발생시킨다(final String nameValues) {
        // given
        List<Name> names = stream(nameValues.split(","))
                .map(Name::new)
                .collect(Collectors.toList());

        // when & then
        assertThatThrownBy(() ->
                new Names(names)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}