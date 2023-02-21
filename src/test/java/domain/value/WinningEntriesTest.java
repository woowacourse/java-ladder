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

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("WinningEntries 는")
class WinningEntriesTest {

    private final List<WinningEntry> winningEntries = List.of(
            new WinningEntry("말랑"),
            new WinningEntry("바다"),
            new WinningEntry("최고")
    );

    private final Names names = new Names(
            List.of(new Name("바다 🌊"), new Name("진짜"), new Name("최고"))
    );

    @Test
    void forNames_는_WinningEntry_List_와_Names_를_통해_생성한다() {
        // when
        WinningEntries winningEntries = WinningEntries.forNames(this.winningEntries, names);

        // then
        assertThat(winningEntries.winningEntries())
                .containsExactlyInAnyOrderElementsOf(this.winningEntries);
    }

    @ParameterizedTest(name = "당첨항목의 수가 이름의 수와 다르면 예외가 발생한다")
    @MethodSource("differentSizeWinningEntriesAndNames")
    void forNames_는_WinningEntry_List_와_Names_의_수가_다르면_예외가_발생한다(final List<WinningEntry> winningEntries, final Names names) {
        // when & then
        assertThatThrownBy(() -> WinningEntries.forNames(winningEntries, names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> differentSizeWinningEntriesAndNames() {
        return Stream.of(
                Arguments.of(
                        List.of(new WinningEntry("바다"), new WinningEntry("말랑")),
                        new Names(List.of(new Name("바다이름"), new Name("말랑이름"), new Name("바다최고")))
                ),
                Arguments.of(
                        List.of(new WinningEntry("바다"), new WinningEntry("말랑"), new WinningEntry("바다최고")),
                        new Names(List.of(new Name("바다이름"), new Name("말랑이름")))
                )
        );
    }

    @ParameterizedTest(name = "당첨항목의 수가 2개 미만인 경우 예외가 발생한다")
    @MethodSource("lessThan2SizeWinningEntries")
    void WinningEntry_의_수가_2개_미만인_경우_예외가_발생한다(final List<WinningEntry> winningEntries) {
        // when & then
        assertThatThrownBy(() -> WinningEntries.forNames(winningEntries, names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> lessThan2SizeWinningEntries() {
        return Stream.of(
                Arguments.of(List.of()),
                Arguments.of(List.of(new WinningEntry("1")))
        );
    }

    @ParameterizedTest(name = "전체 당첨항목 수를 구할 수 있다(ex: [{0} - {1}개])")
    @CsvSource(value = {
            "산,바다,말랑:3",
            "바다,산,말랑,토끼:4",
            "바다,산,말랑,토끼,포비,기차,음,냐,냥:9"
    }, delimiter = ':')
    void 가진_당참항목의_총_개수를_알_수_있다(final String values, final int actualLength) {
        // given
        WinningEntries winningEntries = WinningEntries.forNames(
                stream(values.split(","))
                        .map(WinningEntry::new)
                        .collect(Collectors.toList()),
                new Names(stream(values.split(","))
                        .map(Name::new)
                        .collect(Collectors.toList()))
        );

        // when
        int size = winningEntries.size();

        // then
        assertThat(size).isEqualTo(actualLength);
    }

    @ParameterizedTest(name = "특정 순서에 해당하는 당첨항목을 알 수 있다. 예를 들어 [{0}] 에서 [{1}]의 위치에 존재하는 당첨항목은 [{2}] 이다.")
    @CsvSource(value = {
            "바다,말랑:0:바다",
            "바다,말랑,산,토끼,당근:2:산",
    }, delimiter = ':')
    void 특정_순서에_해당하는_당첨항목을_알_수_있다(final String values, final int index, final String entryValue) {
        // given
        WinningEntries winningEntries = WinningEntries.forNames(
                stream(values.split(","))
                        .map(WinningEntry::new)
                        .collect(Collectors.toList()),
                new Names(stream(values.split(","))
                        .map(Name::new)
                        .collect(Collectors.toList()))
        );

        // when & then
        assertThat(winningEntries.get(index)).isEqualTo(new WinningEntry(entryValue));
    }
}