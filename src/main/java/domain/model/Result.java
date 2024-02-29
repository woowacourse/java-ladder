package domain.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private final People people;
    private final Consequences consequences;
    private final Map<String, String> result = new LinkedHashMap<>();
    public Result(People people, Consequences consequences) {
        this.people = people;
        this.consequences = consequences;
    }

    public void make(int positionOfPerson,int positionOfConsequence){
        String name= people.getNameByOrder(positionOfPerson);
        String consequence = consequences.getConsequenceByOrder(positionOfConsequence);
        result.put(name, consequence);
    }

    public Map<String,String> giveResult(){
        return Collections.unmodifiableMap(new LinkedHashMap<>(result));
    }
}

