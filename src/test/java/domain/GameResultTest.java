package domain;

import builder.LadderGameBuilder;
import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.ladder.LadderResults;
import domain.ladder.LadderSize;
import domain.ladder.LineWeight;
import domain.participants.Participants;
import exception.participants.NullNameException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @DisplayName("게임 실행 결과를 생성한다.")
    @Test
    void getGameResult() {
        //given
        TestBooleanGenerator testGenerator = new TestBooleanGenerator();
        testGenerator.addOrderedValues(List.of(true, false, false, true, false));
        LadderGameBuilder ladderGameBuilder = new LadderGameBuilder();
        Participants participants = new Participants("ash,split,ako,mako,heero,bever");
        LadderGame ladderGame = ladderGameBuilder
            .addParticipants(participants)
            .addLadder(
                Ladder.valueOf(new LadderSize(new LadderHeight("1"), new LineWeight(participants.getCount() - 1)),
                    testGenerator))
            .addLadderResults(new LadderResults("1000,2000,3000,4000,5000,6000", 6))
            .build();
        //when
        GameResult gameResult = GameResult.from(ladderGame);
        //then
        Assertions.assertThat(gameResult.getResultByName("ash").getName()).isEqualTo("2000");
        Assertions.assertThat(gameResult.getResultByName("split").getName()).isEqualTo("1000");
        Assertions.assertThat(gameResult.getResultByName("ako").getName()).isEqualTo("3000");
        Assertions.assertThat(gameResult.getResultByName("mako").getName()).isEqualTo("4000");
        Assertions.assertThat(gameResult.getResultByName("heero").getName()).isEqualTo("6000");
        Assertions.assertThat(gameResult.getResultByName("bever").getName()).isEqualTo("5000");
    }

    @DisplayName("존재하지 않는 참가자의 결과를 조회시 오류를 던진다.")
    @Test
    void noParticipant() {
        //given
        //테스트 Boolean 생성
        TestBooleanGenerator testGenerator = new TestBooleanGenerator();
        testGenerator.addOrderedValues(List.of(true, false, false, true, false));

        //LadderGame 생성
        Participants participants = new Participants("split,jamie");
        LadderGameBuilder ladderGameBuilder = new LadderGameBuilder();
        LineWeight lineWeight = new LineWeight(participants.getCount() - 1);
        LadderHeight ladderHeight = new LadderHeight("1");
        LadderSize ladderSize = new LadderSize(ladderHeight, lineWeight);
        Ladder ladder = Ladder.valueOf(ladderSize, testGenerator);
        LadderGame ladderGame = ladderGameBuilder
            .addParticipants(participants)
            .addLadder(ladder)
            .addLadderResults(new LadderResults("1000,2000", 2))
            .build();

        //GameResult 생성
        GameResult gameResult = GameResult.from(ladderGame);

        //when, then
        Assertions.assertThatThrownBy(() -> gameResult.getResultByName("none"))
            .isExactlyInstanceOf(NullNameException.class);
    }
}
