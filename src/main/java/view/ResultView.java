package view;

import dto.GameResultsDto;
import dto.ParticipantName;

public class ResultView {
    public void printResult(GameResultsDto gameResultsDto, ParticipantName participantName) {
        System.out.println("실행결과");
        if (participantName.name().equals("all")) {
            printTotalResultS(gameResultsDto);
            return;
        }
        System.out.println(gameResultsDto.gameResults().get(participantName));
    }

    private void printTotalResultS(GameResultsDto gameResultsDto) {
        gameResultsDto.gameResults().entrySet().forEach(
                result -> System.out.println(result.getKey().name() + " : " + result.getValue().prizeName()));
    }
}
