package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import strategy.FixedPassGenerator;

class LadderMakerTest {

    private final LadderMaker ladderMaker = new LadderMaker(new FixedPassGenerator(false));

    @Test
    void initLadder_메소드는_Height와_참가자_수를_입력하면_ladder를_초기화_한다() {
        assertThatCode(() -> ladderMaker.initLadder(new Height(3), 5))
                .doesNotThrowAnyException();
    }

    @Test
    void getLadder_메소드는_ladder를_반환한다() {
        Height height = new Height(3);
        ladderMaker.initLadder(height, 5);

        Ladder ladder = ladderMaker.getLadder();
        List<Line> lines = ladder.getLines();

        assertThat(lines.size()).isSameAs(3);
        assertThat(lines.get(0).getLine().size()).isSameAs(4);
    }

    @Test
    void initParticipants_메소드는_참가자의_이름을_전달하면_participants를_초기화한다() {
        assertThatCode(() -> ladderMaker.initParticipants(List.of("pobi", "honux", "crong", "jk")))
                .doesNotThrowAnyException();
    }
    
    @Test
    void getParticipantsName_메소드는_참가자의_이름을_반환한다() {
        List<String> participantsName = List.of("pobi", "honux", "crong", "jk");
        ladderMaker.initParticipants(participantsName);
        Names names = ladderMaker.getParticipantsName();

        assertThat(names.getNames().stream().map(Name::getName).collect(Collectors.toList()))
                .containsExactly(participantsName.toArray(new String[0]));
    }
}