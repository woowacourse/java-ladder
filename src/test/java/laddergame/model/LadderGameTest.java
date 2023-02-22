package laddergame.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import laddergame.model.Ladder.Height;
import laddergame.model.Ladder.Ladder;
import laddergame.model.Ladder.Line;

class LadderGameTest {
    private Participants participants;
    private Height height;

    @BeforeEach
    void init() {
        this.participants = new Participants(List.of("name1", "name2", "name3"));
        this.height = new Height(2);
    }

    @Test
    @DisplayName("오류 없는 값으로 생성자를 생성하면 오류가 발생하지 않는다.")
    void Should_Success_When_ResultInput() {
        Ladder ladder = new Ladder(height, participants);
        Rewards rewards = new Rewards(List.of("꽝", "1000", "2000"), participants);
        assertDoesNotThrow(() -> new LadderGame(ladder, rewards, participants));
    }

    @ParameterizedTest
    @CsvSource(value = {"name1:2000", "name2:꽝", "name3:1000"}, delimiter = ':')
    @DisplayName("원하는 값을 입력했을때 사다리와 리워드 매칭이 똑같아야 한다")
    void Should_Equals_ExpectedWithRunResult(String input, String expected) {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(List.of(true, false)));
        lines.add(new Line(List.of(false, true)));
        Ladder ladder = new Ladder(height, lines);
        Rewards rewards = new Rewards(List.of("꽝", "1000", "2000"), participants);
        LadderGame ladderGame = new LadderGame(ladder, rewards, participants);

        assertThat(ladderGame.getReward(input)).isEqualTo(expected);
    }
}
