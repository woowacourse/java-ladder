package laddergame.view;

import laddergame.domain.player.Player;
import laddergame.domain.result.Result;
import laddergame.dto.DrawnLadderDto;

import java.util.List;

public class OutputView {

    public void printDrawnLadder(final DrawnLadderDto drawnLadderDto) {
        System.out.println(
                "사다리 결과" + System.lineSeparator() +
                        InputFormatter.formatNames(drawnLadderDto.names()) + System.lineSeparator() +
                        LadderFormatter.formatLadder(drawnLadderDto) + System.lineSeparator() +
                        InputFormatter.formatTargets(drawnLadderDto.targets())
        );
    }

    public void printResult(final List<Player> player, final Result result) {
        System.out.println("실행 결과");

        if (player.size()==1) {
            System.out.println(result.getResult().get(player.get(0).getName()));
        } else {
            result.getResult().entrySet()
                    .stream()
                    .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
        }
    }

    public void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
