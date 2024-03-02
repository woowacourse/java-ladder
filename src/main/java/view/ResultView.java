package view;

import dto.GameResultsDto;
import utils.Constant;

public class ResultView {
    private static final String RESULT_TITLE = "\n실행결과";

    public void printResult(GameResultsDto gameResultsDto, String targetName) {
        System.out.println(RESULT_TITLE);
        if (targetName.equals(Constant.TOTAL_RESULT_KEYWORD)) {
            printTotalResults(gameResultsDto);
            return;
        }
        printOneResult(gameResultsDto);
    }

    private void printTotalResults(GameResultsDto gameResultsDto) {
        gameResultsDto.gameResults().entrySet().forEach(
                result -> System.out.println(
                        result.getKey().name() + " : " + result.getValue().prizeName()));
    }

    private void printOneResult(GameResultsDto gameResultsDto) {
        gameResultsDto.gameResults().values()
                .forEach(prize -> System.out.println(prize.prizeName()));
    }
}
