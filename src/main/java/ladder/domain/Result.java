package ladder.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public class Result {
    List<Participant> participants;
    List<String> resultValues;

    public Result(List<Participant> participants, List<String> resultValues) {
        this.participants = participants;
        this.resultValues = resultValues;

    }

    public String eachGetResult(String name) {
        return resultValues.get(participants.indexOf(findParticipant(name)));
    }

    private Participant findParticipant(String name) {
        Optional<Participant> p = participants.stream().filter(x -> x.toString().equals(name)).findFirst();
        if (p.isPresent()) {
            return p.get();
        }
        throw new IllegalArgumentException("등록되지 않은 참가자 입니다.");
    }

    public HashMap<String,String> multiGetResult(List<String> names){
        LinkedHashMap<String, String> multiResult = new LinkedHashMap<String, String>();
        names.stream().forEach(name -> multiResult.put(name, eachGetResult(name)));
        return multiResult;

    }

}
