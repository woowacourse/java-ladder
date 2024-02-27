package laddergame.view;

import laddergame.domain.player.Player;
import laddergame.domain.result.Result;
import laddergame.dto.DrawnLadderDto;

public class OutputView {

    public void printLadder(final DrawnLadderDto drawnLadderDto) {
        System.out.println(
                "사다리 결과" + System.lineSeparator() +
                        InputFormatter.formatNames(drawnLadderDto.names()) + System.lineSeparator() +
                        LadderFormatter.formatLadder(drawnLadderDto) + System.lineSeparator() +
                        InputFormatter.formatTargets(drawnLadderDto.targets()) + System.lineSeparator()
        );
    }

    public void printResultAll(final Result result) {
        System.out.println("실행 결과");
        result.getResult().entrySet()
                .stream()
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }

    public void printResult(final Player player, final Result result) {
        System.out.println("실행 결과");
        System.out.println(result.getResult().get(player.getName()));
    }

    public void printExceptionMessage(final String message) {
        printLine();
        System.out.println(message);
        printLine();
    }

    public void printLine() {
        System.lineSeparator();
    }
}
