package model.result;

import dto.GameResultsDto;
import dto.ParticipantName;
import dto.PrizeName;
import java.util.LinkedHashMap;
import java.util.Map;
import model.participant.Participant;
import model.prize.Prize;
import utils.Constant;

public class GameResults {
    private final Map<Participant, Prize> gameResults;

    public GameResults(Map<Participant, Prize> gameResults) {
        this.gameResults = gameResults;
    }

    public GameResultsDto getResultsByTargetName(String name) {
        if (name.equals(Constant.TOTAL_RESULT_KEYWORD)) {
            return convertTotalResultsToDto();
        }
        Map<Participant, Prize> findResult = new LinkedHashMap<>();
        gameResults.entrySet().stream()
                .filter(entry -> entry.getKey().getName().equals(name))
                .forEach(entry -> findResult.put(entry.getKey(), entry.getValue()));
        return convertEachResultToDto(findResult);
    }

    public GameResultsDto convertTotalResultsToDto() {
        Map<ParticipantName, PrizeName> gameResultsDto = new LinkedHashMap<>();
        for (Map.Entry<Participant, Prize> entry : gameResults.entrySet()) {
            ParticipantName participantName = entry.getKey().convertToParticipantName();
            PrizeName prizeName = entry.getValue().convertToPrizeName();
            gameResultsDto.put(participantName, prizeName);
        }
        return new GameResultsDto(gameResultsDto);
    }

    private GameResultsDto convertEachResultToDto(Map<Participant, Prize> eachResult) {
        Map<ParticipantName, PrizeName> convertedResult = new LinkedHashMap<>();
        eachResult.forEach((participant, prize) ->
                convertedResult.put(participant.convertToParticipantName(), prize.convertToPrizeName()));
        return new GameResultsDto(convertedResult);
    }

    public Map<Participant, Prize> getGameResults() {
        return gameResults;
    }
}
