package ladder.model;

import java.util.*;

public class Result implements Iterator {
    private List<String> people = new ArrayList<>();
    private List<String> rewards = new ArrayList<>();
    private int index = 0;

    Result(List<Person> people, List<String> rewards, List<String> query) {
        for (int i = 0; i < people.size(); i++) {
            if (query.contains("all") || query.contains(people.get(i).toString())) {
                this.people.add(people.get(i).toString());
                this.rewards.add(rewards.get(i));
            }
        }
    }
    public boolean hasNext() {
        return index < people.size();
    }

    public Map<String, String> next() {
        return new HashMap<String, String>() {{
            put(people.get(index), rewards.get(index));
            index++;
        }};
    }
}
