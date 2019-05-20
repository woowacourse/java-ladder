package ladder.domain;

import ladder.domain.participant.Participant;
import ladder.domain.reward.Reward;

import java.util.*;
import java.util.stream.Collectors;

public class LadderGameResult {
    private final Map<Participant, Reward> ladderGameResult;

    public LadderGameResult(final Map<Participant, Reward> ladderGameResult) {
        this.ladderGameResult = Collections.unmodifiableMap(ladderGameResult);
    }

    public Map<String, String> getResult(List<String> names) {
        names = checkInput(names);
        LinkedHashMap<String, String> gameResult = new LinkedHashMap<>();
        names.forEach(name -> gameResult.put(name, this.ladderGameResult.get(findParticipant(name)).toString()));
        return Collections.unmodifiableMap(gameResult);
    }

    private List<String> checkInput(final List<String> names) {
        if (names.size() == 1 && names.get(0).toLowerCase().equals("all")) {
            return ladderGameResult.keySet().stream()
                    .map(x -> x.toString())
                    .collect(Collectors.toList());
        }
        return names;
    }

    private Participant findParticipant(final String name) {
        Optional<Participant> participant = ladderGameResult.keySet().stream()
                .filter(x -> x.toString().equals(name))
                .findFirst();
        if (participant.isPresent()) {
            return participant.get();
        }
        throw new IllegalArgumentException("등록되지 않은 참가자입니다.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGameResult result = (LadderGameResult) o;
        return ladderGameResult.equals(result.ladderGameResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderGameResult);
    }
}
