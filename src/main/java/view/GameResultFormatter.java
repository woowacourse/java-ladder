package view;

import domain.Collection.Participant;
import domain.Collection.Participants;
import domain.Collection.Result;

import java.util.Map;
import java.util.stream.Collectors;

public class GameResultFormatter {
    private static final String ALL_GAME_RESULT_FORMAT = "%s : %s";
    
    public static String formatGameResult( Result result ) {
        return result.getValue();
    }
    
    public static String formatAllGameResults( Participants participants, Map<Participant, Result> results ) {
        return participants.getParticipants().stream()
                .map(p -> GameResultFormatter.printNameWithResult(p, results.get(p)))
                .collect(Collectors.joining(System.lineSeparator()));
    }
    
    private static String printNameWithResult( Participant participant, Result result ) {
        return String.format(ALL_GAME_RESULT_FORMAT, participant.getName(), result.getValue());
    }
}
