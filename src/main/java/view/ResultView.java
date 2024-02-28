package view;

import dto.GameResultsDto;
import dto.ParticipantName;

public class ResultView {
    private static final String RESULT_TITLE = "\n실행결과";
    private static final String TOTAL_RESULT_KEYWORD = "all";

    public void printResult(GameResultsDto gameResultsDto, ParticipantName participantName) {
        System.out.println(RESULT_TITLE);
        if (participantName.name().equals(TOTAL_RESULT_KEYWORD)) {
            printTotalResults(gameResultsDto);
            return;
        }
        System.out.println(gameResultsDto.getPrizeNameByParticipantName(participantName).prizeName());
    }

    private void printTotalResults(GameResultsDto gameResultsDto) {
        gameResultsDto.gameResults().entrySet().forEach(
                result -> System.out.println(
                        result.getKey().name() + " : " + result.getValue().prizeName()));
    }
}
