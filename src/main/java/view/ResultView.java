package view;

import dto.ParticipantName;
import dto.PrizeName;
import dto.ResultsDto;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ResultView {
    public void printResult(ResultsDto resultsDto, ParticipantName participantName, List<PrizeName> prizeNames) {
        System.out.println("실행결과");
        if (participantName.name().equals("all")) {
            printTotalResultS(resultsDto, prizeNames);
            return;
        }
        int index = resultsDto.results().get(participantName);
        System.out.println(prizeNames.get(index).prizeName());
    }

    private void printTotalResultS(ResultsDto resultsDto, List<PrizeName> prizeNames) {
        Set<Entry<ParticipantName, Integer>> set = resultsDto.results().entrySet();
        set.stream().forEach(
                e -> System.out.println(e.getKey().name() + " : " + prizeNames.get(e.getValue()).prizeName()));
    }
}
