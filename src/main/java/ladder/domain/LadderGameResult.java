package ladder.domain;

import ladder.domain.participant.Participant;
import ladder.domain.participant.ParticipantGroup;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LadderGameResult {
    private Map<Participant, String> gameResult = new LinkedHashMap<>();
    private boolean isEnd = false;

    public LadderGameResult(ParticipantGroup participantGroup, Rewards rewards, List<Integer> ranking) {
        for (Participant participant : participantGroup.getParticipantList()) {
            gameResult.put(participant, rewards.getNthReward(ranking.get(participantGroup.getOrder(participant))));
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
        LinkedHashMap<String, String> gameResult = new LinkedHashMap<>();
        names.stream().forEach(name -> gameResult.put(name, this.gameResult.get(findParticipant(name))));
        return gameResult;
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

    public boolean isEnd() {
        return isEnd;
    }
}
