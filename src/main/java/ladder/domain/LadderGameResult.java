package ladder.domain;

import ladder.domain.Reward.Reward;
import ladder.domain.participant.Participant;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LadderGameResult {
    private final Map<Participant, Reward> gameResult;
    private final String END_COMMAND = "all";
    private final int END_COMMAND_LENGTH = 1;
    private final int END_COMMAND_NUM = 1;

    private boolean isEnd;

    public LadderGameResult(final Map<Participant, Reward> gameResult) {
        this.gameResult = gameResult;
        this.isEnd = false;
    }

    private Participant findParticipant(final String name) {
        Optional<Participant> participant = gameResult.keySet().stream()
                .filter(x -> x.toString().equals(name))
                .findFirst();
        if (participant.isPresent()) {
            return participant.get();
        }
        throw new IllegalArgumentException("등록되지 않은 참가자 입니다.");
    }

    public Map<String, String> getResult(List<String> names) {
        names = checkInput(names);
        LinkedHashMap<String, String> gameResult = new LinkedHashMap<>();
        names.stream().forEach(name -> gameResult.put(name, this.gameResult.get(findParticipant(name)).toString()));
        return gameResult;
    }

    private List<String> checkInput(final List<String> names) {
        if (names.size() == END_COMMAND_LENGTH && names.get(END_COMMAND_NUM).toLowerCase().equals(END_COMMAND)) {
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
