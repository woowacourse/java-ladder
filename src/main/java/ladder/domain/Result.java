package ladder.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public HashMap<String,String> getResult(List<String> names){
        names = convertAllToNames(names);
        LinkedHashMap<String, String> multiResult = new LinkedHashMap<>();
        names.stream().forEach(name -> multiResult.put(name, eachGetResult(name)));
        return multiResult;
    }

    private List<String> convertAllToNames(List<String> names) {
        if(names.size() == 1 && names.get(0).toLowerCase().equals("all")) {
            return participants.stream().map(x -> x.toString()).collect(Collectors.toList());
        }
        return names;
    }

}
