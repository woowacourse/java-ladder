package ladder.model;

import java.util.Collections;
import java.util.List;
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

    public List<String> getNames() {
        return people.stream().map(x -> x.toString()).collect(Collectors.toList());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getRewards() {
        return rewards;
    }

    public Result getResultOf(List<String> query) {
        return new Result(people, ladder.apply(rewards), query);
    }

    public int getMaxWordLength() {
        return Math.max(Collections.max(people).getNameLength(), Collections.max(rewards.stream().map(x -> x.length()).collect(Collectors.toList())));
    }
}