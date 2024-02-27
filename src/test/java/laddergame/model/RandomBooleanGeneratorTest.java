package laddergame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomBooleanGeneratorTest {
    @DisplayName("높이와 수량을 입력받아 선 리스트를 반환한다.")
    @Nested
    class getLines {
        @DisplayName("높이 만큼의 크기를 갖는 List<Line>을 반환한다.")
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 4, 10, 100})
        void getLinesDiffHeight(int height) {
            LadderHeight given = new LadderHeight(height);
            Participants participants = new Participants(
                    List.of(
                            new Participant("daon"),
                            new Participant("mason"),
                            new Participant("ted")
                    ));
            RandomLinesGenerator randomGenerator = new RandomLinesGenerator();
            List<Line> result = randomGenerator.getLines(given, participants);

            assertThat(result).hasSize(height);
        }

        @DisplayName("각 Line은 count만큼의 크기를 갖는 List<Line>을 반환한다.")
        @ParameterizedTest
        @ValueSource(ints = {3, 5, 10, 12})
        void getLinesDiffCount(int count) {
            LadderHeight ladderHeight = new LadderHeight(3);
            Participants participants = generateParticipants(count);
            RandomLinesGenerator randomGenerator = new RandomLinesGenerator();
            List<Line> result = randomGenerator.getLines(ladderHeight, participants);

            assertAll(
                    () -> assertThat(result.get(0).getLineStates()).hasSize(count),
                    () -> assertThat(result.get(1).getLineStates()).hasSize(count),
                    () -> assertThat(result.get(2).getLineStates()).hasSize(count)
            );
        }

        private Participants generateParticipants(int count) {
            List<Participant> participants = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                participants.add(new Participant(String.valueOf(i)));
            }
            return new Participants(participants);
        }
    }
}
