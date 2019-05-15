package ladder.model;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private static String NIL = "꽝";

    private final List<Person> people;
    private final List<String> rewards;
    private final Ladder ladder;

    public Game(List<Person> people, List<String> rewards, int height) {
        if (people.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.people = people;
        this.rewards = rewards;
        adjustInputs();
        ladder = new Ladder(people.size(), height, new Coin());
    }

    private void adjustInputs() {
        while (people.size() > rewards.size()) {
            rewards.add(NIL);
        }
        while (people.size() < rewards.size()) {
            rewards.remove(0);
        }
    }

    public Map<String, String> getResultOf(String name) {
        if (name.equals("all")) {
            return all();
        }
        return some(name);
    }

    private Map<String, String> all() {
        return new LinkedHashMap<String, String>() {{
            final List<String> result = ladder.apply(rewards);
            for (int i = 0; i < people.size(); i++) {
                put(people.get(i).toString(), result.get(i));
            }
        }};
    }

    private Map<String, String> some(String name) {
        final int index = people.stream().map(x -> x.toString()).collect(Collectors.toList()).indexOf(name);
        if (index < 0) {
            return new HashMap<>();
        }
        return new HashMap<String, String>() {{
            put(people.get(index).toString(), ladder.apply(rewards).get(index));
        }};
    }

    public List<String> getNames() {
        return people.stream().map(x -> x.toString()).collect(Collectors.toList());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getRewards() {
        return rewards;
    }

    public int getMaxWordLength() {
        return Math.max(Collections.max(people).getNameLength(), Collections.max(rewards.stream().map(x -> x.length()).collect(Collectors.toList())));
    }
}