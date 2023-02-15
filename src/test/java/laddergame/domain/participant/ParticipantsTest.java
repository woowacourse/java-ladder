package laddergame.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ParticipantsTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi"})
    @DisplayName("입력받은 이름에 중복값이 존재하면, 예외가 발생한다.")
    void name_duplicate_error_test(String names)  {
        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    @DisplayName("입력받은 참여자의 수가 1명이면, 예외가 발생한다.")
    void participant_single_count_error_test(String names) {
        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,jiwon,hoocu:3", "choco,jelly,pen,water:4"}, delimiter=':')
    @DisplayName("참여자 이름의 수에 따라, 참여자 수의 반환값이 달라진다.")
    void participant_size_test(String names, int expectedSize) {
        // given
        Participants participants = new Participants(names);

        // when
        int actualSize = participants.size();

        // then
        assertThat(actualSize).isEqualTo(expectedSize);
    }
}
