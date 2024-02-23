package laddergame.view;

import laddergame.dto.GameResultDto;

public class OutputView {

    public void printResult(final GameResultDto gameDto) {
        System.out.println(
                "실행결과" + System.lineSeparator() +
                        NameFormatter.formatNames(gameDto.names()) + System.lineSeparator() +
                        LadderFormatter.formatLadder(gameDto)
        );
    }

    public void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
