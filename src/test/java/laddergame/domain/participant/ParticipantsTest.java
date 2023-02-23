package laddergame.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ParticipantsTest {

    private static final String ERROR_MESSAGE_HEAD = "[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi"})
    @DisplayName("입력받은 이름에 중복값이 존재하면, 예외가 발생한다.")
    void throws_exception_if_names_contain_duplicates(String names) {
        assertThatThrownBy(() -> Participants.create(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HEAD);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    @DisplayName("입력받은 참여자의 수가 1명이면, 예외가 발생한다.")
    void throws_exception_if_names_consist_of_one_name(String names) {
        assertThatThrownBy(() -> Participants.create(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HEAD);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,jiwon,hoocu:3", "choco,jelly,pen,water:4"}, delimiter = ':')
    @DisplayName("Participants 객체의 사이즈가 입력된 이름의 개수와 같은지 확인한다.")
    void is_same_size_as_the_number_of_names(String names, int expectedSize) {
        // given
        Participants participants = Participants.create(names);

        // when
        int actualSize = participants.size();

        // then
        assertThat(actualSize).isEqualTo(expectedSize);
    }
}
