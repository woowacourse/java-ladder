package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipantsTest {

    @Test
    @DisplayName("참가자 이름을 쉼표 기준으로 구분한다.")
    void splitNamesTest() {
        // given
        String names = "a, b, c, d";
        List<String> expectNames = List.of("a", "b", "c", "d");

        // when
        Participants participants = new Participants(names);

        // then
        List<Participant> actualParticipants = participants.getValues();
        assertThat(actualParticipants)
                .hasSize(4)
                .extracting(Participant::getName)
                .containsAll(expectNames);
    }

    @ParameterizedTest
    @ValueSource(strings = {",mia, pota", ",,", "mia,"})
    @DisplayName("문자열 시작 혹은 끝이 쉼표일 경우 예외가 발생한다.")
    void checkNamesSideTest(String names) {
        // when & then
        assertThatThrownBy(() -> new Participants(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참가자 수를 조회한다.")
    void getParticipantsCountTest() {
        // given
        String names = "mia, pota, dora";
        Participants participants = new Participants(names);

        // when
        int count = participants.getCount();

        // then
        assertEquals(3, count);
    }
}
