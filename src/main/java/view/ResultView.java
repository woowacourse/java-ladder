package view;

import dto.ParticipantName;
import dto.PrizeName;
import dto.ResultsDto;
import java.util.List;

public class ResultView {
    public void printResult(ResultsDto resultsDto, ParticipantName participantName, List<PrizeName> prizeNames) {
        int index = resultsDto.results().get(participantName);
        System.out.println("실행결과\n" + prizeNames.get(index).prizeName());
    }
}
