package laddergame.view;

import laddergame.dto.DrawnLadderDto;

public class OutputView {

    public void printResult(final DrawnLadderDto gameDto) {
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
