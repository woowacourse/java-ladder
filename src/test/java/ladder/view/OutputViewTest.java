package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.Line;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    void 참여자_이름이_다섯글자_미만이면_공백으로_채운다() {
        String playerDisplay = String.format("%5s", "hey");
        System.out.println(playerDisplay);
    }

    @Test
    void Stream을_이용해서_분리하는_테스트() {
        List<String> players = List.of("도이", "주노", "여우", "블랙캣", "abcde");
        String result = players.stream()
                .map(name -> String.format("%6s", name))
                .collect(Collectors.joining());
        System.out.println(result);
    }

    @Test
    void 게임결과를_출력하는_테스트() {
        List<String> players = List.of("도이222", "주노rrr", "여우ㅁㅁㅁ", "블랙캣ㅇㅇ", "abcde");
        List<Line> lines = List.of(new Line(5), new Line(5), new Line(5), new Line(5));

        OutputView.showGameResult(players, lines);
    }
}
