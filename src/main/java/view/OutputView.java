package view;

import domain.Map;
import domain.Participants;
import java.util.List;

public class OutputView {

    public void printMap(Participants participants, Map map) {
        StringBuilder mapResult = new StringBuilder();
        setNames(mapResult, participants);
        setLadders(mapResult, map);
        System.out.println(mapResult);
    }

    private void setNames(StringBuilder mapResult, Participants participants) {
        participants.getParticipantsNames();
        for (String participantsName : participants.getParticipantsNames()) {
            mapResult.append(reformatName(participantsName));
        }
        mapResult.append("\n");
    }

    private void setLadders(StringBuilder mapResult, Map map) {
        List<List<Boolean>> lines = map.getLines();
        for (List<Boolean> line : lines) {
            mapResult.append(reformatLadder(line));
        }
    }

    private String reformatName(String name) {
        return String.format("%5s ", name);
    }

    private String reformatLadder(List<Boolean> lineStatus) {
        StringBuilder result = new StringBuilder();
        result.append("    |");
        for (Boolean status : lineStatus) {
            if (status) {
                result.append("-----");
            } else {
                result.append("     ");
            }
            result.append("|");
        }
        result.append("\n");
        return result.toString();
    }
}
