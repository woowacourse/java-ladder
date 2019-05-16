package ladder.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Result {
    HashMap<Participant, String> gameResult = new LinkedHashMap<>();
    private boolean isEnd = false;
    public Result(List<Participant> participants, List<String> rewards, List<Integer> ladderNumbers) {
        for (Participant participant : participants) {
            gameResult.put(participant, rewards.get(ladderNumbers.get(participants.indexOf(participant))));
        }
    }

    private Participant findParticipant(String name) {
        Optional<Participant> participant = gameResult.keySet().stream()
                .filter(x -> x.toString().equals(name))
                .findFirst();
        if (participant.isPresent()) {
            return participant.get();
        }
        throw new IllegalArgumentException("등록되지 않은 참가자 입니다.");
    }

    public HashMap<String, String> getResult(List<String> names) {
        names = checkInput(names);
        LinkedHashMap<String, String> multiResult = new LinkedHashMap<>();
        names.stream().forEach(name -> multiResult.put(name, gameResult.get(findParticipant(name))));
        return multiResult;
    }

    private List<String> checkInput(List<String> names) {
        if (names.size() == 1 && names.get(0).toLowerCase().equals("all")) {
            isEnd = true;
            return gameResult.keySet().stream()
                    .map(x -> x.toString())
                    .collect(Collectors.toList());
        }
        return names;
    }

    public boolean getIsEnd(){
        return isEnd;
    }
}
