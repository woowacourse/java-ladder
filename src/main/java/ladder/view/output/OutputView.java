package ladder.view.output;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.participant.Participant;
import ladder.domain.participant.ParticipantGroup;
import ladder.domain.result.Result;
import ladder.domain.result.ResultGroup;

import java.util.Map;

public class OutputView {
    public static void outputParticipants(ParticipantGroup participantGroup) {
        for (Participant participant : participantGroup.getParticipants()) {
            System.out.printf("%-6s", participant);
        }
        System.out.println();
    }

    public static void outputLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.println(line);
        }
    }

    public static void outputResults(ResultGroup resultGroup) {
        for (Result result : resultGroup.getResults()) {
            System.out.printf("%-6s", result);
        }
        System.out.println();
    }

    public static void outputResult(String name, Map<String, Result> result) {
        System.out.println("실행 결과");
        if (result.keySet().contains(name)) {
            System.out.println(result.get(name));
            return;
        }
        if (name.equals("all")) {
            outputResultAll(result);
            return;
        }
        System.out.println("존재하지 않습니다.");
    }

    private static void outputResultAll(Map<String, Result> result) {
        for (Map.Entry<String, Result> resultEntry : result.entrySet()) {
            System.out.println(resultEntry.getKey() + " : " + resultEntry.getValue());
        }
    }
}
